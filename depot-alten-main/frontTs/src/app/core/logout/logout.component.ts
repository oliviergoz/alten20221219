import {Component} from '@angular/core';

@Component({
    selector: 'sa-logout',
    template: `
        <div id="logout" class="btn-header transparent pull-right">
        <span> <a (click)="showPopup($event)" href="javascript:void(0);" title="D&eacute;connexion" data-action="userLogout"
                  data-logout-msg="Souhaitez-vous fermer votre page de navigation ?"><i
            class="fa fa-sign-out"></i></a> </span>
        </div>
    `,
    styles: []
})
export class LogoutComponent {

    constructor() {
    }

    showPopup(e) {
        e.preventDefault();
        this.logout();
    }

    logout() {
        localStorage.removeItem('authToken');
    }

}
