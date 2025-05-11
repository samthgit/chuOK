import { Component, AfterViewInit, ViewChild, ElementRef } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-header',
  standalone: false,
  templateUrl: './header.component.html',
  styleUrl: './header.component.css'
})
export class HeaderComponent {
  @ViewChild('homeLink') home!: ElementRef<HTMLAnchorElement>;
  @ViewChild('literatureLink') literature!: ElementRef<HTMLAnchorElement>;
  @ViewChild('scienceLink') science!: ElementRef<HTMLAnchorElement>;
  @ViewChild('natureLink') nature!: ElementRef<HTMLAnchorElement>;

  currentRoute: string = '';
  currentCategory: string = '';

  constructor(private router: Router) {
    this.router.events.subscribe(() => {
      this.currentRoute = this.router.url;
      this.updateCurrentCategory();
      this.linkStyle();
    });
  }

  ngAfterViewInit() : void {
    this.linkStyle();
  }

  linkStyle() : void {
    // Limpia estilos primero si hace falta
    this.home.nativeElement.classList.remove('home');
    this.literature.nativeElement.classList.remove('literature');
    this.science.nativeElement.classList.remove('science');
    this.nature.nativeElement.classList.remove('nature');

    // Aplica estilos según la ruta
    switch (true) {
      case this.currentRoute.includes('/home'):
        this.home.nativeElement.classList.add('home');
        break;
      case this.currentRoute.includes('/literature'):
        this.literature.nativeElement.classList.add('literature');
        break;
      case this.currentRoute.includes('/science'):
        this.science.nativeElement.classList.add('science');
        break;
      case this.currentRoute.includes('/nature'):
        this.nature.nativeElement.classList.add('nature');
        break;
      default:
        break;
    }
  }

  updateCurrentCategory(): void {
    if (this.currentRoute.includes('/literature')) {
      this.currentCategory = 'literature';
    } else if (this.currentRoute.includes('/science')) {
      this.currentCategory = 'science';
    } else if (this.currentRoute.includes('/nature')) {
      this.currentCategory = 'nature';
    } else {
      this.currentCategory = ''; // Default or no category
    }
  }

  isCategoryPage(): boolean {
    return this.currentRoute.includes('/literature') || this.currentRoute.includes('/nature') || this.currentRoute.includes('/science');
  }
}
