import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'predicted'
})
export class PredictedPipe implements PipeTransform {

  transform(value: boolean): string {
    switch (value) {
      case true:
        return "This shall come to pass";
      case false:
        return "Seriously? This will never happen."
    }
  }

}
