import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {SidebarLeftComponent} from './components/sidebar-left/sidebar-left.component';
import {HeaderComponent} from './components/header/header.component';
import {FooterComponent} from '@owlink/features/global-ui/components/footer/footer.component';
import {CoreModule} from '@owlink/core/core.module';
import {LayoutService} from '@owlink/features/global-ui/services/layout.service';
import {FormsModule} from '@angular/forms';
import {TranslateModule} from '@ngx-translate/core';
import {SharedModule} from '@owlink/shared/shared.module';
import {RouterModule} from '@angular/router';

@NgModule({
    declarations: [SidebarLeftComponent, HeaderComponent, FooterComponent],
    imports: [
        CommonModule,
        CoreModule,
        FormsModule,
        TranslateModule,
        SharedModule,
        RouterModule
    ],
    exports: [SidebarLeftComponent, HeaderComponent, FooterComponent],
    providers: [LayoutService]
})
export class GlobalUiModule { }
