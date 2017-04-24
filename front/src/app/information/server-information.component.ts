import {Component} from "@angular/core/src/core";
import {ServerInformationService} from "./service/server-information.service";

@Component({
    selector: 'server-information',
    templateUrl: './server-information.component.html',
    styleUrls: ['./server-information.component.css'],
    providers: [ServerInformationService]
})
export class ServerInformationComponent {



}