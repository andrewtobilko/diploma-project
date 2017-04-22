import {CORSSettings} from "./cors/model/cors-settings.model";
import {Injectable} from "@angular/core";
import {Http} from "@angular/http";

@Injectable()
export class SettingsService {

    constructor(private http: Http) {}

    saveCORSSettings(settings: CORSSettings): void {
        //this.http.put("");
    }

}