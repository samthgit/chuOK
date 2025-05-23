import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './pages/home/home.component';
import { AboutComponent } from './pages/about/about.component';
import { ContactComponent } from './pages/contact/contact.component';
import { MainComponent } from './pages/main/main.component';
import { LiteratureComponent } from './pages/literature/literature.component';
import { ScienceComponent } from './pages/science/science.component';
import { NatureComponent } from './pages/nature/nature.component';
import { LibraryComponent } from './pages/library/library.component';
import { AdventureComponent } from './pages/adventure/adventure.component';
import { ArticlesComponent } from './pages/articles/articles.component';
import { PhrasesComponent } from './pages/phrases/phrases.component';
import { LoginComponent } from './pages/login/login.component';
import { SignupComponent } from './pages/signup/signup.component';
import { ProfileComponent } from './pages/profile/profile.component';

const routes: Routes = [
  { path: '', redirectTo: '/main', pathMatch: 'full' },
  { path: 'main', component: MainComponent }, // Main page
  { path: 'home' , component: HomeComponent }, // Home page, unique for every user
  { path: 'about', component: AboutComponent }, // About page
  { path: 'contact', component: ContactComponent }, // Contact page
  { path: 'login', component: LoginComponent }, // Login page
  { path: 'signup', component: SignupComponent }, // Signup page
  { path: 'user-center', component: ProfileComponent }, // Profile page, unique for every user
  { path: 'library', component: LibraryComponent }, // Library page
  { path: 'library/articles', component: ArticlesComponent }, // First library section - Articles page
  { path: 'library/phrases', component: PhrasesComponent}, // Second library section - Phrases page
  { path: 'adventure', component: AdventureComponent }, // Adventure Mode page
  { path: 'adventure/literature', component: LiteratureComponent }, // First adventure - Literature page
  { path: 'adventure/science', component: ScienceComponent }, // Second adventure - Science page
  { path: 'adventure/nature', component: NatureComponent }, // Third adventure - Nature page
  { path: '**', redirectTo: '/main' } // Redirect to main for any unknown routes
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
