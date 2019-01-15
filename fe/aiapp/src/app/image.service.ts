import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ImageService {
  private baseUrl = "http://localhost:8080/images";

  constructor(private http: HttpClient) { }
  getImage( fileName: string): Observable<any> {
    return this.http.get(`${this.baseUrl}/${fileName}`);
  }

  uploadImage(title: string, file: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}/${title}`, file)
  }
}
