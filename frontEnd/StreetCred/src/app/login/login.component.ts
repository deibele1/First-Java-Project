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
  password2: string;
  first: string;
  last: string;
  email: string;
  dob: Date;
  ans1: string;
  ans2: string;
  ans3: string;
  questionNum1: number;
  questionNum2: number;
  questionNum3: number;

  error: string;

  static signup: boolean = false;

  public classReference = LoginComponent;

  constructor(private appServices: AppServices) { }

  ngOnInit(): void { }

  resetinfo() {
    this.error = '';
    this.username = null;
    this.password = null;
    this.password2 = null;
    this.first = null;
    this.last = null;
    this.email = null;
  }

  showSignup() {
    this.resetinfo();
    this.classReference.signup = !this.classReference.signup;
  }

  guest() {
    this.resetinfo();
    AppComponent.loggedIn = true;
    HomeComponent.username = "Guest";
  }

  loginAttempt() {
    this.error = '';
    if(this.username != null) {
      if (this.password != null) {
        this.appServices.loginIn(this.username, this.password).subscribe((data) => {
          let user = data;
          if (user != null) {
            if (user.type == 'User') {
              AppComponent.loggedIn = true;
              HomeComponent.username = this.username;
              HomeComponent.setPassword(this.password);
            } else {
              this.error = "There was an error logging in!";
              this.resetinfo();
            }
          } else {
            this.error = "That username and password do not match!";
            this.resetinfo();
          }
        }
      )} else {
        this.error = "The password cannot be empty!";
      }
    } else {
      this.error = "The username cannot be empty!";
    }
  }

  signup() {
    this.error = '';
    if (this.username != null) {
      if (this.password != null) {
        if (this.password == this.password2) {
          if (this.first != null) {
            if (this.last != null) {
              if (this.email != null) {
                if (this.email.includes('@')) {
                  if (this.dob != null) {
                    this.appServices.signup(this.username, this.password, this.first, 
                        this.last, this.email, this.dob, null, null, null, null, null, 
                        null).subscribe((data) => {
                      let user = data;
                      if (user != null) {
                        if (user.type == 'User') {
                          AppComponent.loggedIn = true;
                          HomeComponent.username = this.username;
                          HomeComponent.setPassword(this.password);
                        } else {
                          this.error = "There was an error logging in!";
                          this.resetinfo();
                        }
                      } else {
                        this.error = "That username and password do not match!";
                        this.resetinfo();
                      }
                    })
                  } else {
                    this.error = "Date of Birth cannot be empty!";
                  }
                } else {
                  this.error = "Your email is missing @";
                }
              } else {
                this.error = "Email cannot be empty!";
              }
            } else {
              this.error = "Last name cannot be empty!";
            }
          } else {
            this.error = "First name cannot be empty!";
          }
        } else {
          this.error = "Your passwords do not match!";
        }
      } else {
        this.error = "The password cannot be empty!";
      }
    } else {
      this.error = "The userrname cannot be empty!";
    }
  }
}