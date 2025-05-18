import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { AppRoutingModule } from '../app-routing.module';
import { HeaderMainComponent } from './header-main/header-main.component';
import { HeaderHomeComponent } from './header-home/header-home.component';
import { HeaderLoginComponent } from './header-login/header-login.component';

@NgModule({
  declarations: [
    HeaderComponent,
    FooterComponent,
    HeaderMainComponent,
    HeaderHomeComponent,
    HeaderLoginComponent
  ],
  imports: [
    CommonModule,
    AppRoutingModule
  ],
  exports: [
    HeaderComponent,
    FooterComponent,
    HeaderMainComponent,
    HeaderHomeComponent,
    HeaderLoginComponent
  ]
})
export class ComponentsModule { }
