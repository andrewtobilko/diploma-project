import {Component, OnInit} from "@angular/core";
import {SettingsService} from "../settings.service";
import {CORSSettings} from "./model/cors-settings.model";
import {SettingsState} from "../state/settings-state.model";
import {Logger} from "angular2-logger/core";

@Component ({
    selector: 'cors-settings',
    templateUrl: './cors-settings.component.html',
    styleUrls: ['./cors-settings.component.css'],
    providers: [SettingsService]
})
export class CORSSettingsComponent implements OnInit {

    enabled: boolean;
    url: string;
    map: object;

    list: Array<string>;

    constructor(private service: SettingsService,
                private logger: Logger) {}

    ngOnInit(): void {
        this.service.fetchCORSSettings()
            .subscribe(configuration => this.initConfiguration(configuration[0]));
    }

    private initConfiguration(configuration: CORSSettings): void {
        this.logger.warn("Configuration: ", configuration);

        this.enabled = SettingsState.convertSettingsStateToBoolean(configuration.getState);
        this.map = configuration.getMap;
        this.list = this.map[SettingsState.convertBooleanToSettingsStateString(this.enabled)].urls;
    }

    changeOption(): void {
        this.list = this.map[SettingsState.convertBooleanToSettingsStateString(this.enabled)].urls;
    }

    saveCORSConfiguration(): void {
        this.service.saveCORSSettings(new CORSSettings(SettingsState.convertBooleanToSettingsStateString(this.enabled), this.map));
    }

    addURLFromInputToList(): void {
        if (!this.isThereElementInTheList(this.list, this.url)) {
            this.list.push(this.url);
        }
    }

    private isThereElementInTheList(list: Array<string>, element: string): boolean {
        return list.indexOf(element) != -1;
    }

    isAddButtonDisabled(): boolean {
        return !this.url || this.url.length == 0;
    }

    removeURLFromList(url: string): void {
        this.removeURLFromListLocally(url);

        console.log("removeURLFromList", this.enabled, SettingsState.convertBooleanToSettingsStateString(this.enabled));

        this.service.removeCORSURLFromList(SettingsState.convertBooleanToSettingsStateString(this.enabled), url);
    }

    private removeURLFromListLocally(url: string): void {
        var index = this.list.indexOf(url);

        if (index > -1) {
            this.list.splice(index, 1);
        }
    }

}