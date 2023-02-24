import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BookAppointmentComponent } from './book-appointment/book-appointment.component';
import { SchemeComponent } from './scheme/scheme.component';
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';
import { PrescriptionComponent } from './prescription/prescription.component';
import { MainComponent } from './main/main.component';
import { AuthGuard } from './auth.guard';
import { DashboardComponent } from './dashboard/dashboard.component';
import { LogoutComponent } from './logout/logout.component';

const routes: Routes = [
  {
    title: 'Health+ Login',
    path: 'login',
    component: LoginComponent
  },
  {
    title: 'Health+ Signup',
    path: 'register',
    component: SignupComponent
  },
  {
    title: 'Health+ Dashboard',
    path: 'dashboard',
    // canActivate: [AuthGuard],
    children: [
      {
        title: 'Health+ Dashboard',
        path: '',
        pathMatch: 'full',
        component: DashboardComponent
      },
      {
        title: 'Health+ Book Appointment',
        path: 'book-appointment',
        component: BookAppointmentComponent
      },
      {
        title: 'Health+ Prescription',
        path: 'prescription',
        component: PrescriptionComponent
      },
      {
        title: 'Health+ Schemes',
        path: 'scheme',
        component: SchemeComponent,
      }
    ]
  },
  {
    title: 'Health+ Home',
    path: '',
    component: MainComponent
  },
  {
    title: 'Health+ Logout',
    path: 'logout',
    component: LogoutComponent
  },
  /*{
    path: '**',
    redirectTo: '/',
    pathMatch: 'full'
  }*/
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
