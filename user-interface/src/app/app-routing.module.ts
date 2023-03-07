import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BookAppointmentComponent } from './book-appointment/book-appointment.component';
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';
import { PrescriptionComponent } from './prescription/prescription.component';
import { MainComponent } from './main/main.component';
import { AuthGuard } from './auth.guard';
import { DashboardComponent } from './dashboard/dashboard.component';
import { LogoutComponent } from './logout/logout.component';
import { VerifyComponent } from './verify/verify.component';
import { PrescriptionListComponent } from './prescription-list/prescription-list.component';
import { ReportsListComponent } from './reports-list/reports-list.component';

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
    canActivate: [AuthGuard],
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
        title: 'Health+ All Reports',
        path: 'reports',
        component: ReportsListComponent
      },
      {
        path: 'prescription',
        //component: PrescriptionComponent,
        children: [
          {
            title: 'Health+ Create Appointment Prescription',
            path: 'create/:id',
            component: PrescriptionComponent
          },
          {
            title: 'Health+ View Prescription',
            path: 'view/:id',
            component: PrescriptionComponent
          },
          {
            title: 'Health+ All Prescriptions',
            path: 'all',
            component: PrescriptionListComponent
          },
          /*
          {
            title: 'Health+ Create Prescription',
            path: 'create',
            component: PrescriptionComponent
          }
          */
        ]
      },
      {
        title: 'Health+ Verify Patient',
        path: 'verify',
        component: VerifyComponent,
      }
    ]
  },
  {
    title: 'Health+ Home',
    path: '',
    pathMatch: 'full',
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
