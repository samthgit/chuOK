import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';


import { AdminRoutingModule } from './admin-routing.module';
import { AdminLayoutComponent } from './admin-layout/admin-layout.component';
import { ArticleManagementComponent } from './article-management/article-management.component';
import { PhraseManagementComponent } from './phrase-management/phrase-management.component';
import { UserManagementComponent } from './user-management/user-management.component';

@NgModule({
  declarations: [
    AdminLayoutComponent,
    ArticleManagementComponent,
    PhraseManagementComponent,
    UserManagementComponent
  ],
  imports: [
    CommonModule,
    RouterModule,
    AdminRoutingModule,
    FormsModule
  ]
})
export class AdminModule {}
