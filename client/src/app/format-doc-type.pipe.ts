import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'formatDocType'
})
export class FormatDocTypePipe implements PipeTransform {

  transform(value: unknown, ...args: unknown[]): unknown {
    switch (value) {
      case "c":
        return "Cedula de ciudadania";
      case "p":
        return "Pasaporte";
      default:
        return value;
    }
  }

}
