import {Routes} from "@angular/router";
import {SettingsComponent} from "./app.settings-component";
import {CROSSettingsComponent} from "cors-settings-component";

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
