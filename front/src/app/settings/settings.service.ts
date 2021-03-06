import {CORSSettings} from "./cors/model/cors-settings.model";
import {Injectable} from "@angular/core";
import {Headers, Http} from "@angular/http";
import {Observable} from "rxjs";
import {Logger} from "angular2-logger/core";
import {SettingsState} from "./state/settings-state.model";
import {PasswordEncodingSettings} from "./password-encoding/model/password-encoding-settings.model";
import {User} from "app/settings/authentication/user/model/user.model";
import {AuthenticationSettings} from "./authentication/model/authentication-settings.model";

@Injectable()
export class SettingsService {

    constructor(private http: Http,
                private logger: Logger) {}

    saveCORSSettings(settings: CORSSettings): void {
        this.logger.warn('Sending a PUT to the server...', settings);

        this.http
            .put("http://localhost:5000/api/cors/modify", settings)
            .subscribe(response => this.logger.warn(response));
    }

    fetchCORSSettings(): Observable<CORSSettings[]> {
        this.logger.warn('Fetching a CORS configuration...');

        //let headers = new Headers();
        //headers.append('Authorization', 'Basic ' + btoa('admin:admin'));

        return this
            .http
            .get("http://localhost:5000/api/cors"/*, {headers: headers}*/)
            .map(response => {
                var configurations = response.json()._embedded["cors-configurations"];

                return configurations
                    .map(configuration => new CORSSettings(configuration.state, configuration.map));
            });
    }

    removeCORSURLFromList(state: SettingsState, url: string): void {
        var urlToDelete = "http://localhost:5000/api/cors/remove-url?url=" + url + "&state=" + state;

        this.logger.warn("urlToDelete", urlToDelete);

        this.http
            .delete(urlToDelete)
            .subscribe(response => this.logger.warn(response));
    }

    fetchPasswordEncodingSettings(): Observable<PasswordEncodingSettings[]> {
        this.logger.warn('Fetching a password encoding configuration...');

        return this.http
            .get("http://localhost:5000/api/password-encoding")
            .map(response => {
                var configurations = response.json()._embedded["password-encoding-configurations"];

                return configurations
                    .map(configuration => new PasswordEncodingSettings(configuration.state, configuration.method));
            });
    }

    saveAuthenticationSettings(settings: AuthenticationSettings): void {
        this.logger.warn('Sending a PUT to the server...', settings);

        this.http
            .put("http://localhost:5000/api/authentication/modify", settings)
            .subscribe(response => this.logger.warn(response));
    }

    fetchAllUsers(): Observable<User[]> {
        return this.http
            .get("http://localhost:5000/api/users")
            .map(response => {
                var users = response.json()._embedded["users"];

                return users.map(user => new User(user.login, user.password, user.id));
            });
    }

    fetchAuthenticationSettings(): Observable<AuthenticationSettings[]> {
        this.logger.warn('Fetching auth configuration...');

        return this.http
            .get("http://localhost:5000/api/authentication")
            .map(response => {
                var configurations = response.json()._embedded["authentication-configurations"];

                return configurations
                    .map(configuration => new AuthenticationSettings(configuration.state));
            });
    }


    savePasswordEncodingConfiguration(configuration: PasswordEncodingSettings): void {
        this.http
            .put("http://localhost:5000/api/password-encoding/modify", configuration)
            .subscribe(response => this.logger.warn(response));
    }

    saveUser(user: User): void {
        this.http
            .post("http://localhost:5000/api/users", user)
            .subscribe(response => this.logger.warn(response));
    }

    removeUserWithServiceByLogin(login: string): void {
        this.http
            .get("http://localhost:5000/api/users/search/remove-by-login?login=" + login)
            .subscribe(response => this.logger.warn(response));
    }

}