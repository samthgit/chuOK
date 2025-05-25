import { CommonModule } from '@angular/common';
import { RouterModule, Router } from '@angular/router';
import { Component } from '@angular/core';

@Component({
  selector: 'app-science',
  standalone: true,
  imports: [CommonModule, RouterModule],
  templateUrl: './science.component.html',
  styleUrl: './science.component.css'
})
export class ScienceComponent {
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
