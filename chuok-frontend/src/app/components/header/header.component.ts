import { Component, ElementRef, HostListener, ViewChild, OnInit, OnDestroy, Inject, PLATFORM_ID } from '@angular/core';
import { Router, NavigationEnd } from '@angular/router';
import { Subscription } from 'rxjs';
import { isPlatformBrowser } from '@angular/common';
import { AuthService } from '../../services/auth.service';

/**
 * HeaderComponent displays the main header and navigation for authenticated users.
 * Handles nav menu open/close logic, logout, and closes the menu on navigation or outside click.
 */
@Component({
  selector: 'app-header',
  standalone: false,
  templateUrl: './header.component.html',
  styleUrl: './header.component.css'
})
export class HeaderComponent implements OnInit, OnDestroy {
  /** Whether the nav menu is open */
  navOpen = false;

  /** Reference to the nav bar element */
  @ViewChild('navBar') navBar!: ElementRef;
  /** Subscription to router events for closing nav on navigation */
  private routerEventsSub!: Subscription;

  constructor(
    private authService: AuthService,
    private router: Router,
    @Inject(PLATFORM_ID) private platformId: Object
  ) {}

  /**
   * Subscribes to router events to close nav and scroll to top on navigation.
   */
  ngOnInit(): void {
    this.routerEventsSub = this.router.events.subscribe(event => {
      if (event instanceof NavigationEnd) {
        if (isPlatformBrowser(this.platformId)) {
          // Only scroll to top in the browser environment
          window.scrollTo(0, 0);
        }
        
        setTimeout(() => {
          this.navOpen = false;
        }, 0);
      }
    });
  }

  /**
   * Unsubscribes from router events on destroy.
   */
  ngOnDestroy(): void {
    if (this.routerEventsSub) {
      this.routerEventsSub.unsubscribe();
    }
  }

  /**
   * Toggles the nav menu open/close state.
   */
  toggleNav(): void {
    this.navOpen = !this.navOpen;
  }

  /**
   * Closes the nav menu.
   */
  closeNav(): void {
    this.navOpen = false;
  }

  /**
   * Closes the nav menu if a click occurs outside the nav bar when open.
   */
  @HostListener('document:click', ['$event'])
  onDocumentClick(event: MouseEvent): void {
    if (!this.navOpen) return;

    const target = event.target as HTMLElement;
    if (this.navBar && !this.navBar.nativeElement.contains(target)) {
      this.navOpen = false;
    }
  }

  /**
   * Logs out the user, closes the nav, and navigates to the login page.
   */
  logout() {
    this.authService.logout();
    this.closeNav();
    this.router.navigate(['/login']);
  }
}
