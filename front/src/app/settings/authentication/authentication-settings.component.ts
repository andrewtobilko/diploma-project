import {SettingsService} from "../settings.service";
import {Component, OnInit} from "@angular/core";
import {User} from "./user/model/user.model";
import {SettingsState} from "../state/settings-state.model";
import {AuthenticationSettings} from "app/settings/authentication/model/authentication-settings.model";

@Component ({
    selector: 'authentication',
    templateUrl: './authentication-settings.component.html',
    styleUrls: ['./authentication-settings.component.css'],
    providers: [SettingsService]
})
export class AuthenticationSettingsComponent implements OnInit {

    enabled: boolean;
    userLogin: string;
    userPassword: string;
    users: Array<User> = [];

    constructor(private service: SettingsService) {}

    ngOnInit(): void {
        this.service.fetchAuthenticationSettings().subscribe(configuration => this.initConfiguration(configuration[0]));
    }

    private initConfiguration(configuration: AuthenticationSettings): void {
        this.enabled = SettingsState.convertSettingsStateToBoolean(configuration.getState);
    }

    saveUser() {
        var user = new User(this.userLogin, this.userPassword);

        this.saveUserLocally(user);
        this.saveUserWithService(user);
    }

    private saveUserLocally(user: User) {
        this.users.push(user);
    }

    private saveUserWithService(user: User) {
        this.service.saveUser(user);
    }

    removeUser(login: string) {
        this.removeUserLocally(login);
        this.removeUserWithServiceByLogin(login);
    }

    private removeUserLocally(login: string): void {
        // todo
    }

    private removeUserWithServiceByLogin(login: string): void {
        this.service.removeUserWithServiceByLogin(login);
    }

    isAddButtonDisabled(): boolean {
        return (!this.userLogin || this.userLogin.length == 0) ||
            (!this.userPassword || this.userPassword.length == 0);
    }

    saveAuthenticationConfiguration(): void {
        this.service.saveAuthenticationSettings(new AuthenticationSettings(SettingsState.convertBooleanToSettingsStateString(this.enabled)));
    }

}