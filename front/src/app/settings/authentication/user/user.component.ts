import {Component, Input, Output, EventEmitter} from "@angular/core";

@Component({
    selector: 'user',
    templateUrl: './user.component.html',
    styleUrls: ['./user.component.css']
})
export class UserComponent {

    @Input() userLogin: string;
    @Input() userPassword: string;

    @Output() onRemove: EventEmitter<string> = new EventEmitter<string>();

    removeUser(login: string) : void {
        this.onRemove.emit(login);
    }

}