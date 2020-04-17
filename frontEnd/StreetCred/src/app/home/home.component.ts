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

  nums: [1, 2, 3];

  public classReference = HomeComponent;

  events: Observable<EventModel[]>;

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
  
  ngAfterViewInit(): void {

  }

  ngOnInit(): void {
  }
  events$;
  getEvents() {
    this.events$ = this.appServices.getEvents();
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
