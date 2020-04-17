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

  nums: [1, 2, 3];

  public classReference = HomeComponent;

  events: EventModel[];

  preds: PredictionModel[] = [{
    predID: 1,
    eventID: 1,
    eventName: 'default',
    predDate: '10/12/19',
    predicted: false
    }, {
    predID: 2,
    eventID: 1,
    eventName: 'default',
    predDate: '10/12/19',
    predicted: false
    }, {
    predID: 3,
    eventID: 2,
    eventName: 'default',
    predDate: '10/12/19',
    predicted: false
    }];

  constructor(private appServices: AppServices, 
      private componentFactoryResolver: ComponentFactoryResolver) { }
  
  ngAfterViewInit(): void {

  }

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
    //this.events = this.appServices.getEvents();
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
