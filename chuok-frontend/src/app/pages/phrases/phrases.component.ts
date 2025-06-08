import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { PhraseService, Phrase } from '../../services/phrase.service';

/**
 * PhrasesComponent displays a grid of phrase cards and handles modal popup for viewing phrase details.
 * Loads phrases from the PhraseService on initialization.
 */
@Component({
  selector: 'app-phrases',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './phrases.component.html',
  styleUrl: './phrases.component.css'
})
export class PhrasesComponent implements OnInit {
  /** List of all phrases */
  phrases: Phrase[] = [];
  /** Index of the currently selected phrase for the modal, or null if none */
  selectedPhraseIndex: number | null = null;

  constructor(private phraseService: PhraseService) {}

  /**
   * OnInit lifecycle hook. Loads phrases from the service.
   */
  ngOnInit(): void {
    this.phraseService.getPhrases().subscribe({
      next: data => this.phrases = data,
      error: err => console.error('Error al cargar frases:', err)
    });
  }

  get reversedPhrases(): Phrase[] {
    return this.phrases.slice().reverse();
  }

  /**
   * Opens the modal for the selected phrase.
   */
  openPhrase(index: number) {
    this.selectedPhraseIndex = index;
  }

  /**
   * Closes the phrase modal.
   */
  closePhrase() {
    this.selectedPhraseIndex = null;
  }
}
