import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { AppRoutingModule } from '../app-routing.module';
import { HeaderMainComponent } from './header-main/header-main.component';


@NgModule({
  declarations: [
    HeaderComponent,
    FooterComponent,
    HeaderMainComponent
  ],
  imports: [
    CommonModule,
    AppRoutingModule
  ],
  exports: [
    HeaderComponent,
    FooterComponent,
    HeaderMainComponent
  ]
})
export class ComponentsModule { }
