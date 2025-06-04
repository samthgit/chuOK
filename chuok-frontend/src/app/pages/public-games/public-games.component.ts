import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { AuthService } from '../../services/auth.service';

@Component({
  selector: 'app-public-games',
  standalone: true,
  imports: [CommonModule, RouterModule],
  templateUrl: './public-games.component.html',
  styleUrl: './public-games.component.css'
})
export class PublicGamesComponent implements OnInit {
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

  currentGameId: number = 1;
  selectedAnswer: string | null = null;
  answerStatus: { [key: string]: 'correct' | 'incorrect' | null } = {};
  gameFinished: boolean = false;

  constructor(private route: ActivatedRoute, private authService: AuthService) {}

  ngOnInit(): void {
    this.route.paramMap.subscribe(params => {
      const id = Number(params.get('id'));
      this.currentGameId = id;
    });
  }

selectAnswer(answer: string) {
  const currentGame = this.games.find(game => game.id === this.currentGameId);
  if (!currentGame) return;

  // Evitar múltiples clics si ya respondió correctamente
  if (this.selectedAnswer && this.answerStatus[this.selectedAnswer] === 'correct') {
    return;
  }

  if (answer === currentGame.correctAnswer) {
    this.answerStatus = { [answer]: 'correct' };
    this.selectedAnswer = answer;

    // Esperar antes de avanzar a la siguiente pregunta
    setTimeout(() => {
      this.answerStatus = {};
      this.selectedAnswer = null;

      // Avanzar a la siguiente pregunta si existe
      const currentIndex = this.games.findIndex(game => game.id === this.currentGameId);
      if (currentIndex < this.games.length - 1) {
        this.currentGameId = this.games[currentIndex + 1].id;
      } else {
        this.gameFinished = true;
      }
    }, 2500); // 2.5 segundos

  } else {
    // Mostrar rojo temporalmente y permitir seguir intentando
    this.answerStatus = { [answer]: 'incorrect' };
    this.selectedAnswer = answer;

    setTimeout(() => {
      this.answerStatus = {};
      this.selectedAnswer = null;
    }, 1500); // 1.5 segundos
  }
}

get isLoggedIn(): boolean {
  return this.authService.isLoggedIn();
}

} 
