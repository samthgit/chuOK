// MainComponent: Handles animated panel reveal and main landing page logic
import { CommonModule } from '@angular/common';
import { Component, ElementRef, OnDestroy, OnInit, ViewChild } from '@angular/core';
import { RouterModule, Router } from '@angular/router';

/**
 * MainComponent is the landing page for chuOK.
 * Handles scroll-triggered panel animations using ViewChild and window events.
 */
@Component({
  selector: 'app-main',
  standalone: true,
  imports: [CommonModule, RouterModule],
  templateUrl: './main.component.html',
  styleUrl: './main.component.css'
})
export class MainComponent implements OnInit, OnDestroy {
  /** Whether to show animated panels (set when in view) */
  showPanels = false;
  /** Reference to the main content element for scroll detection */
  @ViewChild('mainContent', { static: true }) mainContentRef!: ElementRef;
  /** Bound scroll event handler */
  private scrollHandler = this.checkMainContentInView.bind(this);

  // Set up scroll event listener on init
  ngOnInit() {
    // Add scroll event listener to trigger panel animation
    if (typeof window !== 'undefined') {
      window.addEventListener('scroll', this.scrollHandler);
      // Initial check in case already in view
      setTimeout(() => this.checkMainContentInView(), 0);
    }
  }

  // Remove scroll event listener on destroy
  ngOnDestroy() {
    // Remove scroll event listener on destroy
    if (typeof window !== 'undefined') {
      window.removeEventListener('scroll', this.scrollHandler);
    }
  }

  /**
   * Checks if the main content is in the viewport and triggers panel animation.
   */
  checkMainContentInView() {
    if (this.showPanels) return;
    const el = this.mainContentRef?.nativeElement;
    if (!el) return;
    const rect = el.getBoundingClientRect();
    const centerY = rect.top + rect.height / 2;
    const viewportHeight = window.innerHeight || document.documentElement.clientHeight;
    if (centerY > 0 && centerY < viewportHeight) {
      this.showPanels = true;
    }
  }
}
