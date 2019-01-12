import { Component, OnInit } from '@angular/core';
import { TokenStorageService } from './auth/token-storage.service';
import $ from 'jquery';
import { Stomp} from 'stompjs/lib/stomp.js';
import * as SockJS from 'sockjs-client/dist/sockjs';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {
  title = '!!! AiApp !!!';
  private roles: string[];
  private authority: string;
  private stompClient;

  constructor(private tokenStorage: TokenStorageService) { }

  ngOnInit() {
    this.connect();
    if (this.tokenStorage.getToken()) {
      this.roles = this.tokenStorage.getAuthorities();
      this.roles.every(role => {
        if (role === 'ROLE_ADMIN') {
          this.authority = 'admin';
          return false;
        }
        this.authority = 'user';
        return true;
      });
    }
  }

  logout() {
    this.tokenStorage.deleteAuthorities();
    this.tokenStorage.deleteToken();
    this.tokenStorage.deleteUsername();
    this.authority = null;
  }

  connect() {
    let ws = new SockJS('http://localhost:8080/socket');
    this.stompClient = Stomp.over(ws);
    let that = this;
    this.stompClient.connect({}, function () {
      that.stompClient.subscribe("/chat", (message) => {
        if (message.body) {
            let messageParts = message.body.split(";");
            if(messageParts.length == 3)
            {
              $(".chat").prepend("<div class='chat-message'>"+
              "<div class='message-info'>" + messageParts[0]+messageParts[1] + "</div>"+
              "<div class='message-body'>" + messageParts[2] + "</div>"+
               "</div>");
          }
        }
      });
    });
  }

  sendMessage(message) {
    if (message) {
      this.stompClient.send("/app/send/message", {},this.tokenStorage.getUsername() + ";" + message);
    }
    $('#chat-input').val('');
  }
}
