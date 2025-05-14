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

const routes: Routes = [
  { path: '', redirectTo: '/main', pathMatch: 'full' },
  { path: 'main', component: MainComponent }, // Main page
  { path: 'home' , component: HomeComponent }, // Home page, unique for every user
  { path: 'about', component: AboutComponent }, // About page
  { path: 'contact', component: ContactComponent }, // Contact page
  { path: 'literature', component: LiteratureComponent }, // Literature page
  { path: 'science', component: ScienceComponent }, // Science page
  { path: 'nature', component: NatureComponent }, // Nature page
  { path: 'library', component: LibraryComponent }, // Literature page with ID
  { path: 'adventure', component: AdventureComponent }, // Science page with ID
  { path: '**', redirectTo: '/main' } // Redirect to main for any unknown routes
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
