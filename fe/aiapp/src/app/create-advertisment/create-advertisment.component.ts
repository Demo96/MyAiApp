import { Component, OnInit } from '@angular/core';
import { Advertisment } from '../advertisment';
import { AdvertismentService } from '../advertisment.service';
import { Router } from '@angular/router';
import { TokenStorageService } from '../auth/token-storage.service';
import { ImageService } from '../image.service';

@Component({
  selector: 'app-create-advertisment',
  templateUrl: './create-advertisment.component.html',
  styleUrls: ['./create-advertisment.component.scss']
})
export class CreateAdvertismentComponent implements OnInit {
  advertisment: Advertisment = new Advertisment();
  submitted = false;
  img: any;
  isAdded = false;
  constructor(private tokenStorage: TokenStorageService, private advertismentService: AdvertismentService, private router: Router, private imageService: ImageService) { }
  ngOnInit() {
    this.setAdvertismentUser();
  }

  save() {
    this.advertismentService.creatAdvertisment(this.advertisment).subscribe();
      if(this.img) {
    const uploadData = new FormData();
    uploadData.append('file', this.img, this.img.name);
    this.imageService.uploadImage(this.advertisment.id, uploadData).subscribe((error => console.log(error)));
    
    this.img= null;
  }
    this.advertisment = new Advertisment();
    this.setAdvertismentUser();
    this.submitted = false;
    this.isAdded=true;
  }

preSubmit()
{
  this.isAdded=false;
  this.submitted=true;
  return true;
}

  onSubmit() {
    this.submitted = true;
    this.save();
  }

  setAdvertismentUser() {
    this.advertisment.userName = this.tokenStorage.getUsername();
  }

  onFileChanged(event) {
    this.img = event.target.files[0];
    this.advertisment.image=this.advertisment.id+this.img.name;
  }
}