import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent {
  username = '';
  password = '';
  error = '';

  constructor(private router: Router) {}

  login(): void {
    // Simple authentication (in production, use proper auth service)
    if (this.username === 'admin' && this.password === 'admin') {
      localStorage.setItem('isAuthenticated', 'true');
      this.router.navigate(['/admin']);
    } else {
      this.error = 'Invalid credentials. Use admin/admin for demo.';
    }
  }
}

