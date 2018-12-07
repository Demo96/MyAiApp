import { Component, OnInit } from '@angular/core';
import { Advertisment } from '../advertisment';
import { Observable } from 'rxjs';
import { AdvertismentService } from '../advertisment.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-advertisments-list',
  templateUrl: './advertisments-list.component.html',
  styleUrls: ['./advertisments-list.component.scss']
})
export class AdvertismentsListComponent implements OnInit {
  advertisments: Observable<Advertisment[]>;
  constructor(private advertismentService: AdvertismentService, private router: Router) { }

  ngOnInit() {
    this.reloadData();
  }
  reloadData() {
    this.advertisments = this.advertismentService.getAdvertismentList();
  }
  addUser() {
        this.router.navigateByUrl('./create');
  }
}
