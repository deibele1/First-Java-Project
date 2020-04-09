  
import { Component } from '@angular/core';
import { LoginComponent } from 'src/app/login/login.component';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  
  private loggedIn: boolean = false;

  getLoggedIn() {
    return LoginComponent.loggedIn;
  }

  setLoggedIn(value: boolean) {
    this.loggedIn = value;
  }
}