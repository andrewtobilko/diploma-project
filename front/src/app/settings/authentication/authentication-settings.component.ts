import {SettingsService} from "../settings.service";
import {Component, OnInit} from "@angular/core";
import {User} from "./user/model/user.model";

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

        // todo

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

    isAddButtonDisabled(): boolean {
        return (!this.userLogin || this.userLogin.length == 0) ||
            (!this.userPassword || this.userPassword.length == 0);
    }

}