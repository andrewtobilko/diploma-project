import {Injectable} from "@angular/core";
import {Observable} from "rxjs";
import {Logger} from "angular2-logger/core";
import {Http} from "@angular/http";

@Injectable()
export class ServerLoggingService {

    constructor(private http: Http, private logger: Logger) {}

    fetchAllServerLoggerMessages(): Observable<Array<string>> {
        return this.http
            .get("http://localhost:5000/api/logging")
            .map(response => response.json() as Array<string>);
    }

}