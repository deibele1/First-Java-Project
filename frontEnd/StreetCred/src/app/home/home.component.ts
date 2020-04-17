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
  static showPres: boolean = false;

  nums: [number, 3];

  public classReference = HomeComponent;

  events: EventModel[];

  constructor(private appServices: AppServices) { }

  ngOnInit(): void {
    this.events = [ {
      advent: '10/12/17', 
      eventName: "Ray's Birthday", 
      description: 'Super soft birthday party',
      categoryNumber: 3, 
      creatorUsername: 'Ray',
      id: 1
  },
  {
      advent: '02/15/17', 
      eventName: "Aarons Birthday", 
      description: 'Medium soft birthday party',
      categoryNumber: 3, 
      creatorUsername: 'Aaron',
      id: 2
  },
  {
      advent: '05/01/18', 
      eventName: "John's Birthday", 
      description: 'Not soft birthday party',
      categoryNumber: 3, 
      creatorUsername: 'John',
      id: 3
  }
];
    //this.appServices.getEvents();
  }

  getPredictions(eventID: number): void {
    console.log(eventID);
    
  }
}
