import {CORSSettings} from "./cors/model/cors-settings.model";
import {Injectable} from "@angular/core";
import {Http} from "@angular/http";
import {Observable} from "rxjs";
import {Logger} from "angular2-logger/core";

@Injectable()
export class SettingsService {

    constructor(private http: Http, private logger: Logger) {}

    saveCORSSettings(settings: CORSSettings): void {
        this.logger.warn('Sending a PUT to the server...', settings);

        this.http
            .put("http://localhost:5000/api/cors/modify", settings)
            .subscribe(response => console.log(response));
    }

    fetchCORSSettings(): Observable<CORSSettings[]> {
        this.logger.warn('Fetching a CORS configuration...');

        return this.http
            .get("http://localhost:5000/api/cors")
            .map(response => {
                var configurations = response.json()._embedded["cors-configurations"];

                return configurations
                    .map(configuration => new CORSSettings(configuration.state, configuration.map));
            });
    }

}