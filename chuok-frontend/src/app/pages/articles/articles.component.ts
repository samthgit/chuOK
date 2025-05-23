import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';

@Component({
  selector: 'app-articles',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './articles.component.html',
  styleUrl: './articles.component.css'
})
export class ArticlesComponent {
  articles = [
    { title: 'Title 1', content: 'This is articles view. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum. Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur? But I must explain to you how all this mistaken idea of denouncing pleasure and praising pain was born and I will give you a complete account of the system, and expound the actual teachings of the great explorer of the truth, the master-builder of human happiness. No one rejects, dislikes, or avoids pleasure itself, because it is pleasure, but because those who do not know how to pursue pleasure rationally encounter consequences that are extremely painful. Nor again is there anyone who loves or pursues or desires to obtain pain of itself, because it is pain, but because occasionally circumstances occur in which toil and pain can procure him some great pleasure. To take a trivial example, which of us ever undertakes laborious physical exercise, except to obtain some advantage from it? But who has any right to find fault with a man who chooses to enjoy a pleasure that has no annoying consequences, or one who avoids a pain that produces no resultant pleasure?', author: 'Author 1', date: '2025-05-23' },
    { title: 'Title 2', content: 'Content 2', author: 'Author 2', date: '2025-05-22' },
    { title: 'Title 3', content: 'Content 3', author: 'Author 3', date: '2025-05-21' },
    { title: 'Title 4', content: 'Content 4', author: 'Author 4', date: '2025-05-20' },
    { title: 'Title 5', content: 'Content 5', author: 'Author 5', date: '2025-05-19' },
    { title: 'Title 6', content: 'Content 6', author: 'Author 6', date: '2025-05-18' },
    { title: 'Title 7', content: 'Content 7', author: 'Author 7', date: '2025-05-17' },
    { title: 'Title 8', content: 'Content 8', author: 'Author 8', date: '2025-05-16' },
    { title: 'Title 9', content: 'Content 9', author: 'Author 9', date: '2025-05-15' },
    { title: 'Title 10', content: 'Content 10', author: 'Author 10', date: '2025-05-14' },
    { title: 'Title 11', content: 'Content 11', author: 'Author 11', date: '2025-05-13' },
    { title: 'Title 12', content: 'Content 12', author: 'Author 12', date: '2025-05-12' },
  ];
  selectedArticleIndex: number | null = null;

  openArticle(index: number) {
    this.selectedArticleIndex = index;
  }

  closeArticle() {
    this.selectedArticleIndex = null;
  }
}
