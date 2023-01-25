import {CUSTOM_ELEMENTS_SCHEMA, NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {LoginInfoComponent} from '@owlink/core/login-info';
import {LogoutComponent} from '@owlink/core/logout/logout.component';
import {TableModule} from 'primeng/table';

@NgModule({
    imports: [
        CommonModule,
    ],
    declarations: [
        LoginInfoComponent,
        LogoutComponent,
    ],
    exports: [
        LoginInfoComponent,
        LogoutComponent,
        TableModule
    ],
})
export class CoreModule {
}
