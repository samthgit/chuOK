import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  standalone: false,
  styleUrl: './app.component.css'
})
export class AppComponent {
  currentRoute: string = '';

  constructor(private router: Router) {
    this.router.events.subscribe(() => {
      this.currentRoute = this.router.url;
    });
  }

  get headerType(): 'default' | 'main' | 'home' | 'login' {
    if (this.currentRoute.includes('/main')) return 'main';
    if (this.currentRoute.includes('/about')) return 'main';
    if (this.currentRoute.includes('/contact')) return 'main';
    if (this.currentRoute.includes('/login')) return 'login';
    if (this.currentRoute.includes('/signup')) return 'login';
    return 'default';
  }

  get hideHeaderFooter(): boolean {
    return this.router.url === '/login' || this.router.url === '/signup';
  }
}