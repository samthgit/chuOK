import { CommonModule } from '@angular/common';
import { Component, ElementRef, OnDestroy, OnInit, ViewChild } from '@angular/core';
import { RouterModule, Router } from '@angular/router';

@Component({
  selector: 'app-main',
  standalone: true,
  imports: [CommonModule, RouterModule],
  templateUrl: './main.component.html',
  styleUrl: './main.component.css'
})
export class MainComponent implements OnInit, OnDestroy {
  showPanels = false;
  @ViewChild('mainContent', { static: true }) mainContentRef!: ElementRef;
  private scrollHandler = this.checkMainContentInView.bind(this);

  ngOnInit() {
    if (typeof window !== 'undefined') {
      window.addEventListener('scroll', this.scrollHandler);
      // Initial check in case already in view
      setTimeout(() => this.checkMainContentInView(), 0);
    }
  }

  ngOnDestroy() {
    if (typeof window !== 'undefined') {
      window.removeEventListener('scroll', this.scrollHandler);
    }
  }

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
