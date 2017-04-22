export class SettingsState {

    static ENABLED = "ENABLED";
    static DISABLED = "DISABLED";

    static convertBooleanToSettingsStateString(value: boolean): string {
        return (value ? SettingsState.ENABLED : SettingsState.DISABLED).toString();
    }

    static convertSettingsStateToBoolean(state: SettingsState): boolean {
        return state.toString() == SettingsState.ENABLED;
    }

}