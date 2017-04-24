import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {FormsModule} from '@angular/forms';
import {HttpModule} from '@angular/http';

import {AppComponent} from './app.component';
import {APPLICATION_ROUTERS} from "./router";
import {RouterModule} from "@angular/router";
import {CORSSettingsComponent} from "./settings/cors/cors-settings.component";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {
    MdButtonModule, MdCheckboxModule, MdInputModule, MdCardModule, MdRadioModule,
    MdSlideToggleModule, MdGridListModule, MdMenuModule, MdIconModule, MdSelectModule
} from "@angular/material";
import 'hammerjs';
import {HeaderComponent} from "./header/header.component";
import {FooterComponent} from "./footer/footer.component";
import {Logger} from "angular2-logger/core";
import {URLComponent} from "./url/url.component";
import {PasswordEncodingSettingsComponent} from "./settings/password-encoding/password-encoding-settings.component";
import {ServerInformationComponent} from "./information/server-information.component";
import {SettingsService} from "app/settings/settings.service";

@NgModule({
    declarations: [
        AppComponent,
        CORSSettingsComponent,
        PasswordEncodingSettingsComponent,
        HeaderComponent,
        FooterComponent,
        URLComponent,
        ServerInformationComponent
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
        MdSlideToggleModule,
        MdGridListModule,
        MdMenuModule,
        MdIconModule,
        MdSelectModule
    ],
    providers: [Logger, SettingsService],
    bootstrap: [AppComponent]
})
export class AppModule {}
