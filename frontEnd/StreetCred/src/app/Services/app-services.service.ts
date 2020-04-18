import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, Subscriber } from 'rxjs';
import { map } from 'rxjs/operators';
import { EventModel } from '../Models/EventModel';
import { Tableable } from '../Models/Tableable';

@Injectable()
export class AppServices {

  //Location of the host;
  static serviceURL: string = 'http://18.191.179.31:9090/';
  responce: Observable<Tableable[]>;
  constructor(private http: HttpClient) {}

  get(uri :string): Observable<Tableable[]> {
    console.log("Get Events Called");
    //this.http.get(AppServices.serviceURL+uri);
    uri == undefined ? this.responce = this.http.get<Tableable[]>(AppServices.serviceURL, {responseType: 'json'}) : this.http.get<Tableable[]>(AppServices.serviceURL+uri, {responseType: 'json'});
    return this.responce;
  }
  

  loginIn(): boolean {
    
    console.log("Method not implemented.");
    this.http.get(`${AppServices.serviceURL}user/login`);
    return true;
  }
  signup(): boolean {
    console.log("Method not implemented.");
    this.http.get(`${AppServices.serviceURL}user/signup`);
    return true;
  }
}
