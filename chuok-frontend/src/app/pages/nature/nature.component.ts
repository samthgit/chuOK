import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { Level, LevelService } from '../../services/level.service';

/**
 * NatureComponent displays the adventure nature levels and handles user interaction.
 * Loads levels, tracks completed levels, and manages modal popup for answering questions.
 */
@Component({
  selector: 'app-nature',
  standalone: true,
  imports: [CommonModule, RouterModule],
  templateUrl: './nature.component.html',
  styleUrl: './nature.component.css'
})
export class NatureComponent implements OnInit {
  /** List of all nature levels */
  levels: Level[] = [];
  /** Index of the currently selected level for the modal, or null if none */
  selectedLevelIndex: number | null = null;
  /** World ID for nature (used to fetch levels) */
  worldId = 3;
  /** Array of completed level IDs */
  completedLevels: number[] = [];
  /** Index of the selected answer in the modal, or null if none */
  selectedAnswerIndex: number | null = null;
  /** Whether the selected answer is correct (true/false), or null if unanswered */
  isAnswerCorrect: boolean | null = null;

  constructor(private levelService: LevelService) {}

  /**
   * OnInit lifecycle hook. Loads levels and completed levels.
   */
  ngOnInit() {
    this.loadLevels();
    this.loadCompletedLevels();
  }

  /**
   * Loads all levels for the current world from the service.
   */
  loadLevels() {
    this.levelService.getLevelsByWorldId(this.worldId).subscribe({
      next: (levels) => this.levels = levels,
      error: (err) => {
        console.error('Error loading levels', err);
        alert(JSON.stringify(err.error));
      } 
    });
  }

  /**
   * Loads the IDs of completed levels for the user.
   */
  loadCompletedLevels() {
    this.levelService.getCompletedLevels().subscribe({
      next: (levels) => {
        this.completedLevels = levels.map(l => l.id);
      },
      error: (err) => console.error('Failed to load completed levels', err)
    });
  }

  /**
   * Opens the modal for the selected level.
   */
  openLevel(index: number) {
    this.selectedLevelIndex = index;
    this.selectedAnswerIndex = null;
    this.isAnswerCorrect = null;
  }

  /**
   * Closes the level modal.
   */
  closeLevel() {
    this.selectedLevelIndex = null;
  }

  /**
   * Checks the selected answer for the current level.
   * If correct, marks the level as completed and closes the modal after a delay.
   * If incorrect, resets the answer state after a delay.
   */
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

  /**
   * Returns true if the given level ID is completed by the user.
   */
  isLevelCompleted(levelId: number): boolean {
    return this.completedLevels.includes(levelId);
  }
}
