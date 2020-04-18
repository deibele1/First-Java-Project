import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, Subscriber } from 'rxjs';
import { map } from 'rxjs/operators';
import { EventModel } from '../Models/EventModel';
import { Tableable } from '../Models/Tableable';
import { UserModel } from '../Models/UserModel';

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
    console.log("Ready for testing");

    let user: UserModel = <UserModel> {
      username: (<HTMLInputElement>document.getElementById("username")).value,
      first: (<HTMLInputElement>document.getElementById("first")).value,
      last: (<HTMLInputElement>document.getElementById("last")).value,
      email: (<HTMLInputElement>document.getElementById("email")).value,
      password: (<HTMLInputElement>document.getElementById("ans1")).value,
      ans1: (<HTMLInputElement>document.getElementById("ans1")).value,
      ans2: (<HTMLInputElement>document.getElementById("ans2")).value,
      ans3: (<HTMLInputElement>document.getElementById("ans3")).value,
      questionNum1: Number.parseInt((<HTMLInputElement>document.getElementById("questionNum1")).value),
      questionNum2: Number.parseInt((<HTMLInputElement>document.getElementById("questionNum2")).value),
      questionNum3: Number.parseInt((<HTMLInputElement>document.getElementById("questionNum3")).value)
    }
    this.http.post(`${AppServices.serviceURL}user/singup`, user);
    return true;
  }
}
