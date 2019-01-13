import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ChatMessageService {
  private baseUrl = "http://localhost:8080/messages";

  constructor(private http: HttpClient) { }

   getMessagesList(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }
}
