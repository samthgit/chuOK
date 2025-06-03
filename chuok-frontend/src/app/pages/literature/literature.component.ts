import { Component, OnInit } from '@angular/core';
import { LevelService, Level, CompletedLevel } from '../../services/level.service';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-literature',
  standalone: true,
  imports: [CommonModule, RouterModule],
  templateUrl: './literature.component.html',
  styleUrls: ['./literature.component.css']
})
export class LiteratureComponent implements OnInit {
  levels: Level[] = [];
  selectedLevelIndex: number | null = null;
  worldId = 1;
  completedLevels: number[] = [];
  selectedAnswerIndex: number | null = null;
  isAnswerCorrect: boolean | null = null;
  userStats: CompletedLevel[] = [];

  constructor(private levelService: LevelService) {}

  ngOnInit() {
    this.loadLevels();
    this.loadCompletedLevels();
    this.loadStats();
  }

  loadLevels() {
    this.levelService.getLevelsByWorldId(this.worldId).subscribe({
      next: (levels) => {
        console.log('Loaded levels:', levels);
        this.levels = levels;
      },
      error: (err) => {
        console.error('Error loading levels', err);
        alert(JSON.stringify(err.error));
      } 
    });
  }

  loadCompletedLevels() {
    this.levelService.getCompletedLevels().subscribe({
      next: (levels) => {
        this.completedLevels = levels.map(l => l.id);
      },
      error: (err) => console.error('Failed to load completed levels', err)
    });
  }

  openLevel(index: number) {
    this.selectedLevelIndex = index;
    this.selectedAnswerIndex = null;
    this.isAnswerCorrect = null;
  }

  closeLevel() {
    this.selectedLevelIndex = null;
  }

  checkAnswer(level: Level, selectedOptionIndex: number) {
    this.selectedAnswerIndex = selectedOptionIndex;
    this.isAnswerCorrect = selectedOptionIndex === level.correctIndex - 1; // Adjusting for 0-based index

    if (this.isAnswerCorrect) {
      this.levelService.markLevelAsCompleted(level.id).subscribe({
        next: () => {
          if (!this.completedLevels.includes(level.id)) {
            this.completedLevels.push(level.id);
          }
          // Optionally auto-close the level after a delay
          setTimeout(() => this.closeLevel(), 1000);
        },
        error: (err) => console.error('Failed to save progress', err)
      });
    } else {
      // Incorrect: optional logic
      setTimeout(() => {
        this.selectedAnswerIndex = null;
        this.isAnswerCorrect = null;
      }, 1000);
    }
  }

  isLevelCompleted(levelId: number): boolean {
    return this.completedLevels.includes(levelId);
  }

  loadStats() {
    this.levelService.getUserStats().subscribe({
      next: (stats) => {
        console.log('Stats:', stats);
        this.userStats = stats;
      },
      error: (err) => console.error('Failed to load stats', err)
    });
  }
}
