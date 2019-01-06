import { Component, OnInit } from '@angular/core';
import { User } from '../user';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';
import { UserService } from '../user.service';

@Component({
  selector: 'app-users-list',
  templateUrl: './users-list.component.html',
  styleUrls: ['./users-list.component.scss']
})
export class UsersListComponent implements OnInit {
  users: Observable<User[]>;

  constructor(private userService: UserService, private router: Router) { }

  ngOnInit() {
    this.reloadData();
  }
  reloadData() {
    this.users = this.userService.getUsersList();
  }

}
