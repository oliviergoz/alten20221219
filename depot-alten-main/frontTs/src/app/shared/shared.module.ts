import {ModuleWithProviders, NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {TranslateModule} from '@ngx-translate/core';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {TableModule} from 'primeng/table';
import {MultiSelectModule} from 'primeng/multiselect';
import {InputTextModule} from 'primeng/inputtext';
import {MessageModule} from 'primeng/message';
import {AutoCompleteModule} from 'primeng/autocomplete';
import {DropdownModule} from 'primeng/dropdown';
import {CoreModule} from '@owlink/core/core.module';
import {TooltipModule} from 'primeng/tooltip';

@NgModule({
    imports: [
        CommonModule,
        TranslateModule,
        FormsModule,
        TableModule,
        MultiSelectModule,
        ReactiveFormsModule,
        InputTextModule,
        MessageModule,
        CoreModule,
        AutoCompleteModule,
        TooltipModule,
        DropdownModule,
    ],
    exports: [
        TranslateModule,
        TableModule,
        ReactiveFormsModule,
        FormsModule,
    ],
})
export class SharedModule {
    static forRoot(): ModuleWithProviders<SharedModule> {
        return {
            ngModule: SharedModule,
            providers: []
        };
    }
}
