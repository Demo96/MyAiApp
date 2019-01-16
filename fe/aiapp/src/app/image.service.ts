import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ImageService {
  private baseUrl = "http://localhost:8080/images";

  constructor(private http: HttpClient) { }
  getImage( imageName: string): Observable<any> {
    imageName= imageName.substring(0, imageName.length-4) + imageName.substring(imageName.length-3, imageName.length);
    return this.http.get(`${this.baseUrl}/${imageName}`);
  }

  uploadImage(id: number, file: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}/${id}`, file);
  }

  deleteImage(imageName: string): Observable<Object> {
    imageName= imageName.substring(0, imageName.length-4) + imageName.substring(imageName.length-3, imageName.length);
    return this.http.delete(`${this.baseUrl}/${imageName}`);
  }
}
