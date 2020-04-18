import { Component, OnInit, ViewChild, ComponentFactoryResolver, AfterViewInit, ViewContainerRef } from '@angular/core';
import { EventModel } from '../Models/EventModel'
import { PredictionModel } from '../Models/PredictionModel'
import { AppServices } from '../Services/app-services.service';

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

  pred: PredictionModel;

  constructor(private appServices: AppServices, 
      private componentFactoryResolver: ComponentFactoryResolver) { }
  
  ngAfterViewInit(): void { }

  ngOnInit(): void {
    this.category = this.categories[0];
    if (this.classReference.username == "Guest") { this.guest = true; }
    this.getEvents();
  }

  getEvents() {
    if (this.category == this.categories[0]) {
      this.appServices.getEvents().subscribe((data)=>{this.events = data});
    } else {
      this.appServices.getEvents().subscribe((data)=>{
        let tempEvents = data;
        this.events = [];
        for (let event of tempEvents){
          if (event.eventCategory == this.category) {
            this.events.push(event);
          }
        }
      });
    }
  }

  getPredictions(event: EventModel) {
    this.appServices.getPredictions(event).subscribe((data)=>{this.pred = data});
  }
}
