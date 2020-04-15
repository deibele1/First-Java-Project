import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'tablePipe'
})
export class TablePipe implements PipeTransform {

  transform(value: any): any {
    return Object.keys(value);
  }
}
