import {Routes} from "@angular/router";
import {SettingsComponent} from "./app.settings-component";
import {CROSSettingsComponent} from "app/app.CROS-settings-component";

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
