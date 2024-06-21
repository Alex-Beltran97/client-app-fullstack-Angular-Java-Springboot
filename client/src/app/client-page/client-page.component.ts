import { Component } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {ClientApiService} from "../client-api.service";
import * as alertifyjs from "alertifyjs";

@Component({
  selector: 'app-client-page',
  templateUrl: './client-page.component.html'
})
export class ClientPageComponent {
  client:any;

  constructor(private route: ActivatedRoute, private clientApiService : ClientApiService, private router: Router) {}

  ngOnInit() {
    this.route.queryParams.subscribe(params => {
      const docType = params["docType"];
      const docNumber = params["docNumber"];
      this.clientApiService.getClient(docType, docNumber).subscribe(data => {
        this.client = data;

        if (!this.client) {
          alertifyjs.error("No se encontraron datos");
        }
      });
    });

  }

  handleReturn() {
    this.router.navigate(["/"]);
  }
}
