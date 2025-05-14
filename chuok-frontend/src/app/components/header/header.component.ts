import { Component, ElementRef, HostListener,ViewChild } from '@angular/core';
import { Router, NavigationEnd } from '@angular/router';

@Component({
  selector: 'app-header',
  standalone: false,
  templateUrl: './header.component.html',
  styleUrl: './header.component.css'
})
export class HeaderComponent {
  navOpen = false;

  @ViewChild('navBar') navBar!: ElementRef;

    constructor(private router: Router) {
    this.router.events.subscribe(event => {
      if (event instanceof NavigationEnd) {
        this.navOpen = false; // Close the menu on navigation
      }
    });
  }

  toggleNav() {
    this.navOpen = !this.navOpen;
  }

  @HostListener('document:click', ['$event'])
  onDocumentClick(event: MouseEvent) {
    if (!this.navOpen) return;
    const target = event.target as HTMLElement;
    if (this.navBar && !this.navBar.nativeElement.contains(target)) {
      this.navOpen = false;
    }
  }
}
