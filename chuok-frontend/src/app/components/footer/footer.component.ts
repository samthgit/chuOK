import { Component } from '@angular/core';
import { AuthService } from '../../services/auth.service';

@Component({
  selector: 'app-footer',
  standalone: false,
  templateUrl: './footer.component.html',
  styleUrl: './footer.component.css'
})
export class FooterComponent {
  constructor(public authService: AuthService) {}

  isAdmin(): boolean {
    return this.authService.getUserRole() === 'ADMIN';
  }
}
