import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';

 /**
 * ProfileComponent displays the user profile page with tabbed navigation for Profile, Account, and Settings.
 * Manages the selected tab state.
 */
@Component({
  selector: 'app-profile',
  standalone: true,
  imports: [CommonModule],  
  templateUrl: './profile.component.html',
  styleUrl: './profile.component.css'
})
export class ProfileComponent {
  /** Currently selected tab in the sidebar */
  selectedTab: string = 'profile';
}
