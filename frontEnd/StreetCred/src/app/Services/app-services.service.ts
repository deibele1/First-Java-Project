import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { EventModel } from '../Models/EventModel';
import { PredictionModel } from '../Models/PredictionModel';

@Injectable()
export class AppServices {

  serviceURL: string = 'http://18.191.179.31:9090/';

  constructor(private http: HttpClient) {}

  getEvents(): Observable<EventModel[]> {
    return this.http.get<EventModel[]>(`${this.serviceURL}`, {responseType: 'json'});
  }

  getPredictions(event: EventModel): Observable<PredictionModel> {
    return this.http.get<PredictionModel>(`${this.serviceURL}/event/${event.eventId}`, {responseType: 'json'});
  }

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
