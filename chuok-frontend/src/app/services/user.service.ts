import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

/**
 * Role interface
 * Represents a user role with an id and name.
 */
export interface Role {
  id: number;
  name: string;
}

/**
 * User interface
 * Represents a user with id, name, email, and role.
 */
export interface User {
  id: number;
  name: string;
  email: string;
  role: Role;
}

/**
 * UserService
 *
 * Provides methods to interact with the backend user API for:
 * - Fetching all users
 * - Updating a user's role
 */
@Injectable({
  providedIn: 'root'
})
export class UserService {
  private apiUrl = 'http://localhost:8080/api/users'; // Base URL for user API

  constructor(private http: HttpClient) {}

  /**
   * Fetch all users from the backend.
   * @returns Observable<User[]>
   */
  getUsers(): Observable<User[]> {
    return this.http.get<User[]>(this.apiUrl);
  }

  /**
   * Update a user's role by userId and roleId.
   * @param userId - ID of the user to update
   * @param roleId - ID of the new role
   * @returns Observable<User> with updated user
   */
  updateUserRole(userId: number, roleId: number): Observable<User> {
    return this.http.put<User>(`${this.apiUrl}/${userId}/role`, { roleId });
  }
}
