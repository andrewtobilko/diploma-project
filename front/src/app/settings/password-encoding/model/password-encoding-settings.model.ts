import {SettingsState} from "app/settings/state/settings-state.model";
import {PasswordEncodingMethod} from "../method/password-encoding-method.model";

export class PasswordEncodingSettings {

    constructor(private state: SettingsState,
                private method?: PasswordEncodingMethod) {}

    get getState(): SettingsState {
        return this.state;
    }

    get getMethod(): PasswordEncodingMethod {
        return this.method;
    }

}