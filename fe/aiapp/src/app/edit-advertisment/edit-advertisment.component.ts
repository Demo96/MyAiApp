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
  isEdited = false;

  constructor(private tokenStorage: TokenStorageService, private advertismentService: AdvertismentService, private route: ActivatedRoute, private imageService: ImageService) { }

  ngOnInit() {
    this.getAdvertisment();
  }

  getAdvertisment() {
    this.route.params.subscribe(param => {
      this.advertismentService.getAdvertisment(+param["id"]).subscribe(adv => { this.advertisment = adv; });
    });
  }

  updateAdvertisment() {
    debugger;
    if (this.img) {
      if (this.advertisment.image)
        this.imageService.deleteImage(this.advertisment.image).subscribe();
      const uploadData = new FormData();
      uploadData.append('file', this.img, this.img.name);
      let prefix = this.generatePrefix();
      this.imageService.uploadImage(prefix, uploadData).subscribe();
      this.advertisment.image = prefix + this.img.name;
      this.img = null;
    }
    this.route.params.subscribe(param => {
      this.advertismentService.updateAdvertisment(+param["id"], this.advertisment).subscribe(() => this.getAdvertisment());
    });
    this.isEdited=true;
  }

  onFileChanged(event) {
    this.img = event.target.files[0];
  }

  preSubmit() {
    this.isEdited = false;
    return true;
  }

  onSubmit() {
    this.updateAdvertisment();
  }

  generatePrefix(): string {
    return Math.random().toString(36).substring(5);
  }
}
