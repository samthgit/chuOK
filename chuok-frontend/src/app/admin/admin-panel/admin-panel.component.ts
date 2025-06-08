import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';

@Component({
  selector: 'app-admin-panel',
  standalone: false,
  templateUrl: './admin-panel.component.html',
  styleUrl: './admin-panel.component.css'
})
export class AdminPanelComponent {
  article = {
    title: '',
    content: ''
  };

  constructor(private http: HttpClient) {}

  onSubmit() {
    const url = 'http://localhost:8080/api/articles';
    
    this.http.post(url, this.article).subscribe({
      next: () => {
        alert('Article created!');
        this.article = { title: '', content: '' };
      },
      error: () => alert('Failed to create article')
    });
  }
}
