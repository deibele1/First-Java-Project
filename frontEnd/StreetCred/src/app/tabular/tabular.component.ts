import { Component, OnInit, Input, ViewChild, ElementRef } from '@angular/core';
import { Tableable } from '../Models/Tableable';
import { AppServices } from '../Services/app-services.service';

@Component({
  selector: 'app-tabular',
  templateUrl: './tabular.component.html',
  styleUrls: ['./tabular.component.css']
})
export class TabularComponent implements OnInit {
  @Input('uri') uri :string;
  @Input('columns') columns :string[];
  @Input('title') title :string;
  data :Array<Tableable>;
  constructor(private appServices: AppServices) {
  }
  ngOnInit(): void {
    this.appServices.get(this.uri).subscribe(
      x => {
        this.data = x;
      },
      error => {}
    );
  }
}
