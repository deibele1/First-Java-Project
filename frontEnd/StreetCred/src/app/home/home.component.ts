import { Component, OnInit, ViewChild, ComponentFactory, ComponentFactoryResolver, AfterViewInit, ViewContainerRef } from '@angular/core';
import { EventModel } from '../Models/EventModel'
import { PredictionModel } from '../Models/PredictionModel'
import { AppServices } from '../Services/app-services.service';
import { PredictionComponent } from '../prediction/prediction.component';
import { Observable } from 'rxjs';

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

  events: Array<EventModel>= [];
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
    this.appServices.getEvents().subscribe((data) => {
      this.events = data;
    });
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
