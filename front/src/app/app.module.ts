import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {FormsModule} from '@angular/forms';
import {HttpModule} from '@angular/http';

import {AppComponent} from './app.component';
import {APPLICATION_ROUTERS} from "./router";
import {RouterModule} from "@angular/router";
import {CORSSettingsComponent} from "./settings/cors/cors-settings-component";
import {SettingsComponent} from "app/settings/settings-component";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {
    MdButtonModule, MdCheckboxModule, MdInputModule, MdCardModule, MdRadioModule,
    MdSlideToggleModule
} from "@angular/material";
import 'hammerjs';
import {HeaderComponent} from "./header/header.component";
import {FooterComponent} from "./footer/footer.component";

@NgModule({
    declarations: [
        AppComponent,
        SettingsComponent,
        CORSSettingsComponent,
        HeaderComponent,
        FooterComponent
    ],
    imports: [
        RouterModule.forRoot(APPLICATION_ROUTERS),
        BrowserModule,
        FormsModule,
        HttpModule,
        BrowserAnimationsModule,
        MdInputModule,
        MdButtonModule,
        MdCheckboxModule,
        MdCardModule,
        MdRadioModule,
        MdSlideToggleModule
    ],
    providers: [],
    bootstrap: [AppComponent]
})
export class AppModule {}
