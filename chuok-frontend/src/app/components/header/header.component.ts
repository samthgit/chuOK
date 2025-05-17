import { Component, ElementRef, HostListener, ViewChild, OnInit, OnDestroy } from '@angular/core';
import { Router, NavigationEnd } from '@angular/router';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-header',
  standalone: false,
  templateUrl: './header.component.html',
  styleUrl: './header.component.css'
})
export class HeaderComponent implements OnInit, OnDestroy {
  navOpen = false;

  @ViewChild('navBar') navBar!: ElementRef;
  private routerEventsSub!: Subscription;

  constructor(private router: Router) {}

ngOnInit(): void {
  this.routerEventsSub = this.router.events.subscribe(event => {
    if (event instanceof NavigationEnd) {
      setTimeout(() => {
        this.navOpen = false;
      }, 0); // allow next view to fully render
    }
  });
}


  ngOnDestroy(): void {
    // Limpia la suscripción para evitar fugas de memoria
    if (this.routerEventsSub) {
      this.routerEventsSub.unsubscribe();
    }
  }

  toggleNav(): void {
    this.navOpen = !this.navOpen;
  }

  closeNav(): void {
    this.navOpen = false;
  }

  @HostListener('document:click', ['$event'])
  onDocumentClick(event: MouseEvent): void {
    if (!this.navOpen) return;

    const target = event.target as HTMLElement;
    if (this.navBar && !this.navBar.nativeElement.contains(target)) {
      this.navOpen = false;
    }
  }
}
