import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'awaitingConfirmed'
})
export class AwaitingConfirmedPipe implements PipeTransform {

  transform(value: boolean) {
    return value ? 'Confirmed' : 'Awaiting';
  }
}
