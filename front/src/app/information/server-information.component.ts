import {Component, OnInit} from "@angular/core";
import {ServerInformationService} from "./service/server-information.service";
import {CORSSettings} from "../settings/cors/model/cors-settings.model";
import {PasswordEncodingSettings} from "app/settings/password-encoding/model/password-encoding-settings.model";
import {SettingsState} from "../settings/state/settings-state.model";

@Component({
    selector: 'server-information',
    templateUrl: './server-information.component.html',
    styleUrls: ['./server-information.component.css'],
    providers: [ServerInformationService]
})
export class ServerInformationComponent implements OnInit {

    serverCORSInformation : CORSSettings = new CORSSettings(false, null);
    serverPasswordEncodingInformation : PasswordEncodingSettings = new PasswordEncodingSettings(false);

    constructor(private service: ServerInformationService) {}

    ngOnInit(): void {
        this.prepareAllServerInformation();
    }

    private prepareAllServerInformation(): void {
        this.prepareCORSServerInformation();
        this.preparePasswordEncodingServerInformation();
    }

    private prepareCORSServerInformation(): void {
        this.service
            .obtainServerCORSInformation()
            .subscribe(configuration => this.initCORSServerInformation(configuration));
    }

    private initCORSServerInformation(settings: CORSSettings) {
        this.serverCORSInformation = settings;
        console.log("this.serverCORSInformation", this.serverCORSInformation)
    }

    private preparePasswordEncodingServerInformation(): void {
        this.service
            .obtainServerPasswordEncodingInformation()
            .subscribe(configuration => this.initPasswordEncodingServerInformation(configuration));
    }

    private initPasswordEncodingServerInformation(settings: PasswordEncodingSettings) {
        this.serverPasswordEncodingInformation = settings;
        console.log("this.serverPasswordEncodingInformation", this.serverPasswordEncodingInformation)
    }

    getCORSActualMap(): Array<string> {
        if (this.serverCORSInformation && this.serverCORSInformation.getMap) {
            return this.serverCORSInformation.getMap[this.serverCORSInformation.getState.toString()].urls;
        }
    }

    getBooleanFromCurrentSettingState(value: boolean): boolean {
        return SettingsState.convertSettingsStateToBoolean(value);
    }

}