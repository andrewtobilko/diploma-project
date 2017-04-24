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
    @Input() shouldRemoveButtonBeShown: boolean = true;

}

// https://ssl.gstatic.com/images/branding/product/1x/avatar_circle_blue_512dp.png