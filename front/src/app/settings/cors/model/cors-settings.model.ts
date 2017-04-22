import {SettingsState} from "app/settings/state/settings-state.model";

export class CORSSettings {

    constructor(private state: SettingsState,
                private map: object) {
        console.log("Init CORSSettings", state, map)
    }

    get getState(): SettingsState {
        return this.state;
    }

    get getMap(): object {
        return this.map;
    }

}