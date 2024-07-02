import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {NgbModule} from "@ng-bootstrap/ng-bootstrap";
import { HomeComponent } from './pages/home/home.component';
import { UserDataComponent } from './pages/user-data/user-data.component';
import { PageNotFoundComponent } from './pages/page-not-found/page-not-found.component';
import {ReactiveFormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";
import { FormatDocTypePipe } from './format-doc-type.pipe';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    UserDataComponent,
    PageNotFoundComponent,
    FormatDocTypePipe,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
