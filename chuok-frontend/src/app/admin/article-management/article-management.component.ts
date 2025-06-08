import { Component, OnInit } from '@angular/core';
import { Article, ArticleService } from '../../services/article.service';

@Component({
  selector: 'app-article-management',
  standalone: false,
  templateUrl: './article-management.component.html',
  styleUrl: './article-management.component.css'
})
export class ArticleManagementComponent implements OnInit {
  articles: Article[] = [];
  selectedArticle: Partial<Article> = {};
  isEditing: boolean = false;

  constructor(private articleService: ArticleService) {}

  ngOnInit() {
    this.loadArticles();
  }

  loadArticles() {
    this.articleService.getArticles().subscribe(data => this.articles = data);
  }

  editArticle(article: Article) {
    this.selectedArticle = { ...article };
    this.isEditing = true;
  }

  createNew() {
    this.selectedArticle = {};
    this.isEditing = true;
  }

  saveArticle() {
    if (this.selectedArticle.id) {
      this.articleService.updateArticle(this.selectedArticle.id, this.selectedArticle).subscribe(() => {
        this.loadArticles();
        this.isEditing = false;
      });
    } else {
      this.articleService.createArticle(this.selectedArticle).subscribe(() => {
        this.loadArticles();
        this.isEditing = false;
      });
    }
  }

  deleteArticle(id: number) {
    if (confirm('Are you sure you want to delete this article?')) {
      this.articleService.deleteArticle(id).subscribe(() => this.loadArticles());
    }
  }

  cancelEdit() {
    this.isEditing = false;
    this.selectedArticle = {};
  }
}
