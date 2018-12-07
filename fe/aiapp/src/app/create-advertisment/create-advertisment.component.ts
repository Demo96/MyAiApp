import { Component, OnInit } from '@angular/core';
import { Advertisment } from '../advertisment';
import { AdvertismentService } from '../advertisment.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-advertisment',
  templateUrl: './create-advertisment.component.html',
  styleUrls: ['./create-advertisment.component.scss']
})
export class CreateAdvertismentComponent implements OnInit {
  advertisment: Advertisment = new Advertisment();
  submitted = false;
  constructor(private advertismentService: AdvertismentService,private router: Router) { }

  ngOnInit() {
  }

  save() {
    this.advertismentService.creatAdvertisment(this.advertisment)
      .subscribe(data => console.log(data), error => console.log(error));
    this.advertisment = new Advertisment();
  }

  onSubmit() {
    this.submitted = true;
    this.save();
  }

}
