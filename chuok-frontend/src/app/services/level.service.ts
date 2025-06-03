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

@Injectable({
    providedIn: 'root'
})
export class LevelService {
    private baseUrl = 'http://localhost:8080/api/levels';

    constructor(private http: HttpClient) {}

    getLevelsByWorldId(worldId: number): Observable<Level[]> {
      return this.http.get<Level[]>(`${this.baseUrl}`).pipe(
        map(levels => levels.filter(level => level.world.id === worldId)),
        catchError(this.handleError)
      );
    }

    private handleError(error: HttpErrorResponse) {
      console.error('An error occurred:', error.error);
      return throwError(() => new Error('Something went wrong; please try again later.'));
    }

    getCompletedLevels(): Observable<Level[]> {
      return this.http.get<Level[]>(`${this.baseUrl}/completed`, {
        withCredentials: true
      });
    }

    markLevelAsCompleted(levelId: number): Observable<void> {
      return this.http.post<void>(
        `${this.baseUrl}/${levelId}/complete`,
        {},
        { withCredentials: true }
      );
    }
}
