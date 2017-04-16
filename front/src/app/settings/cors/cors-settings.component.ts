import { Component, Output } from '@angular/core';

@Component ({
    selector: 'cors-settings',
    templateUrl: './cors-settings.component.html',
    styleUrls: ['./cors-settings.component.css'],
})
export class CORSSettingsComponent {

    enabled: boolean = false;
    map = {
        false: ["enabled-url-1", "enabled-url-2", "enabled-url-3"],
        true: ["disabled-url-1", "disabled-url-2", "disabled-url-3"]
    };

    list: Array<string> = this.map[false.toString()];

    getPrefixForAddingURLSentence(): string {
        return this.enabled ? "un" : "";
    }

    changeOption(): void {
        this.list = this.map[this.enabled.toString()];
    }

    saveCORSConfiguration(): void {

    }

}