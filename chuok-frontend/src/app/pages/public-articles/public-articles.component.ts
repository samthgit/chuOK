import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-public-articles',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './public-articles.component.html',
  styleUrl: './public-articles.component.css'
})
export class PublicArticlesComponent implements OnInit {
    articles = [
    { id: 1, title: 'Article 1', content: 'Content for article 1...' },
    { id: 2, title: 'Article 2', content: 'Content for article 2...' },
    { id: 3, title: 'Article 3', content: 'Content for article 3...' },
    { id: 4, title: 'Article 4', content: 'Content for article 4...' },
    { id: 5, title: 'Article 5', content: 'Content for article 5...' }
  ];

  currentArticleId: number = 1;

  constructor(private route: ActivatedRoute) {}

  ngOnInit(): void {
    this.route.paramMap.subscribe(params => {
      const id = Number(params.get('id'));
      this.currentArticleId = id;
    });
  }
}
