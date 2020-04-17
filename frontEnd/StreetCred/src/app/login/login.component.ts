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
  password: string;
  password2: string = null;

  static signup: boolean = false;

  public classReference = LoginComponent;

  constructor(private appServices: AppServices) { }

  ngOnInit(): void {
    
  }

  showSignup(): void {
    this.classReference.signup = !this.classReference.signup;
  }

  guest() {
    AppComponent.loggedIn = true;
    HomeComponent.username = "Guest";
  }

  loginAttempt(): void {
    if (this.password2 == null) {
      if (this.appServices.loginIn()) {
        AppComponent.loggedIn = true;
        HomeComponent.username = this.username;
      } else {
        console.log("Need to decide what to do on login failure");
      }
    } else if (this.password == this.password2) {
      if (this.appServices.signup()) {
        AppComponent.loggedIn = true;
        HomeComponent.username = this.username;
      } else {
        console.log("Need to decide what to do on login failure");
      }
    } else {
      console.log("Passwords do not match");
    }
  }
}