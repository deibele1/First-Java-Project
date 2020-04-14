import { Component, OnInit } from '@angular/core';
import { EventModel } from '../Models/EventModel'
import { AppServices } from '../Services/app-services.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  static username: string;

  public classReference = HomeComponent;

  events: EventModel[];

  constructor(private appServices: AppServices) { }

  ngOnInit(): void {
    this.appServices.getEvents().subscribe(events => {
      this.events = events;
    });
  }
}
