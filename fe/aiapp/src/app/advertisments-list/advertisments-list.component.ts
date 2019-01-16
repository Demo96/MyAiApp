import { Component, OnInit } from '@angular/core';
import { Advertisment } from '../advertisment';
import { Observable } from 'rxjs';
import { AdvertismentService } from '../advertisment.service';
import { Router } from '@angular/router';
import { map } from 'rxjs/operators';
import { TokenStorageService } from '../auth/token-storage.service';

@Component({
  selector: 'app-advertisments-list',
  templateUrl: './advertisments-list.component.html',
  styleUrls: ['./advertisments-list.component.scss']
})
export class AdvertismentsListComponent implements OnInit {
  advertisments: Observable<Advertisment[]>;
  filteredAdvertisments: Observable<Advertisment[]>;
  filter: string;
  constructor(private advertismentService: AdvertismentService, private router: Router, private tokenStorage: TokenStorageService) { }

  getShortDescription(advertisment: Advertisment): string {
    let shortDescriptionMaxLength = 150; 
    if (advertisment.description.length < shortDescriptionMaxLength)
    return advertisment.description;
    else 
    return advertisment.description.slice(0,shortDescriptionMaxLength-3)+"...";
  }

  ngOnInit() {
    this.reloadData();
  }

  reloadData() {
   this.advertisments = this.advertismentService.getAdvertismentList();
   this.filterAdvertisments();
  }

  deleteAdvertisment(id: number)
  {
    this.advertismentService.deleteAdvertisment(id).subscribe(() => this.reloadData());
  }

  filterAdvertisments() {
     if(this.filter) {
       this.filteredAdvertisments=this.advertisments.pipe(map(advertisments => advertisments.filter(adv => adv.title.includes(this.filter))));
     }
     else this.filteredAdvertisments=this.advertisments;
 }
 myAdvertisments() {
  this.filteredAdvertisments=this.advertisments.pipe(map(advertisments => advertisments.filter(adv =>adv.userName==this.tokenStorage.getUsername())));
 }
}
