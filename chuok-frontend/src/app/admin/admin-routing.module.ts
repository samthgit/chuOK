import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminLayoutComponent } from './admin-layout/admin-layout.component';
import { ArticleManagementComponent } from './article-management/article-management.component';
import { PhraseManagementComponent } from './phrase-management/phrase-management.component';
import { UserManagementComponent } from './user-management/user-management.component';
import { RoleGuard } from '../guards/role.guard';

const routes: Routes = [
  {
    path: '',
    component: AdminLayoutComponent,
    canActivate: [RoleGuard],
    children: [
      { path: 'articles', component: ArticleManagementComponent },
      { path: 'phrases', component: PhraseManagementComponent },
      { path: 'users', component: UserManagementComponent },
      { path: '', redirectTo: 'articles', pathMatch: 'full' }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AdminRoutingModule {}
