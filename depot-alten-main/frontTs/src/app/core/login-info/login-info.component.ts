import {Component, OnInit} from '@angular/core';
import {UserService} from '@owlink/core/service/user.service';
import {LayoutService} from '@owlink/features/global-ui/services/layout.service';

@Component({
    selector: 'sa-login-info',
    templateUrl: './login-info.component.html',
})
export class LoginInfoComponent implements OnInit {

    user: any;

    constructor(
        private userService: UserService,
        private layoutService: LayoutService) {
    }

    ngOnInit() {
        this.userService.getLoginInfo().subscribe(user => {
            const username = localStorage.getItem('ngStorage-username');
            if (username) {
                user.username = username.split('"').join('');
                this.user = user;
            }
        });

    }

    toggleShortcut() {
        this.layoutService.onShortcutToggle();
    }

}
