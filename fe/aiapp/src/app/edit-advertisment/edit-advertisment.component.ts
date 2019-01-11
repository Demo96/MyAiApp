import { Component, OnInit } from '@angular/core';
import { Advertisment } from '../advertisment';
import { TokenStorageService } from '../auth/token-storage.service';
import { AdvertismentService } from '../advertisment.service';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-edit-advertisment',
  templateUrl: './edit-advertisment.component.html',
  styleUrls: ['./edit-advertisment.component.scss']
})
export class EditAdvertismentComponent implements OnInit {
  advertisment: Advertisment = new Advertisment();

  constructor(private tokenStorage: TokenStorageService, private advertismentService: AdvertismentService, private route: ActivatedRoute) { }

  ngOnInit() {
    this.getAdvertisment();
  }

  getAdvertisment() {
    this.route.params.subscribe(param => {
      this.advertismentService.getAdvertisment(+param["id"]).subscribe(adv => { this.advertisment = adv;});
    });
  }
  updateAdvertisment() {
    this.route.params.subscribe(param => {
      this.advertismentService.updateAdvertisment(+param["id"],this.advertisment).subscribe(() =>     this.getAdvertisment());
    });

  }
}
