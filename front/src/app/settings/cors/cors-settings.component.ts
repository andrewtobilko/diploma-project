import { Component, Output } from '@angular/core';
import {SettingsService} from "../settings.service";
import {CORSSettings} from "./model/cors-settings.model";

@Component ({
    selector: 'cors-settings',
    templateUrl: './cors-settings.component.html',
    styleUrls: ['./cors-settings.component.css'],
    providers: [SettingsService]
})
export class CORSSettingsComponent {

    enabled: boolean = false;
    url: string ;
    map = {
        false: ["enabled-url-1", "enabled-url-2", "enabled-url-3"],
        true: ["disabled-url-1", "disabled-url-2", "disabled-url-3"]
    };

    list: Array<string> = this.map[false.toString()];

    constructor(private service: SettingsService) {

    }

    getPrefixForAddingURLSentence(): string {
        return this.enabled ? "un" : "";
    }

    changeOption(): void {
        this.list = this.map[this.enabled.toString()];
    }

    saveCORSConfiguration(): void {
        this.service.saveCORSSettings(new CORSSettings(this.enabled, this.list));
    }

    addURLFromInputToList(): void {
        this.list.push(this.url);
    }

}