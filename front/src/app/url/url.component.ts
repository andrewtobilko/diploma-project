import {Component, EventEmitter, Input, Output} from "@angular/core";

@Component({
    selector: 'url',
    templateUrl: './url.component.html',
    styleUrls: ['./url.component.css']
})
export class URLComponent {

    @Input() title: string;
    @Output() onRemove: EventEmitter<string> = new EventEmitter<string>();
    @Input() shouldRemoveButtonBeShown: boolean = true;

    removeURL(url: string) : void {
        this.onRemove.emit(url);
    }

}