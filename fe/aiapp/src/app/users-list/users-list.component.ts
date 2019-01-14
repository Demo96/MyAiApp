import { Component, OnInit } from '@angular/core';
import { User } from '../user';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';
import { UserService } from '../user.service';
import { map } from 'rxjs/operators';

@Component({
  selector: 'app-users-list',
  templateUrl: './users-list.component.html',
  styleUrls: ['./users-list.component.scss']
})
export class UsersListComponent implements OnInit {
  users: Observable<User[]>;
  filteredUsers:  Observable<User[]>;
  filter: string;

  constructor(private userService: UserService, private router: Router) { }

  ngOnInit() {
    this.reloadData();
  }

  reloadData() {
    this.users = this.userService.getUsersList();
    this.filterUsers();
  }

  filterUsers() {
    console.log(this.filter);
    if(this.filter)
      this.filteredUsers=this.users.pipe(map(users => users.filter(user => user.userName.includes(this.filter))));
    else
     this.filteredUsers=this.users;
  }

}
