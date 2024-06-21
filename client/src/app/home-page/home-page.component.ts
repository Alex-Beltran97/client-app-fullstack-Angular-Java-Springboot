import { Component } from '@angular/core';
import {Router} from "@angular/router";
import * as alertifyjs from "alertifyjs";



@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html'
})
export class HomePageComponent {

  ableBtn : boolean = true;
  docType : string = "";
  docNumber : number | null = null;

  constructor(private router: Router) {  }

  onSubmit() {
    const { docType, docNumber } = this;

    if (!docType.trim()) {
      return alertifyjs.warning("Tipo de  documento es requerido");
    }

    if (docNumber === null) {
      return alertifyjs.warning("Debe ingresar un numero de documento");
    }

    if (docNumber.toString().length < 8 || docNumber.toString().length > 11) {
      return alertifyjs.warning("El numero de documento debe tener entre 8 a 11 cifras");
    }

    alertifyjs.success("Cargando datos del usuario...");

    setTimeout(() => {
      this.router.navigate(
        ["/client"],
        { queryParams: {docType, docNumber} }
      );
    }, 1000)

  }

  // @ts-ignore
  onChange(e: Event) {
    const target= (e.target as unknown) as HTMLInputElement;
    console.log(target.value.trim());
    if (!target.value.trim()) {
      return this.ableBtn = true;
    };
    this.ableBtn = false;
  }

}
