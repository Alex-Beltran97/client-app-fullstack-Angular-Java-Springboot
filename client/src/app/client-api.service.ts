import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class ClientApiService {

  private apiUrl = "http://localhost:8090/api/v1/clients";
  constructor(private http: HttpClient) { }

  getClient(docType: string, docNumber: number) : Observable<any> {
    return this.http.get(`${ this.apiUrl }/${ docType }/${ docNumber }`);
  }

}
