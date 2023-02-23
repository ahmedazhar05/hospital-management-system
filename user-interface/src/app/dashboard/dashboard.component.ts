import { Component, Output, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { BasePage } from '../app.component';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
})
export class DashboardComponent implements BasePage, OnInit {
  @Output()
  options: { text: string; href: string; }[] = [
    {
      text: "Dashboard",
      href: "/dashboard"
    },
    {
      text: "Logout",
      href: "/logout"
    }
  ];

  constructor(private authService: AuthService, private router: Router){ }

  ngOnInit(): void {
    const isLoggedIn: boolean = this.authService.isLoggedIn();

    if(isLoggedIn){
      const userType: string = this.authService.getUserType();

      switch(userType){
        case 'PATIENT': 
          this.router.navigate(['/dashboard', '/patient']);
          break;
        case 'DOCTOR':  
          this.router.navigate(['/dashboard', '/doctor']);
          break;
        case 'ADMIN':   
          this.router.navigate(['/dashboard', '/admin']);
          break;
        default: 
          this.authService.logout();
          this.router.navigate(['/']);
      }
    } else {
      this.router.navigate(['/']);
    }
  }
}
