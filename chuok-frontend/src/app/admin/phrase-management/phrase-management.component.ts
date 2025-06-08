import { Component, OnInit } from '@angular/core';
import { Phrase, PhraseService } from '../../services/phrase.service';

@Component({
  selector: 'app-phrase-management',
  standalone: false,
  templateUrl: './phrase-management.component.html',
  styleUrl: './phrase-management.component.css'
})
export class PhraseManagementComponent implements OnInit {
    phrases: Phrase[] = [];
  selectedPhrase: Partial<Phrase> = {};
  isEditing = false;

  constructor(private phraseService: PhraseService) {}

  ngOnInit(): void {
    this.loadPhrases();
  }

  loadPhrases(): void {
    this.phraseService.getPhrases().subscribe(data => this.phrases = data);
  }

  createNew(): void {
    this.selectedPhrase = {};
    this.isEditing = true;
  }

  editPhrase(phrase: Phrase): void {
    this.selectedPhrase = { ...phrase };
    this.isEditing = true;
  }

  savePhrase(): void {
    if (this.selectedPhrase.id) {
      this.phraseService.updatePhrase(this.selectedPhrase.id, this.selectedPhrase).subscribe(() => {
        this.loadPhrases();
        this.isEditing = false;
      });
    } else {
      this.phraseService.createPhrase(this.selectedPhrase).subscribe(() => {
        this.loadPhrases();
        this.isEditing = false;
      });
    }
  }

  deletePhrase(id: number): void {
    if (confirm('Are you sure you want to delete this phrase?')) {
      this.phraseService.deletePhrase(id).subscribe(() => this.loadPhrases());
    }
  }

  cancelEdit(): void {
    this.isEditing = false;
    this.selectedPhrase = {};
  }
}
