import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {TranslateHttpLoader} from '@ngx-translate/http-loader';
import {AppComponent} from '@owlink/app.component';
import {HttpClient, HttpClientModule} from '@angular/common/http';
import {AppRoutingModule} from '@owlink/app-routing.module';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {GlobalUiModule} from '@owlink/features/global-ui/global-ui.module';
import {UserService} from '@owlink/core/service/user.service';
import {DatePipe} from '@angular/common';
import {TranslateLoader, TranslateModule} from '@ngx-translate/core';
import {SharedModule} from '@owlink/shared/shared.module';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {TableModule} from 'primeng/table';
import {DropdownModule} from 'primeng/dropdown';
import {ChartModule} from 'primeng/chart';
import {MultiSelectModule} from 'primeng/multiselect';
import {HomeComponent} from './features/home/home.component';

@NgModule({
    declarations: [
        AppComponent,
        HomeComponent,
    ],
    imports: [
        ChartModule,
        FormsModule,
        ReactiveFormsModule,
        BrowserAnimationsModule,
        TableModule,
        DropdownModule,
        HttpClientModule,
        BrowserModule,
        TranslateModule.forRoot({
            loader: {
                provide: TranslateLoader,
                useFactory: HttpLoaderFactory,
                deps: [HttpClient]
            }
        }),
        BrowserAnimationsModule,
        AppRoutingModule,
        GlobalUiModule,
        SharedModule,
        MultiSelectModule,
    ],
    providers: [
        UserService,
        DatePipe,
    ],
    exports: [
        TranslateModule
    ],
    bootstrap: [
        AppComponent
    ]
})
export class AppModule {
}

export function HttpLoaderFactory(http: HttpClient) {
    return new TranslateHttpLoader(http, './assets/i18n/');
}
