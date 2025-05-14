import { Component, ElementRef, HostListener, ViewChild } from '@angular/core';

@Component({
  selector: 'app-header-main',
  standalone: false,
  templateUrl: './header-main.component.html',
  styleUrl: './header-main.component.css'
})
export class HeaderMainComponent {
  navOpen = false;

  @ViewChild('navBar') navBar!: ElementRef;

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
