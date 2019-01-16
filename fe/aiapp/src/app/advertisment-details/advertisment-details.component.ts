import { Component, OnInit, Input } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { AdvertismentService } from '../advertisment.service';
import { Advertisment } from '../advertisment';
import { TokenStorageService } from '../auth/token-storage.service';
import { ImageService } from '../image.service';
@Component({
  selector: 'app-advertisment-details',
  templateUrl: './advertisment-details.component.html',
  styleUrls: ['./advertisment-details.component.scss']
})
export class AdvertismentDetailsComponent implements OnInit {
  advertisment: Advertisment;
  constructor(private advertismentService: AdvertismentService, private route: ActivatedRoute, private tokenStorage: TokenStorageService, private imageService: ImageService) { }

  ngOnInit() {
    this.advertisment = new Advertisment();
    this.route.params.subscribe(param => {
      this.advertismentService.getAdvertisment(+param["id"]).subscribe(adv =>  this.advertisment = adv);
    });
  }
  deleteAdvertisment(id: number)
  {
    let imageName = this.advertisment.image;
    this.advertismentService.deleteAdvertisment(id).subscribe(() => {
      window.location.href = '..';
      if(imageName) {
        imageName= imageName.substring(0, imageName.length-4) + imageName.substring(imageName.length-3, imageName.length);
        this.imageService.deleteImage(imageName).subscribe();
      }
    });
  }
}
