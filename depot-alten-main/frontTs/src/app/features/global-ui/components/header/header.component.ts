import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';

@Component({
    selector: 'app-header',
    templateUrl: './header.component.html',
    styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

    searchMobileActive = false;

    constructor() {
    }

    ngOnInit() {
        this.getConnectedUser();
    }


    toggleSearchMobile() {
        this.searchMobileActive = !this.searchMobileActive;
    }

    onSubmit() {
    }

    switchLanguage(language) {

    }

    popupmessage() {

    }

    getConnectedUser() {
    }

    openDatabaseMonitoring() {
    }

    goToDashboard() {
    }

}
