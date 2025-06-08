import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

export interface Article {
  id: number;
  title: string;
  content: string;
  author: string;
  date: string;
}

/**
 * ArticleService provides methods to fetch articles from the backend API.
 * Includes methods to get all articles and fetch a single article by ID.
 */
@Injectable({ 
  providedIn: 'root' 
})
export class ArticleService {
  /** Base URL for the articles API */
  private apiUrl = 'http://localhost:8080/api/articles';

  constructor(private http: HttpClient) {}

  /**
   * Fetches all articles from the backend.
   */
  getArticles(): Observable<Article[]> {
    return this.http.get<Article[]>(this.apiUrl);
  }

  /**
   * Fetches a single article by its ID.
   */
  getArticleById(id: number): Observable<Article> {
    return this.http.get<Article>(`${this.apiUrl}/${id}`);
  }
}
