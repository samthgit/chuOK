import { CommonModule } from '@angular/common';
import { Component, ElementRef, ViewChild } from '@angular/core';

@Component({
  selector: 'app-literature',
  standalone: true,
  imports: [CommonModule], // Add necessary imports if needed
  templateUrl: './literature.component.html',
  styleUrls: ['./literature.component.css']
})
export class LiteratureComponent {
  isDragging = false;
  startY = 0; // Changed from startX to startY
  scrollTop = 0; // Changed from scrollLeft to scrollTop

  @ViewChild('scrollWrapper') scrollWrapper!: ElementRef<HTMLElement>;

  levels = Array.from({ length: 20 }, (_, i) => i + 1);

  onMouseDown(event: MouseEvent): void {
    this.isDragging = true;
    const rect = this.scrollWrapper.nativeElement.getBoundingClientRect();
    this.startY = event.clientY - rect.top; // Track Y position instead of X
    this.scrollTop = this.scrollWrapper.nativeElement.scrollTop; // Use scrollTop instead of scrollLeft
    this.scrollWrapper.nativeElement.classList.add('dragging');
    event.preventDefault();
  }

  onMouseMove(event: MouseEvent): void {
    if (!this.isDragging) return;

    const rect = this.scrollWrapper.nativeElement.getBoundingClientRect();
    const y = event.clientY - rect.top; // Track Y movement
    const walk = (y - this.startY) * 1.5; // Scroll vertically
    this.scrollWrapper.nativeElement.scrollTop = this.scrollTop - walk; // Update scrollTop
  }

  onMouseUp(): void {
    if (!this.isDragging) return;
    this.isDragging = false;
    this.scrollWrapper.nativeElement.classList.remove('dragging');
  }

  // Optional: Touch support for mobile
  onTouchStart(event: TouchEvent): void {
    this.isDragging = true;
    const rect = this.scrollWrapper.nativeElement.getBoundingClientRect();
    this.startY = event.touches[0].clientY - rect.top;
    this.scrollTop = this.scrollWrapper.nativeElement.scrollTop;
    this.scrollWrapper.nativeElement.classList.add('dragging');
    event.preventDefault();
  }

  onTouchMove(event: TouchEvent): void {
    if (!this.isDragging) return;
    const rect = this.scrollWrapper.nativeElement.getBoundingClientRect();
    const y = event.touches[0].clientY - rect.top;
    const walk = (y - this.startY) * 1.5;
    this.scrollWrapper.nativeElement.scrollTop = this.scrollTop - walk;
    event.preventDefault();
  }

  onTouchEnd(): void {
    this.isDragging = false;
    this.scrollWrapper.nativeElement.classList.remove('dragging');
  }
}