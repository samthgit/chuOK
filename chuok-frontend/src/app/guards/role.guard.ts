import { Injectable } from '@angular/core';
import { CanActivate, Router } from '@angular/router';
import { AuthService } from '../services/auth.service';

/**
 * RoleGuard
 *
 * Angular route guard that restricts access to routes based on user role.
 * Only allows navigation if the user has the 'ADMIN' role; otherwise redirects to home.
 */
@Injectable({
  providedIn: 'root'
})
export class RoleGuard implements CanActivate {

  constructor(private authService: AuthService, private router: Router) {}

  /**
   * Determines if the route can be activated based on user role.
   * @returns true if user is ADMIN, false and redirects otherwise
   */
  canActivate(): boolean {
    const role = this.authService.getUserRole();
    if (role === 'ADMIN') {
      return true;
    } else {
      this.router.navigate(['/']);
      return false;
    }
  }
}
