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
  userType: string = "patient";

  links: {
    name: string;
    href: string;
  }[] = [];

  constructor(private authService: AuthService, private router: Router, public route: ActivatedRoute){ }

  ngOnInit(): void {
    const isLoggedIn: boolean = true;// this.authService.isLoggedIn();

    if(isLoggedIn){
      // this.userType = this.authService.getUserType();
      // this.userId = this.authService.getUserId();
      switch(this.userType){
        case 'patient': 
          this.links = [
            {
              name: 'Book Appointment',
              href: 'book-appointment'
            },
            {
              name: 'View Prescriptions',
              href: 'prescription'
            }
          ]
          //this.router.navigate(['patient'], { relativeTo: this.route });
          break;
        case 'doctor': 
          this.links = [
            {
              name: 'Create Prescription',
              href: 'prescription'
            }
          ]
          //this.router.navigate(['doctor'], { relativeTo: this.route });
          break;
        case 'admin': 
          this.links = [
            {
              name: 'Add schemes',
              href: 'scheme'
            },
            {
              name: 'Book Hospital Bed',
              href: 'book-bed'
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
