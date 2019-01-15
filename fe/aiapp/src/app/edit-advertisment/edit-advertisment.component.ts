import { Component, OnInit } from '@angular/core';
import { Advertisment } from '../advertisment';
import { TokenStorageService } from '../auth/token-storage.service';
import { AdvertismentService } from '../advertisment.service';
import { Router, ActivatedRoute } from '@angular/router';
import { ImageService } from '../image.service';

@Component({
  selector: 'app-edit-advertisment',
  templateUrl: './edit-advertisment.component.html',
  styleUrls: ['./edit-advertisment.component.scss']
})
export class EditAdvertismentComponent implements OnInit {
  advertisment: Advertisment = new Advertisment();
  img: any;

  constructor(private tokenStorage: TokenStorageService, private advertismentService: AdvertismentService, private route: ActivatedRoute, private imageService: ImageService) { }

  ngOnInit() {
    this.getAdvertisment();
  }

  getAdvertisment() {
    this.route.params.subscribe(param => {
      this.advertismentService.getAdvertisment(+param["id"]).subscribe(adv => { this.advertisment = adv;});
    });
  }

  updateAdvertisment() {
    const uploadData = new FormData();
    uploadData.append('file', this.img, this.img.name);
    this.imageService.uploadImage(this.advertisment.title,uploadData).subscribe(error => console.log(error));
    this.route.params.subscribe(param => {
      this.advertismentService.updateAdvertisment(+param["id"],this.advertisment).subscribe(() =>     this.getAdvertisment());
    });
  }

  onFileChanged(event) {
    this.img = event.target.files[0];
    this.advertisment.image=this.advertisment.title+this.img.name;
  }
}
