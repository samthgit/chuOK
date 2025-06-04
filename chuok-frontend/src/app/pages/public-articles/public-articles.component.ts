import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { AuthService } from '../../services/auth.service';

@Component({
  selector: 'app-public-articles',
  standalone: true,
  imports: [CommonModule, RouterModule],
  templateUrl: './public-articles.component.html',
  styleUrl: './public-articles.component.css'
})
export class PublicArticlesComponent implements OnInit {
    articles = [
    { id: 1, title: 'The Power of Morning Rituals', content: 'Starting your day with intention can transform your mindset. Whether it\'s through meditation, journaling, or a simple cup of tea, morning rituals ground us in the present and prepare us for what\'s ahead. Studies show that consistent routines reduce anxiety and increase productivity. A 10-minute practice each day can lead to long-term benefits. Start small, stay consistent, and observe how your mornings shift your entire day.' },
    { id: 2, title: 'Mindfulness in Everyday Life', content: 'Mindfulness isn\'t just for yoga or meditation sessions. It\'s about being fully present in whatever you\'re doing—whether washing dishes or walking to work. Practicing awareness throughout your day enhances your emotional regulation and decreases stress. Try setting a reminder to pause and take three deep breaths. With repetition, mindfulness becomes second nature and colors your daily experience with calm and clarity.' },
    { id: 3, title: 'How to Build Better Habits', content: 'Habits are the compound interest of self-improvement. Start by identifying small changes you can sustain over time. Use triggers to anchor your new habits, like brushing your teeth right after waking. Track your progress and celebrate small wins. According to behavioral science, consistency beats intensity. Build systems, not goals, and let identity-based habits—\'I\'m a reader\' vs. \'I want to read\'—shape your future.' },
    { id: 4, title: 'Digital Minimalism for a Focused Mind', content: 'Technology is a tool, not a tether. Digital minimalism means using tech intentionally to support your values. Try setting screen time boundaries, deleting non-essential apps, or scheduling phone-free hours. Reclaim your attention by focusing on depth over distraction. You\'ll be amazed at how much clearer your thoughts become when you give your brain space to rest and your eyes a break from the glow.' },
    { id: 5, title: 'Journaling as a Tool for Growth', content: 'Writing regularly helps clarify thoughts, process emotions, and track personal growth. Start by journaling for just 5 minutes a day. You can use prompts like \'What am I grateful for today?\' or \'What challenge did I face and how did I handle it?\'. Journaling builds self-awareness and resilience, acting as a mirror to your inner world and a map toward your best self.' }
  ];

  currentArticleId: number = 1;

  constructor(private route: ActivatedRoute, private authService: AuthService) {}

  ngOnInit(): void {
    this.route.paramMap.subscribe(params => {
      const id = Number(params.get('id'));
      this.currentArticleId = id;
    });
  }

  get isLoggedIn(): boolean {
    return this.authService.isLoggedIn();
  }
}
