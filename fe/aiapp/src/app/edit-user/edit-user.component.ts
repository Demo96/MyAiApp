import { Component, OnInit } from '@angular/core';
import { TokenStorageService } from '../auth/token-storage.service';
import { UserService } from '../user.service';
import { ActivatedRoute } from '@angular/router';
import { User } from '../user';

@Component({
  selector: 'app-edit-user',
  templateUrl: './edit-user.component.html',
  styleUrls: ['./edit-user.component.scss']
})
export class EditUserComponent implements OnInit {
  user: User = new User();

  constructor(private tokenStorage: TokenStorageService, private userService: UserService, private route: ActivatedRoute) { }

  ngOnInit() {
    this.getUser();
  }

  getUser() {
    this.route.params.subscribe(param => {
      this.userService.getUser(param["userName"]).subscribe(user => { this.user = user;});
    });
  }
  updateUser() {
    this.route.params.subscribe(param => {
      this.userService.updateUser(param["userName"],this.user).subscribe(() =>     this.getUser());
    });

  }

}
