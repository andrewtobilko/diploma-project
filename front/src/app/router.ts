import {Routes} from "@angular/router";
import {SettingsComponent} from "app/settings/settings-component";
import {CORSSettingsComponent} from "app/settings/cors/cors-settings-component";

export const APPLICATION_ROUTERS: Routes = [
    {
        path: 'settings',
        component: SettingsComponent
    },
    {
        path: 'settings/cors',
        component: CORSSettingsComponent
    }
];