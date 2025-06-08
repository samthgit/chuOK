import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';


import { AdminRoutingModule } from './admin-routing.module';
import { AdminLayoutComponent } from './admin-layout/admin-layout.component';
import { ArticleManagementComponent } from './article-management/article-management.component';
import { PhraseManagementComponent } from './phrase-management/phrase-management.component';
import { UserManagementComponent } from './user-management/user-management.component';

/**
 * AdminModule
 *
 * This module bundles all admin-related components and features.
 * - Declares admin layout and management components (articles, phrases, users).
 * - Imports routing, forms, and common Angular modules for admin functionality.
 */
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
