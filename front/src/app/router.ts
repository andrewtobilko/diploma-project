import {Routes} from "@angular/router";
import {CORSSettingsComponent} from "settings/cors/cors-settings.component";

export const APPLICATION_ROUTERS: Routes = [
    {
        path: 'settings/cors',
        component: CORSSettingsComponent
    }
];