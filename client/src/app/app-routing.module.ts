import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {HomePageComponent} from "./home-page/home-page.component";
import {ClientPageComponent} from "./client-page/client-page.component";

const routes: Routes = [
  { path: "", redirectTo: "/home", pathMatch: "full"},
  { path: "home", component: HomePageComponent },
  { path: "client", component: ClientPageComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
