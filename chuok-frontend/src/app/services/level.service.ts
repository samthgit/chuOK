import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { catchError, map, Observable, throwError } from 'rxjs';

export interface Level {
  id: number;
  levelNumber: number;
  question: string;
  option1: string;
  option2: string;
  option3: string;
  option4: string;
  correctIndex: number;
  world: {
    id: number;
    name: string;
    orderIndex: number;
  };
  completedLevels: any[];
}

export interface CompletedLevel {
  id: number;
  completionDate: string;
  level: Level;
}

/**
 * LevelService provides methods to fetch, complete, and get stats for adventure levels.
 * Handles API communication for levels, completed levels, and user stats.
 */
@Injectable({
    providedIn: 'root'
})
export class LevelService {
    /** Base URL for the levels API */
    private baseUrl = 'http://localhost:8080/api/levels';

    constructor(private http: HttpClient) {}

    /**
     * Fetches all levels for a given world ID.
     * Filters levels by world ID on the client side.
     */
    getLevelsByWorldId(worldId: number): Observable<Level[]> {
      return this.http.get<Level[]>(`${this.baseUrl}`).pipe(
        map(levels => levels.filter(level => level.world.id === worldId)),
        catchError(this.handleError)
      );
    }

    /**
     * Handles HTTP errors for level requests.
     */
    private handleError(error: HttpErrorResponse) {
      console.error('An error occurred:', error.error);
      return throwError(() => new Error('Something went wrong; please try again later.'));
    }

    /**
     * Fetches all completed levels for the current user.
     */
    getCompletedLevels(): Observable<Level[]> {
      return this.http.get<Level[]>(`${this.baseUrl}/completed`, {
        withCredentials: true
      });
    }

    /**
     * Marks a level as completed for the current user.
     */
    markLevelAsCompleted(levelId: number): Observable<void> {
      return this.http.post<void>(
        `${this.baseUrl}/${levelId}/complete`,
        {},
        { withCredentials: true }
      );
    }

    /**
     * Fetches user stats for completed levels.
     */
    getUserStats(): Observable<CompletedLevel[]> {
      return this.http.get<CompletedLevel[]>(`${this.baseUrl}/stats`, {
        withCredentials: true
      });
    }
}
