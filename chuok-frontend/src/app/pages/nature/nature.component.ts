import { CommonModule } from '@angular/common';
import { RouterModule, Router } from '@angular/router';
import { Component, ElementRef, ViewChild } from '@angular/core';

@Component({
  selector: 'app-nature',
  standalone: true,
  imports: [CommonModule, RouterModule],
  templateUrl: './nature.component.html',
  styleUrl: './nature.component.css'
})
export class NatureComponent {
  levels = Array.from({ length: 20 }, (_, i) => i + 1);
  selectedLevelIndex: number | null = null;

  constructor(public router: Router) {}

  openLevel(index: number) {
    this.selectedLevelIndex = index;
  }

  closeLevel() {
    this.selectedLevelIndex = null;
  } 
}
