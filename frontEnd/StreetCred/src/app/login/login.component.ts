import { Component, OnInit } from '@angular/core';
import { AppComponent } from '../app.component';
import { HomeComponent } from '../home/home.component';
import { AppServices } from '../Services/app-services.service';

@Component({
  selector: 'app-login-component',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username: string;
  password: string

  constructor(private appServices: AppServices) { }

  ngOnInit(): void {
    
  }

  loginAttempt(): void {
    if (this.appServices.loginIn()) {
      AppComponent.loggedIn = true;
      HomeComponent.username = this.username;
    } else {
      console.log("Need to decide what to do on login failure");
    }
  }
}