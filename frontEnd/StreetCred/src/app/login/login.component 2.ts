import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-login-component',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  static loggedIn:boolean = false;

  constructor() { }
  username:string;
  password:string;

  ngOnInit(): void {
    console.log("Hello Nerds!!!");
  }

  submit() {
    console.log(this.username + " " + this.password);
    LoginComponent.loggedIn = true;
  }

}