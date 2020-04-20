import { Component, Input } from '@angular/core';
import { PredictionModel } from '../Models/PredictionModel';
import { HomeComponent } from '../home/home.component';
import { AppServices } from '../Services/app-services.service';

@Component({
  selector: 'app-prediction',
  templateUrl: './prediction.component.html',
  styleUrls: ['./prediction.component.css']
})
export class PredictionComponent { 

  @Input() pred: PredictionModel;
  @Input() home: HomeComponent; 

  constructor(private apps: AppServices) { }

  predict(outcome:Boolean) {
    console.log("before")
    this.home.predict(outcome);
    console.log("after")
  }
}
