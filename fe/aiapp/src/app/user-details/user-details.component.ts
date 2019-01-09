import { Component, OnInit } from '@angular/core';
import { User } from '../user';
import { UserService } from '../user.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-user-details',
  templateUrl: './user-details.component.html',
  styleUrls: ['./user-details.component.scss']
})
export class UserDetailsComponent implements OnInit {
  user: Object;
  constructor(private userService: UserService, private route: ActivatedRoute) { }

  ngOnInit() {
    console.log("asdddd");

    this.user = new User();
    this.route.params.subscribe(param => {
      console.log(param["userName"]);
      this.userService.getUser(param["userName"]).subscribe(user => { this.user = user; console.log("asd", this.user); });
    });
  }

}

