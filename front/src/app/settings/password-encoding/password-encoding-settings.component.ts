import {SettingsService} from "../settings.service";
import {Component} from "@angular/core";
import {PasswordEncodingSettings} from "app/settings/password-encoding/model/password-encoding-settings.model";
import {SettingsState} from "../state/settings-state.model";
import {PasswordEncodingMethod} from "app/settings/password-encoding/method/password-encoding-method.model";

@Component({
    selector: 'password-encoding-settings',
    templateUrl: './password-encoding-settings.component.html',
    styleUrls: ['./password-encoding-settings.component.css'],
    providers: [SettingsService]
})
export class PasswordEncodingSettingsComponent {

    enabled: boolean;
    encodingMethod: PasswordEncodingMethod;

    methods: Array<PasswordEncodingMethod> = [
        PasswordEncodingMethod.BCRYPT,
        PasswordEncodingMethod.PBKDF2,
        PasswordEncodingMethod.SCRYPT,
    ];

    constructor(private service: SettingsService) {}

    savePasswordEncodingConfiguration(): void {
        this.service.savePasswordEncodingConfiguration(
            new PasswordEncodingSettings(
                SettingsState.convertBooleanToSettingsStateString(this.enabled),
                this.encodingMethod)
        );
    }

}