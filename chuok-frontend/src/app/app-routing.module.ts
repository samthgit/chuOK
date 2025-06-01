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
import { authGuard } from './guards/auth.guard';
import { NoAuthGuard } from './guards/no-auth.guard';

const routes: Routes = [
  // Public routes
  { path: '', redirectTo: '/main', pathMatch: 'full' },
  { path: 'main', component: MainComponent, canActivate: [NoAuthGuard] },
  { path: 'about', component: AboutComponent },
  { path: 'contact', component: ContactComponent },
  { path: 'login', component: LoginComponent },
  { path: 'signup', component: SignupComponent },

  // Protected routes
  { path: 'home', component: HomeComponent, canActivate: [authGuard] },
  { path: 'user-center', component: ProfileComponent, canActivate: [authGuard] },
  { path: 'library', component: LibraryComponent, canActivate: [authGuard] },
  { path: 'library/articles', component: ArticlesComponent, canActivate: [authGuard] },
  { path: 'library/phrases', component: PhrasesComponent, canActivate: [authGuard] },
  { path: 'adventure', component: AdventureComponent, canActivate: [authGuard] },
  { path: 'adventure/literature', component: LiteratureComponent, canActivate: [authGuard] },
  { path: 'adventure/science', component: ScienceComponent, canActivate: [authGuard] },
  { path: 'adventure/nature', component: NatureComponent, canActivate: [authGuard] },

  { path: '**', redirectTo: '/main' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
