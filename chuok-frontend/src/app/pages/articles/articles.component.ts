// ArticlesComponent: Displays a grid of articles and a modal popup for details
import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { ArticleService, Article } from '../../services/article.service';

@Component({
  selector: 'app-articles',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './articles.component.html',
  styleUrl: './articles.component.css'
})
export class ArticlesComponent implements OnInit {
  // List of articles loaded from the service
  articles: Article[] = [];
  // Index of the currently selected article for the modal, or null if none
  selectedArticleIndex: number | null = null;

  // Inject the ArticleService for fetching articles
  constructor(private articleService: ArticleService) {}

  // Load articles on component initialization
  ngOnInit(): void {
    this.articleService.getArticles().subscribe({
      next: data => this.articles = data,
      error: err => console.error('Error al cargar artículos:', err)
    });
  }

  // Open the modal for the selected article
  openArticle(index: number) {
    this.selectedArticleIndex = index;
  }

  // Close the article modal
  closeArticle() {
    this.selectedArticleIndex = null;
  }
}
