import { Component, OnInit, ViewChild, ComponentFactory, ComponentFactoryResolver, AfterViewInit, ViewContainerRef } from '@angular/core';
import { EventModel } from '../Models/EventModel'
import { PredictionModel } from '../Models/PredictionModel'
import { AppServices } from '../Services/app-services.service';
import { PredictionComponent } from '../prediction/prediction.component';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit, AfterViewInit {
  @ViewChild("predictionContainer", {read: ViewContainerRef}) predCon!: ViewContainerRef;

  static username: string;
  guest: boolean = false;

  category: string;
  categories: Array<string> = ['All', 'Politics', 'Economics', 
                              'Sports', 'Environment', 'Technology'];

  public classReference = HomeComponent;

  events: Array<EventModel> = [];
  tempEvents: Array<EventModel> = [];

  preds: PredictionModel[] = [{
    predID: 1,
    predName: "This party will rock!",
    eventID: 1,
    eventName: 'default',
    predDate: '10/12/19',
    predicted: false
    }, {
    predID: 2,
    predName: "This party will rock!",
    eventID: 1,
    eventName: 'default',
    predDate: '10/12/19',
    predicted: true
    }, {
    predID: 3,
    predName: "This party will rock!",
    eventID: 2,
    eventName: 'default',
    predDate: '10/12/19',
    predicted: false
    }];

  constructor(private appServices: AppServices, 
      private componentFactoryResolver: ComponentFactoryResolver) { }
  
  ngAfterViewInit(): void { }

  ngOnInit(): void {
    this.category = this.categories[0];
    if (this.classReference.username == "Guest") { this.guest = true; }
    this.getEvents();
  }

  getEvents() {
    if (this.predCon != undefined) { this.predCon.clear(); }
    this.events = [ {
      advent: '10/12/17', 
      eventName: "Ray's Birthday", 
      description: 'Super soft birthday party',
      category: 'Birthdays', 
      creatorUsername: 'Ray',
      id: 1
    },
    {
      advent: '02/15/17', 
      eventName: "Aarons Birthday", 
      description: 'Medium soft birthday party',
      category: 'Birthdays',
      creatorUsername: 'Aaron',
      id: 2
    },
    {
      advent: '05/01/18', 
      eventName: "John's Birthday", 
      description: 'Not soft birthday party',
      category: 'Birthdays',
      creatorUsername: 'John',
      id: 3
    }
  ];
    //this.events = this.appServices.getEvents();
  }

  updateList() {
    this.getEvents();
    for (let event of this.events) {
      if (event.category == this.category || this.category == this.categories[0]) {
        this.tempEvents.push(event);
      }
    }
    this.events = this.tempEvents;
  }

  getPredictions(event: EventModel): void {
    // this.preds = this.appServices.getPredictions();
    const factory = this.componentFactoryResolver.resolveComponentFactory(PredictionComponent);
    this.predCon.clear();
    this.preds.forEach(element => {
      if (element.eventID == event.id) {
        element.eventName = event.eventName;
        const comp = this.predCon.createComponent(factory);
        (comp.instance).pred = element;
      }
    });
  }
}
