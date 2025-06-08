import { Component } from '@angular/core';
import { AuthService } from '../../services/auth.service';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

/**
 * SignupComponent handles new user registration via a signup form.
 * Uses Angular's AuthService for registration and Router for navigation.
 * Displays error messages on failed signup attempts.
 */
@Component({
  selector: 'app-signup',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent {
  /** User's chosen username */
  username: string = '';
  /** User's email input */
  email: string = '';
  /** User's password input */
  password: string = '';
  /** Error message to display on signup failure */
  errorMsg: string = '';

  constructor(private authService: AuthService, private router: Router) {}

  /**
   * Handles form submission. Attempts registration and navigates to /login on success.
   * Displays an error message if signup fails.
   */
  onSubmit() {
    this.errorMsg = '';
    this.authService.register({ username: this.username, email: this.email, password: this.password }).subscribe({
      next: () => {
        this.router.navigate(['/login']); // Redirect to login after successful signup
      },
      error: (err) => {
        this.errorMsg = 'Error signing up. Email might be already used.';
        console.error(err);
      }
    });
  }
}
