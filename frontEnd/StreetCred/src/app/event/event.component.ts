import { Component, Input } from '@angular/core';
import { EventModel } from '../Models/EventModel';

@Component({
  selector: 'app-event',
  templateUrl: './event.component.html',
  styleUrls: ['./event.component.css']
})
export class EventComponent {

  @Input() event: EventModel;

  constructor() {}

  viewMore() {}

}
