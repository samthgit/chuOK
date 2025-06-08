import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

export interface Phrase {
  id: number;
  title: string;
  content: string;
  date: string;
}

/**
 * PhraseService provides methods to fetch phrases from the backend API.
 * Includes methods to get all phrases and fetch a single phrase by ID.
 */
@Injectable({ 
  providedIn: 'root' 
})
export class PhraseService {
  /** Base URL for the phrases API */
  private apiUrl = 'http://localhost:8080/api/phrases';

  constructor(private http: HttpClient) {}

  /**
   * Fetches all phrases from the backend.
   */
  getPhrases(): Observable<Phrase[]> {
    return this.http.get<Phrase[]>(this.apiUrl);
  }

  /**
   * Fetches a single phrase by its ID.
   */
  getPhraseById(id: number): Observable<Phrase> {
    return this.http.get<Phrase>(`${this.apiUrl}/${id}`);
  }

  /**
   * Creates a new phrase.
   */
  createPhrase(phrase: Partial<Phrase>): Observable<Phrase> {
    return this.http.post<Phrase>(this.apiUrl, phrase);
  }

  /**
   * Updates an existing phrase by ID.
   */
  updatePhrase(id: number, phrase: Partial<Phrase>): Observable<Phrase> {
    return this.http.put<Phrase>(`${this.apiUrl}/${id}`, phrase);
  }

  /**
   * Deletes a phrase by ID.
   */
  deletePhrase(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}
