// LoginComponent: Handles user authentication form and error display
import { Component } from '@angular/core';
import { AuthService } from '../../services/auth.service';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

 /**
 * LoginComponent handles user authentication via a login form.
 * Uses Angular's AuthService for login and Router for navigation.
 * Displays error messages on failed login attempts.
 */
@Component({
  selector: 'app-login',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  /** User's email input */
  email: string = '';
  /** User's password input */
  password: string = '';
  /** Error message to display on login failure */
  errorMsg: string = '';

  // Inject AuthService for authentication and Router for navigation
  constructor(private authService: AuthService, private router: Router) {}

  /**
   * Handles form submission. Attempts login and navigates to /home on success.
   * Displays an error message if login fails.
   */
  onSubmit() {
    this.errorMsg = '';
    this.authService.login({ email: this.email, password: this.password }).subscribe({
      next: () => {
        this.router.navigate(['/home']);
      },
      error: (err) => {
        this.errorMsg = 'Error logging in. Please check your credentials.';
        console.error(err);
      }
    });
  }
}
