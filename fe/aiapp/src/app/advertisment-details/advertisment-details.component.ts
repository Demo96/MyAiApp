import { Component, OnInit, Input } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { AdvertismentService } from '../advertisment.service';
import { Advertisment } from '../advertisment';
@Component({
  selector: 'app-advertisment-details',
  templateUrl: './advertisment-details.component.html',
  styleUrls: ['./advertisment-details.component.scss']
})
export class AdvertismentDetailsComponent implements OnInit {
  advertisment: Object;
  constructor(private advertismentService: AdvertismentService, private route: ActivatedRoute) { }

  ngOnInit() {
    this.advertisment = new Advertisment();
    this.route.params.subscribe(param => {
      console.log(+param["id"]);
      this.advertismentService.getAdvertisment(+param["id"]).subscribe(adv => { this.advertisment = adv;});
    });
  }
  deleteAdvertisment(id: number)
  {
    this.advertismentService.deleteAdvertisment(id).subscribe(() => window.location.href = '..');
  }
}
