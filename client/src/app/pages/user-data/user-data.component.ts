import {Component, OnInit, signal} from '@angular/core';
import {IClient} from "../../models/client.model";
import {RestApiClientsService} from "../../rest-api-clients.service";
import {ActivatedRoute, Router} from "@angular/router";
import {ConsoleLogger} from "@angular/compiler-cli";
import {log} from "@angular-devkit/build-angular/src/builders/ssr-dev-server";
import {catchError, of} from "rxjs";

@Component({
  selector: 'app-user-data',
  templateUrl: './user-data.component.html',
  styleUrl: './user-data.component.css'
})
export class UserDataComponent implements OnInit {
  client: IClient | undefined;
  clientData = signal([]);
  isHidden = true;

  constructor(
    private restApiClientService: RestApiClientsService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.route.params.subscribe( params => {
      const { docType, docNumber } = params;
      this.getClientData(docType, docNumber);
    });
  }

  getClientData(docType: string, docNumber: string,) {
    this.restApiClientService.getClient(docType, docNumber).pipe(
      catchError(err => {
        this.isHidden = false;
        console.log({message: err?.error.message, error: err});
        return of(undefined);
      })
    ).subscribe(client => {
      this.client = client;
      this.showData(this.client!);
    });
  }

  showData(client: IClient) {
    // @ts-ignore
    Object.entries(client).forEach(item => this.clientData.update(prevItem => [...prevItem, [this.generateKeys(item[0]), item[1]]]));
  }

  generateKeys(key: string) {
    switch (key) {
          case "docType":
            return "Tipo de documento";
          case "docNumber":
            return "Numero de documento";
          case "firstName":
            return "Primer nombre";
          case "lastName":
            return "Apellido";
          case "city":
            return "Ciudad";
          case "secondName":
            return "Segundo Nombre";
          case "phone":
            return "Telefono";
          case "secondLastName":
            return "Segundo Apellido";
          case "address":
            return "Direccion";
          default:
            return key;
        }
  }

  getBack() {
    this.isHidden = true;
    this.router.navigate(["/"]);
  }
}
