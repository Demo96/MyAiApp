import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs"
@Injectable({
  providedIn: 'root'
})
export class AdvertismentService {
  private baseUrl = "http://localhost:8080/advertisments";
  
  constructor(private http: HttpClient) { }
  
  getAdvertisment(id: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/${id}`);  
  }
  
  creatAdvertisment(user: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}`, user);  
  }
  
   updateAdvertisment(id: number, newAdvertisment: Object): Observable<Object> {
    return this.http.put(`${this.baseUrl}/${id}`, newAdvertisment);  
  }
  
   deleteAdvertisment(id: number): Observable<Object> {
   return this.http.delete(`'${this.baseUrl}/${id}`);  
  }
  
  getAdvertismentList():Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }
}
