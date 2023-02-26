import { Component, Output, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { BasePage } from '../app.component';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html'
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

  userId: number = 0;
  userType: string = "";

  links: {
    name: string;
    href: string;
  }[] = [];

  constructor(private authService: AuthService, private router: Router, public route: ActivatedRoute){ }

  ngOnInit(): void {
    this.userId = this.authService.getUserId();
    this.userType = this.authService.getUserType();

    const isLoggedIn: boolean = this.authService.isLoggedIn();

    if(isLoggedIn){
      switch(this.userType){
        case 'patient': 
          this.links = [
            {
              name: 'Book an Appointment',
              href: 'book-appointment'
            },
            {
              name: 'View All Prescriptions',
              href: 'prescription/all'
            },
            {
              name: 'View All Reports',
              href: 'reports'
            }
          ]
          //this.router.navigate(['patient'], { relativeTo: this.route });
          break;
        case 'doctor': 
          this.links = []
          //this.router.navigate(['doctor'], { relativeTo: this.route });
          break;
        case 'admin': 
          this.links = [
            {
              name: 'Verify Patient',
              href: 'verify'
            }
          ]
          //this.router.navigate(['admin'], { relativeTo: this.route });
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
