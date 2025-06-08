import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { AuthService } from '../../services/auth.service';

// Component for displaying a public quiz game with multiple questions and answers.
// Handles answer selection, feedback, and navigation between questions.
@Component({
  selector: 'app-public-games',
  standalone: true,
  imports: [CommonModule, RouterModule],
  templateUrl: './public-games.component.html',
  styleUrl: './public-games.component.css'
})
export class PublicGamesComponent implements OnInit {
  // List of quiz games/questions to display
  games = [
    {
      id: 1,
      title: 'Game 1',
      question: 'Who wrote "To Kill a Mockingbird"?',
      answer1: 'Harper Lee',
      answer2: 'Mark Twain',
      answer3: 'F. Scott Fitzgerald',
      answer4: 'Ernest Hemingway',
      correctAnswer: 'Harper Lee'
    },
    {
      id: 2,
      title: 'Game 2',
      question: 'In George Orwell\'s "Animal Farm", what kind of animal is Boxer?',
      answer1: 'Horse',
      answer2: 'Pig',
      answer3: 'Goat',
      answer4: 'Dog',
      correctAnswer: 'Horse'
    },
    {
      id: 3,
      title: 'Game 3',
      question: 'What planet is known as the Red Planet?',
      answer1: 'Mars',
      answer2: 'Venus',
      answer3: 'Jupiter',
      answer4: 'Saturn'
    },
    {
      id: 4,
      title: 'Game 4',
      question: 'What gas do plants absorb from the atmosphere?',
      answer1: 'Carbon dioxide',
      answer2: 'Oxygen',
      answer3: 'Nitrogen',
      answer4: 'Hydrogen',
      correctAnswer: 'Carbon dioxide'
    },
    {
      id: 5,
      title: 'Game 5',
      question: 'What is the largest land animal?',
      answer1: 'African elephant',
      answer2: 'Giraffe',
      answer3: 'Grizzly bear',
      answer4: 'White rhinoceros',
      correctAnswer: 'African elephant'
    }
  ];

  // The ID of the currently displayed game/question
  currentGameId: number = 1;
  // The answer currently selected by the user
  selectedAnswer: string | null = null;
  // Tracks the status (correct/incorrect) of each answer
  answerStatus: { [key: string]: 'correct' | 'incorrect' | null } = {};
  // Whether the game has finished
  gameFinished: boolean = false;

  /**
   * Injects dependencies for route handling and authentication status.
   */
  constructor(private route: ActivatedRoute, private authService: AuthService) {}

  /**
   * On component initialization, subscribes to route changes and updates the current game.
   */
  ngOnInit(): void {
    this.route.paramMap.subscribe(params => {
      const id = Number(params.get('id'));
      this.currentGameId = id;
    });
  }

  /**
   * Handles answer selection, provides feedback, and advances to the next question or ends the game.
   * @param answer The answer selected by the user
   */
  selectAnswer(answer: string) {
    const currentGame = this.games.find(game => game.id === this.currentGameId);
    if (!currentGame) return;

    // Avoid multiple clicks if answered correctly
    if (this.selectedAnswer && this.answerStatus[this.selectedAnswer] === 'correct') {
      return;
    }

    if (answer === currentGame.correctAnswer) {
      this.answerStatus = { [answer]: 'correct' };
      this.selectedAnswer = answer;

      // Wait before getting to the next question
      setTimeout(() => {
        this.answerStatus = {};
        this.selectedAnswer = null;

        // Go to next question if exists
        const currentIndex = this.games.findIndex(game => game.id === this.currentGameId);
        if (currentIndex < this.games.length - 1) {
          this.currentGameId = this.games[currentIndex + 1].id;
        } else {
          this.gameFinished = true;
        }
      }, 2500);

    } else {
      // Display answer red temporarily and then let user keep trying
      this.answerStatus = { [answer]: 'incorrect' };
      this.selectedAnswer = answer;

      setTimeout(() => {
        this.answerStatus = {};
        this.selectedAnswer = null;
      }, 1500);
    }
  }

  /**
   * Returns true if the user is logged in, false otherwise.
   */
  get isLoggedIn(): boolean {
    return this.authService.isLoggedIn();
  }

}
