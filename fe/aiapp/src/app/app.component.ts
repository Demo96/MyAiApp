import { Component, OnInit } from '@angular/core';
import { TokenStorageService } from './auth/token-storage.service';
import $ from 'jquery';
import { Stomp } from 'stompjs/lib/stomp.js';
import * as SockJS from 'sockjs-client/dist/sockjs';
import { ChatMessageService } from './chat-message.service';
import { Observable } from 'rxjs';

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

  constructor(private tokenStorage: TokenStorageService, private chatMessageService: ChatMessageService) { }

  ngOnInit() {
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
    this.connect();
    this.loadMessages();
  }

  loadMessages() {
    this.chatMessageService.getMessagesList().subscribe(msgArray => msgArray.forEach(msg => this.generateMessage(msg.date, msg.username, msg.message)));
  }

  generateMessage(date: string, username: string, message: string) {
    $(".chat").prepend("<div>" +
      "<div style='font-size: 1rem; color: dimgray'>" + date + " " + username + "</div>" +
      "<div style='font-size: 1.2rem'>" + message + "</div>" +
      "</div>");
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
          if (messageParts.length == 3) {
            that.generateMessage(messageParts[0], messageParts[1], messageParts[2])
          }
        }
      });
    });
  }

  sendMessage(message) {
    if (this.authority) {
      if (message) {
        this.stompClient.send("/app/send/message", {}, this.tokenStorage.getUsername() + ";" + message);
      }
      $('#chat-input').val('');
    }
  }
}
