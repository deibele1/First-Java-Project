import { Component, OnInit } from '@angular/core';
import { EventModel } from '../Models/EventModel'
import { AppServices } from '../Services/app-services.service';
import { TablePipe } from '../table.pipe';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  static username: string;

  public classReference = HomeComponent;

  events: EventModel[];

  eventHeaders: string[] = ["Event Date", "Event Title", "Description", "Created By", "Category"];

  constructor(private appServices: AppServices) { }

  ngOnInit(): void {
    this.events = [ {
      creatorUsername: 'Ray', 
      advent: '10/12/17', 
      eventName: "Ray's Birthday", 
      categoryNumber: 1, 
      description: 'Super soft birthday party'
  },
  {
      creatorUsername: 'Aaron', 
      advent: '02/15/17', 
      eventName: "Aarons Birthday", 
      categoryNumber: 1, 
      description: 'Medium soft birthday party'
  },
  {
      creatorUsername: 'John', 
      advent: '05/01/18', 
      eventName: "John's Birthday", 
      categoryNumber: 1, 
      description: 'Not soft birthday party'
  }
];
    //this.appServices.getEvents();
  }
}
