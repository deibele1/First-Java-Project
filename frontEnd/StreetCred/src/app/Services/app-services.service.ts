import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { EventModel } from '../Models/EventModel';

@Injectable({
  providedIn: 'root'
})
export class AppServices {

  serviceURL: string = 'http://18.191.179.31:9090/';

  constructor(private http: HttpClient) { }

  getEvents(): EventModel[] {
    console.log("Get Events Called");
    return;
  }
  //return this.http.get<EventModel[]>(this.serviceURL);
  

  loginIn(): boolean {
    
    console.log("Method not implemented.");
    this.http.get(`${this.serviceURL}user/login`);
    return true;
  }

  signup(): boolean {
    console.log("Method not implemented.");
    this.http.get(`${this.serviceURL}user/signup`);
    return true;
  }
}
