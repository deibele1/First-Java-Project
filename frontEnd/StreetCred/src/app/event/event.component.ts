import { Component, Input } from '@angular/core';
import { EventModel } from '../Models/EventModel';
import { HomeComponent } from '../home/home.component';

@Component({
  selector: 'app-event',
  templateUrl: './event.component.html',
  styleUrls: ['./event.component.css']
})
export class EventComponent {

  @Input() event: EventModel;
  @Input() home: HomeComponent;

  constructor() {}

  view() {
    this.home.getPredictions(this.event.id);
  }

}
