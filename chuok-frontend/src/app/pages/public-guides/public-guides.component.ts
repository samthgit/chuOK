import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { DomSanitizer, SafeHtml } from '@angular/platform-browser';
import * as DOMPurify from 'dompurify';

// Component for displaying public guides with HTML content loaded from assets.
// Handles route changes to load the correct guide and sanitizes HTML for safe display.
@Component({
  selector: 'app-public-guides',
  standalone: true,
  imports: [CommonModule, RouterModule],
  templateUrl: './public-guides.component.html',
  styleUrls: ['./public-guides.component.css']
})
export class PublicGuidesComponent implements OnInit {
  // The currently selected guide's ID
  currentGuideId: number = 1;
  // The sanitized HTML content of the guide
  guideContent: SafeHtml = '';
  // Configuration for allowed HTML tags and attributes during sanitization
  sanitizeConfig = {
    ALLOWED_TAGS: ['h2', 'p', 'img'],
    ALLOWED_ATTR: ['class', 'href', 'src', 'alt'],
    FORBID_ATTR: ['onclick', 'onerror']
  };

  /**
   * Injects dependencies for route handling, HTTP requests, and HTML sanitization.
   */
  constructor(
    private route: ActivatedRoute,
    private http: HttpClient,
    private sanitizer: DomSanitizer
  ) {
    // Initialize guideContent as empty safe HTML
    this.guideContent = this.sanitizer.bypassSecurityTrustHtml('');
  }

  /**
   * On component initialization, subscribes to route changes and loads the guide content.
   */
  ngOnInit(): void {
    this.route.paramMap.subscribe(params => {
      const id = Number(params.get('id'));
      if (id) {
        this.currentGuideId = id;
        this.loadGuideContent(id);
      }
    });
  }

  /**
   * Loads and sanitizes the HTML content for the given guide ID.
   * @param id The guide ID to load
   */
  loadGuideContent(id: number): void {
    this.http.get(`assets/guides/guide${id}.html`, { responseType: 'text' }).subscribe({
      next: (html) => {
        const cleanHtml = DOMPurify.default.sanitize(html, this.sanitizeConfig);
        this.guideContent = this.sanitizer.bypassSecurityTrustHtml(cleanHtml);
      },
      error: () => {
        this.guideContent = this.sanitizer.bypassSecurityTrustHtml(
          '<p class="error">Error cargando la guía</p>'
        );
      }
    });
  }
}
