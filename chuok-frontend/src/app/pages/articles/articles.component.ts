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
  articles: Article[] = [];
  selectedArticleIndex: number | null = null;

  constructor(private articleService: ArticleService) {}

  ngOnInit(): void {
    this.articleService.getArticles().subscribe({
      next: data => this.articles = data,
      error: err => console.error('Error al cargar artículos:', err)
    });
  }

  openArticle(index: number) {
    this.selectedArticleIndex = index;
  }

  closeArticle() {
    this.selectedArticleIndex = null;
  }
}
