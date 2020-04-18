import { Component, Input } from '@angular/core';
import { EventModel } from '../Models/EventModel';
import { HomeComponent } from '../home/home.component';

@Component({
  selector: 'app-event',
  templateUrl: './event.component.html',
  styleUrls: ['./event.component.css']
})
export class EventComponent {

  @Input() events: EventModel[];
  @Input() home: HomeComponent;
  @Input() guest: boolean;

  constructor() {}

  view(event: EventModel) {
    this.home.getPredictions(event);
  }

}
