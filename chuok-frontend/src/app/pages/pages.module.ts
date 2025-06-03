import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
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
import { PublicArticlesComponent } from './public-articles/public-articles.component';
import { PublicGamesComponent } from './public-games/public-games.component';
import { PublicGuidesComponent } from './public-guides/public-guides.component';



@NgModule({
  declarations: [
    HomeComponent,
    AboutComponent,
    ContactComponent,
    NotFoundComponent,
    LibraryComponent,
    AdventureComponent,
    PublicArticlesComponent,
    PublicGamesComponent,
    PublicGuidesComponent,
  ],
  imports: [
    CommonModule,
    FormsModule,
    RouterModule,
    LiteratureComponent,
    ScienceComponent,
    NatureComponent,
    LoginComponent,
    SignupComponent,
  ]
})
export class PagesModule { }
