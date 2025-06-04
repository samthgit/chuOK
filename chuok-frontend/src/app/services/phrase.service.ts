import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

export interface Phrase {
  id: number;
  title: string;
  content: string;
  date: string;
}

@Injectable({ 
  providedIn: 'root' 
})
export class PhraseService {
  private apiUrl = 'http://localhost:8080/api/phrases';

  constructor(private http: HttpClient) {}

  getPhrases(): Observable<Phrase[]> {
    return this.http.get<Phrase[]>(this.apiUrl);
  }

  getPhraseById(id: number): Observable<Phrase> {
    return this.http.get<Phrase>(`${this.apiUrl}/${id}`);
  }
}
