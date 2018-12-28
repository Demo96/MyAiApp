import { Component, OnInit } from '@angular/core';
import { Advertisment } from '../advertisment';
import { AdvertismentService } from '../advertisment.service';
import { Router } from '@angular/router';
import { TokenStorageService } from '../auth/token-storage.service';

@Component({
  selector: 'app-create-advertisment',
  templateUrl: './create-advertisment.component.html',
  styleUrls: ['./create-advertisment.component.scss']
})
export class CreateAdvertismentComponent implements OnInit {
  advertisment: Advertisment = new Advertisment();
  submitted = false;
  constructor(private tokenStorage: TokenStorageService, private advertismentService: AdvertismentService, private router: Router) { }

  ngOnInit() {
    this.setAdvertismentUser();
  }

  save() {
    this.advertismentService.creatAdvertisment(this.advertisment)
      .subscribe(data => console.log(data), error => console.log(error));
    this.advertisment = new Advertisment();
    this.setAdvertismentUser();
  }

  onSubmit() {
    this.submitted = true;
    this.save();
  }

  setAdvertismentUser() {
    this.advertisment.userName = this.tokenStorage.getUsername();
  }
}