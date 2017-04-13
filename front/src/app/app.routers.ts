import {Routes} from "@angular/router";
import {SettingsComponent} from "./settings/app.settings-component";
import {CROSSettingsComponent} from "./settings/cors/cors-settings-component";

export const APPLICATION_ROUTERS: Routes = [
  {
    path: 'settings',
    component: SettingsComponent
  },
  {
    path: 'settings/cros-settings',
    component: CROSSettingsComponent
  }
];
