import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'category'
})
export class CategoryPipe implements PipeTransform {

  transform(value: number): string {
    switch(value) {
      case 1:
        return "Sports";
      case 2:
        return "Politics"
      case 3:
        return "Birthdays"
    }
  }

}
