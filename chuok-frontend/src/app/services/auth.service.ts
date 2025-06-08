import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, tap } from 'rxjs';

interface AuthResponse {
  token: string;
}

interface RegisterRequest {
  username: string;
  email: string;
  password: string;
}

interface LoginRequest {
  email: string;
  password: string;
}

/**
 * AuthService handles user authentication, registration, token management, and login state.
 * Stores JWT token in localStorage and provides helper methods for authentication status.
 */
@Injectable({
  providedIn: 'root'
})
export class AuthService {
  /** Base URL for the authentication API */
  private baseUrl = 'http://localhost:8080/api/auth'; 
  /** Key used to store the JWT token in localStorage */
  private tokenKey = 'auth_token';

  constructor(private http: HttpClient) {}

  /**
   * Registers a new user and stores the JWT token on success.
   */
  register(data: RegisterRequest): Observable<AuthResponse> {
    return this.http.post<AuthResponse>(`${this.baseUrl}/register`, data).pipe(
      tap(response => {
        localStorage.setItem(this.tokenKey, response.token);
      })
    );
  }

  /**
   * Logs in a user and stores the JWT token on success.
   */
  login(data: LoginRequest): Observable<AuthResponse> {
    return this.http.post<AuthResponse>(`${this.baseUrl}/login`, data).pipe(
      tap(response => {
        localStorage.setItem(this.tokenKey, response.token);
      })
    );
  }

  /**
   * Logs out the user by removing the JWT token from localStorage.
   */
  logout() {
    localStorage.removeItem(this.tokenKey);
  }

  /**
   * Retrieves the JWT token from localStorage, or null if not present.
   */
  getToken(): string | null {
    if (typeof window !== 'undefined' && window.localStorage) {
      return localStorage.getItem(this.tokenKey);
    }
    return null;
  }

  /**
   * Returns true if a JWT token is present (user is logged in).
   */
  isLoggedIn(): boolean {
    return !!this.getToken();
  }
}
