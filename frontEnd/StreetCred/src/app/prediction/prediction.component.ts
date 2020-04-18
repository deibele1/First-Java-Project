import { Component, OnInit } from '@angular/core';
import { PredictionModel } from '../Models/PredictionModel';

@Component({
  selector: 'app-prediction',
  templateUrl: './prediction.component.html',
  styleUrls: ['./prediction.component.css']
})
export class PredictionComponent implements OnInit {

  pred: PredictionModel;

  constructor() { }

  ngOnInit(): void {
  }

}
