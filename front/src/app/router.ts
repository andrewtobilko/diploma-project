import {Routes} from "@angular/router";
import {CORSSettingsComponent} from "./settings/cors/cors-settings.component";
import {PasswordEncodingSettingsComponent} from "./settings/password-encoding/password-encoding-settings.component";
import {ServerInformationComponent} from "./information/server-information.component";

export const APPLICATION_ROUTERS: Routes = [
    {
        path: 'settings/cors',
        component: CORSSettingsComponent
    },
    {
        path: 'settings/password-encoding',
        component: PasswordEncodingSettingsComponent
    },
    {
        path: 'information',
        component: ServerInformationComponent
    }
];