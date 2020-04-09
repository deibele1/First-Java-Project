import { Component, OnInit } from '@angular/core';
import { LoginComponent } from 'src/app/login/login.component';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  
  private loggedIn: boolean = false;
  constructor(public login :LoginComponent) { }

  ngOnInit(): void {
    this.getLoggedIn();
  }

  getLoggedIn() {
    return this.login.loggedIn;
  }

  setLoggedIn(value: boolean) {
    this.loggedIn = value;
  }
}
