import { Component, OnInit } from '@angular/core';
import { User, UserService, Role } from '../../services/user.service';

@Component({
  selector: 'app-user-management',
  standalone: false,
  templateUrl: './user-management.component.html',
  styleUrl: './user-management.component.css'
})
export class UserManagementComponent implements OnInit {
  users: User[] = [];
  roles: Role[] = [
    { id: 1, name: 'USER' },
    { id: 2, name: 'ADMIN' }
  ];

  constructor(private userService: UserService) {}

  ngOnInit(): void {
    this.loadUsers();
  }

  loadUsers(): void {
    this.userService.getUsers().subscribe(data => this.users = data);
  }

  changeRole(user: User, newRoleId: number): void {
    this.userService.updateUserRole(user.id, newRoleId).subscribe(updated => {
      user.role = updated.role;
    });
  }

  changeRoleFromEvent(user: User, event: Event): void {
    const selectElement = event.target as HTMLSelectElement;
    const selectedRoleId = Number(selectElement.value);
    this.changeRole(user, selectedRoleId);
  }
}
