import {SettingsService} from "../settings.service";
import {Component, OnInit} from "@angular/core";
import {PasswordEncodingSettings} from "app/settings/password-encoding/model/password-encoding-settings.model";
import {SettingsState} from "../state/settings-state.model";
import {PasswordEncodingMethod} from "app/settings/password-encoding/method/password-encoding-method.model";
import {Logger} from "angular2-logger/core";

@Component({
    selector: 'password-encoding-settings',
    templateUrl: './password-encoding-settings.component.html',
    styleUrls: ['./password-encoding-settings.component.css'],
    providers: [SettingsService]
})
export class PasswordEncodingSettingsComponent implements OnInit {

    enabled: boolean;
    encodingMethod: PasswordEncodingMethod;

    methods: Array<PasswordEncodingMethod> = [
        PasswordEncodingMethod.BCRYPT,
        PasswordEncodingMethod.PBKDF2,
        PasswordEncodingMethod.SCRYPT,
    ];

    constructor(private service: SettingsService, private logger: Logger) {}

    ngOnInit(): void {
        this.service.fetchPasswordEncodingSettings()
            .subscribe(configuration => this.initConfiguration(configuration[0]));
    }

    private initConfiguration(configuration: PasswordEncodingSettings): void {
        this.logger.warn("Password encoding configuration: ", configuration);

        this.enabled = SettingsState.convertSettingsStateToBoolean(configuration.getState);
        this.encodingMethod = configuration.getMethod;
    }

    savePasswordEncodingConfiguration(): void {
        this.service.savePasswordEncodingConfiguration(
            new PasswordEncodingSettings(
                SettingsState.convertBooleanToSettingsStateString(this.enabled),
                this.encodingMethod)
        );
    }

}