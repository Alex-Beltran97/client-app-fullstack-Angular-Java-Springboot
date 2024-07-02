import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import { Observable } from "rxjs";
import {DocType, IClient} from "./models/client.model";

@Injectable({
  providedIn: 'root'
})
export class RestApiClientsService {
  private baserUrl = "http://localhost:8090/api/v1/clients";
  constructor(
    private http: HttpClient
  ) { }

  public getClient(docType: string, docNumber: string): Observable<IClient> {
    return this.http.get<IClient>(`${ this.baserUrl }/${ docType }/${ docNumber }`);
  }
}
