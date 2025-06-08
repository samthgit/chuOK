import { Injectable } from '@angular/core';
import { CanActivate, Router } from '@angular/router';
import { AuthService } from '../services/auth.service';

/**
 * NoAuthGuard is a route guard that only allows access to routes if the user is NOT logged in.
 * If authenticated, redirects to the home page.
 * Used for protecting public routes like /main, /login, and /signup.
 */
@Injectable({
  providedIn: 'root'
})
export class NoAuthGuard implements CanActivate {

  constructor(private authService: AuthService, private router: Router) {}

  /**
   * Returns true if the user is NOT logged in. Redirects to /home if authenticated.
   */
  canActivate(): boolean {
    if (this.authService.isLoggedIn()) {
      // User is logged in --> redirect away from /main
      this.router.navigate(['/home']);
      return false;
    }
    return true;
  }
}
