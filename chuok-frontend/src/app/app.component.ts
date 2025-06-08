import { Component } from '@angular/core';
import { Router } from '@angular/router';

/**
 * AppComponent is the root component of the application.
 * It determines which header and footer to display based on the current route.
 * Uses Angular Router to listen for route changes and update UI accordingly.
 */
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  standalone: false,
  styleUrl: './app.component.css'
})
export class AppComponent {
  /** Stores the current route URL */
  currentRoute: string = '';

  constructor(private router: Router) {
    // Subscribe to router events to update currentRoute on navigation
    this.router.events.subscribe(() => {
      this.currentRoute = this.router.url;
    });
  }

  /**
   * Determines which header type to display based on the current route.
   * Returns one of: 'default', 'main', 'home', or 'login'.
   */
  get headerType(): 'default' | 'main' | 'home' | 'login' {
    if (this.currentRoute.includes('/main')) return 'main';
    if (this.currentRoute.includes('/about')) return 'main';
    if (this.currentRoute.includes('/contact')) return 'main';
    if (this.currentRoute.includes('/login')) return 'login';
    if (this.currentRoute.includes('/signup')) return 'login';
    return 'default';
  }

  /**
   * Hides the header on login and signup pages.
   */
  get hideHeader(): boolean {
    return this.router.url === '/login' || this.router.url === '/signup' || this.router.url === '/not-found';
  }

  /**
   * Hides the footer on login, signup, and user-center pages.
   */
  get hideFooter(): boolean {
    return this.router.url === '/login' || this.router.url === '/signup' || this.router.url === '/user-center' || this.router.url === '/not-found';
  }
}