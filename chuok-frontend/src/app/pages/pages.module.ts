import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { MainComponent } from './main/main.component';
import { HomeComponent } from './home/home.component';
import { AboutComponent } from './about/about.component';
import { ContactComponent } from './contact/contact.component';
import { NotFoundComponent } from './not-found/not-found.component';
import { LiteratureComponent } from './literature/literature.component';
import { ScienceComponent } from './science/science.component';
import { NatureComponent } from './nature/nature.component';
import { LibraryComponent } from './library/library.component';
import { AdventureComponent } from './adventure/adventure.component';
import { ArticlesComponent } from './articles/articles.component';
import { PhrasesComponent } from './phrases/phrases.component';
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';



@NgModule({
  declarations: [
    MainComponent,
    HomeComponent,
    AboutComponent,
    ContactComponent,
    NotFoundComponent,
    LibraryComponent,
    AdventureComponent,
    ArticlesComponent,
    PhrasesComponent,
    LoginComponent,
    SignupComponent
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
