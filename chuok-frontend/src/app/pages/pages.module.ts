import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MainComponent } from './main/main.component';
import { HomeComponent } from './home/home.component';
import { AboutComponent } from './about/about.component';
import { ContactComponent } from './contact/contact.component';
import { NotFoundComponent } from './not-found/not-found.component';
import { LiteratureComponent } from './literature/literature.component';
import { ScienceComponent } from './science/science.component';
import { NatureComponent } from './nature/nature.component';



@NgModule({
  declarations: [
    MainComponent,
    HomeComponent,
    AboutComponent,
    ContactComponent,
    NotFoundComponent,
    LiteratureComponent,
    ScienceComponent,
    NatureComponent
  ],
  imports: [
    CommonModule
  ]
})
export class PagesModule { }
