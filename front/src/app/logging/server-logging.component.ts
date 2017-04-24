import {Component, OnInit} from "@angular/core";
import {ServerLoggingService} from "./service/server-logging.service";

@Component({
    selector: 'server-logging',
    templateUrl: './server-logging.component.html',
    styleUrls: ['./server-logging.component.css'],
    providers: [ServerLoggingService]
})
export class ServerLoggingComponent implements OnInit {

    messages: Array<string>;

    constructor(private service: ServerLoggingService) {
    }

    ngOnInit(): void {
        this.prepareServerLogs();
    }

    prepareServerLogs(): void {
        this.service
            .fetchAllServerLoggerMessages()
            .subscribe(array => this.initialiseMessages(array));
    }

    initialiseMessages(logs: Array<string>): void {
        this.messages = logs;
    }

}