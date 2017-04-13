import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

import { AppComponent } from './app.component';
import {SettingsComponent} from "./app.settings-component";
import {APPLICATION_ROUTERS} from "app/app.routers";
import {RouterModule} from "@angular/router";
import {CROSSettingsComponent} from "cors-settings-component";

@NgModule({
  declarations: [
    AppComponent,
    SettingsComponent,
    CROSSettingsComponent
  ],
  imports: [
    RouterModule.forRoot(APPLICATION_ROUTERS),
    BrowserModule,
    FormsModule,
    HttpModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
