import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { AboutComponent } from './about/about.component';
import { ContactComponent } from './contact/contact.component';
import { NotFoundComponent } from './not-found/not-found.component';
import { LiteratureComponent } from './literature/literature.component';
import { ScienceComponent } from './science/science.component';
import { NatureComponent } from './nature/nature.component';
import { LibraryComponent } from './library/library.component';
import { AdventureComponent } from './adventure/adventure.component';
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';



@NgModule({
  declarations: [
    HomeComponent,
    AboutComponent,
    ContactComponent,
    NotFoundComponent,
    LibraryComponent,
    AdventureComponent,
    LoginComponent,
    SignupComponent,
  ],
  imports: [
    CommonModule,
    RouterModule,
    LiteratureComponent,
    ScienceComponent,
    NatureComponent,
  ]
})
export class PagesModule { }
