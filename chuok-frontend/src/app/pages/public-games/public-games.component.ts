import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-public-games',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './public-games.component.html',
  styleUrl: './public-games.component.css'
})
export class PublicGamesComponent implements OnInit {
  games = [
    { id: 1, title: 'Game 1', content: 'Content for Game 1...' },
    { id: 2, title: 'Game 2', content: 'Content for Game 2...' },
    { id: 3, title: 'Game 3', content: 'Content for Game 3...' },
    { id: 4, title: 'Game 4', content: 'Content for Game 4...' },
    { id: 5, title: 'Game 5', content: 'Content for Game 5...' }
  ];

  currentGameId: number = 1;

  constructor(private route: ActivatedRoute) {}

  ngOnInit(): void {
    this.route.paramMap.subscribe(params => {
      const id = Number(params.get('id'));
      this.currentGameId = id;
    });
  }
} 
