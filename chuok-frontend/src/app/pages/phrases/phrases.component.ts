import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { PhraseService, Phrase } from '../../services/phrase.service';
@Component({
  selector: 'app-phrases',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './phrases.component.html',
  styleUrl: './phrases.component.css'
})
export class PhrasesComponent implements OnInit {
  phrases: Phrase[] = [];
  selectedPhraseIndex: number | null = null;

  constructor(private phraseService: PhraseService) {}

  ngOnInit(): void {
    this.phraseService.getPhrases().subscribe({
      next: data => this.phrases = data,
      error: err => console.error('Error al cargar frases:', err)
    });
  }

  openPhrase(index: number) {
    this.selectedPhraseIndex = index;
  }

  closePhrase() {
    this.selectedPhraseIndex = null;
  }
}
