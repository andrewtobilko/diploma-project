import {SettingsState} from "app/settings/state/settings-state.model";

export class AuthenticationSettings {

    constructor(private state: SettingsState) {
    }

    get getState(): SettingsState {
        return this.state;
    }

}