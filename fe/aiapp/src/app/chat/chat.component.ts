import { Component, OnInit } from '@angular/core';
import $ from 'jquery';
import { Stomp} from 'stompjs/lib/stomp.js';
import * as SockJS from 'sockjs-client/dist/sockjs';
@Component({
  selector: 'app-chat',
  templateUrl: './chat.component.html',
  styleUrls: ['./chat.component.scss']
})
export class ChatComponent implements OnInit {
  title = 'Spring Boot WebSocket Chat App';
  private stompClient;
  constructor() {  }

  ngOnInit() {
    this.connect();
  }

  connect() {
    let ws = new SockJS('http://localhost:8080/socket');
    this.stompClient = Stomp.over(ws);
    let that = this;
    this.stompClient.connect({}, function () {
      that.stompClient.subscribe("/chat", (message) => {
        if (message.body) {
          $(".chat").prepend("<div class='alert alert-secondary flex-wrap'>" + message.body + "</div>");
        }
      });
    });
  }

  sendMessage(message) {
    if (message) {
      this.stompClient.send("/app/send/message", {}, message);
    }
    $('#input').val('');
  }
}
