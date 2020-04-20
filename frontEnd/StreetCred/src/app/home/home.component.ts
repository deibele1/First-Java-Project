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
  static event: EventModel;
  private static password: string;
  guest: boolean = false;
  showNewEvent: boolean = false;
  newEventText: string;
  eventDate: Date;
  eventName: string;
  eventCategory: string;
  description: string;
  error: string;

  category: string;
  categories: Array<string> = ['All', 'Politics', 'Economics', 
                              'Sports', 'Environment', 'Technology'];

  public classReference = HomeComponent;

  events: Array<EventModel> = [];

  pred: PredictionModel;

  constructor(private appServices: AppServices,   
      private componentFactoryResolver: ComponentFactoryResolver) { }
  
  predict(outcome: Boolean) {
    this.appServices.predict(outcome, HomeComponent.event.eventId,HomeComponent.username);
  }
  
  ngAfterViewInit(): void { }

  ngOnInit(): void {
    this.newEventText = "New Event";
    this.category = this.categories[0];
    if (this.classReference.username == "Guest") { this.guest = true; }
    this.getEvents();
  }

  static setPassword(password: string) {
    this.password = password;
  }

  static getPassword(): string {
    return this.password;
  }

  toggleNewEvent() {
    if (this.showNewEvent) {
      this.newEventText = "New Event";
    } else {
      this.newEventText = "Cancel";
    }
    this.showNewEvent = !this.showNewEvent;
    this.resetData();
  }

  resetData() {
    this.eventDate = null;
    this.eventName = null;
    this.eventCategory = null;
    this.description = null;
    this.error = null;
  }

  addEvent() {
    if (this.eventName != null) {
      let temp = this.categories.indexOf(this.eventCategory);
      if (temp > 0) {
        if (this.description != null) {
          if (this.eventDate != null) {
            this.toggleNewEvent();
            this.appServices.addEvent(this.eventDate, this.eventName, temp, this.description,
                  HomeComponent.username, HomeComponent.getPassword()).subscribe((data)=>{this.events.push(data)});      
          } else {
            this.error = "When is the event taking place?"
          }
        } else {
          this.error = "Please enter a description";
        }
      } else {
        this.error = "Select a specific category";
      } 
    } else {
      this.error = "You need to give the event a name!";
    }
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
