import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { EventModel } from '../Models/EventModel';

@Injectable()
export class AppServices {

  //Location of the host;
  static serviceURL: string = 'http://18.191.179.31:9090/';
  static day90: string = "90day";
  static day60: string = "60day";
  static day30: string = "30day";
  responce: Observable<EventModel[]>;
  constructor(private http: HttpClient) {}

  getEvents(): Observable<EventModel[]> {
    console.log("Get Events Called");
    this.http.get(AppServices.serviceURL);
    this.responce = this.http.get<EventModel[]>(AppServices.serviceURL, {responseType: 'json'});
    return this.responce;
  }
  //return this.http.get<EventModel[]>(this.serviceURL);
  

  loginIn(): boolean {
    
    console.log("Method not implemented.");
    this.http.get(`${AppServices.serviceURL}user/login`);
    return true;
  }

  signup(): boolean {
    console.log("Method not implemented.");
    this.http.get(`${this.serviceURL}user/signup`);
    return true;
  }
}
