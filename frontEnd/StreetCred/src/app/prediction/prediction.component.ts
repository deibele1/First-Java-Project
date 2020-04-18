import { Component, Input } from '@angular/core';
import { PredictionModel } from '../Models/PredictionModel';
import { HomeComponent } from '../home/home.component';

@Component({
  selector: 'app-prediction',
  templateUrl: './prediction.component.html',
  styleUrls: ['./prediction.component.css']
})
export class PredictionComponent {

  @Input() pred: PredictionModel;
  @Input() home: HomeComponent;

  constructor() { }

}
