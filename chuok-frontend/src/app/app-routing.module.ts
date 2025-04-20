import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './pages/home/home.component';
import { AboutComponent } from './pages/about/about.component';
import { ContactComponent } from './pages/contact/contact.component';
import { MainComponent } from './pages/main/main.component';

const routes: Routes = [
  { path: '', redirectTo: '/main', pathMatch: 'full' },
  { path: 'main', component: MainComponent }, // Main page
  { path: 'home' , component: HomeComponent }, // Home page, unique for every user
  { path: 'about', component: AboutComponent }, // About page
  { path: 'contact', component: ContactComponent }, // Contact page
  { path: '**', redirectTo: '/main' } // Redirect to main for any unknown routes
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
