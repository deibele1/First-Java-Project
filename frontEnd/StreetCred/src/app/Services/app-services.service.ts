import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { EventModel } from '../Models/EventModel';

@Injectable({
  providedIn: 'root'
})
export class AppServices {

  serviceURL: string = '';

  constructor(private http: HttpClient) { }

  getEvents():Observable<EventModel[]> {
    return this.http.get<EventModel[]>(this.serviceURL);
  }

  loginIn(): boolean {
    console.log("Method not implemented.");
    return true;
  }
}
