import { Component, OnInit } from '@angular/core';
import { User } from '../user';
import { UserService } from '../user.service';
import { ActivatedRoute } from '@angular/router';
import { TokenStorageService } from '../auth/token-storage.service';

@Component({
  selector: 'app-user-details',
  templateUrl: './user-details.component.html',
  styleUrls: ['./user-details.component.scss']
})
export class UserDetailsComponent implements OnInit {
  user: Object;
  constructor(private userService: UserService, private route: ActivatedRoute, private tokenStorage: TokenStorageService) { }

  ngOnInit() {
    this.user = new User();
    this.route.params.subscribe(param => {
      this.userService.getUser(param["userName"]).subscribe(user => this.user = user);
    });
  }

}

