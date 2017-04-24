import {Injectable} from "@angular/core";
import {SettingsService} from "app/settings/settings.service";
import {Observable} from "rxjs";
import {CORSSettings} from "../../settings/cors/model/cors-settings.model";
import {PasswordEncodingSettings} from "../../settings/password-encoding/model/password-encoding-settings.model";

@Injectable()
export class ServerInformationService {

    constructor(private settingsService: SettingsService) {}

    obtainServerCORSInformation(): Observable<CORSSettings> {
        return this.settingsService
            .fetchCORSSettings()
            .map(configuration => configuration[0]);
    }

    obtainServerPasswordEncodingInformation(): Observable<PasswordEncodingSettings> {
        return this.settingsService
            .fetchPasswordEncodingSettings()
            .map(configuration => configuration[0]);
    }

}