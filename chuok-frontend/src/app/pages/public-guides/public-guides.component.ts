import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { DomSanitizer, SafeHtml } from '@angular/platform-browser';
import * as DOMPurify from 'dompurify';

@Component({
  selector: 'app-public-guides',
  standalone: true,
  imports: [CommonModule, RouterModule],
  templateUrl: './public-guides.component.html',
  styleUrls: ['./public-guides.component.css']
})
export class PublicGuidesComponent implements OnInit {
  currentGuideId: number = 1;
  guideContent: SafeHtml = '';
  
  sanitizeConfig = {
    ALLOWED_TAGS: ['h2', 'p', 'img'],
    ALLOWED_ATTR: ['class', 'href', 'src', 'alt'],
    FORBID_ATTR: ['onclick', 'onerror']
  };

  constructor(
    private route: ActivatedRoute,
    private http: HttpClient,
    private sanitizer: DomSanitizer
  ) {
    this.guideContent = this.sanitizer.bypassSecurityTrustHtml('');
  }

  ngOnInit(): void {
    this.route.paramMap.subscribe(params => {
      const id = Number(params.get('id'));
      if (id) {
        this.currentGuideId = id;
        this.loadGuideContent(id);
      }
    });
  }

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
