import {Component, OnInit} from '@angular/core';
import {TranslateService} from '@ngx-translate/core';

@Component({
    selector: 'app-root',
    templateUrl: './app.component.html',
    styleUrls: ['./app.component.css']
})
export class AppComponent {
    title = 'owlinkbytessi2';
    href: string;
    accessIframe = false;

    constructor(
        private translate: TranslateService,
    ) {
        translate.setDefaultLang('fr');
        translate.use('fr');
    }
}
