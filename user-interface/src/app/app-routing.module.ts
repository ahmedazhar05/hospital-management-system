import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BookAppointmentComponent } from './book-appointment/book-appointment.component';
import { SchemeComponent } from './scheme/scheme.component';
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';
import { PrescriptionComponent } from './prescription/prescription.component';

const routes: Routes = [
  {
    title: 'Health+ Login',
    path: 'login',
    component: LoginComponent
  },
  {
    title: 'Health+ Book Appointment',
    path: 'book-appointment',
    component: BookAppointmentComponent
  },
  {
    title: 'Health+ Signup',
    path: 'register',
    component: SignupComponent
  },
  {
    title: 'Health+ Schemes',
    path: 'scheme',
    component: SchemeComponent
  },
  {
    title: 'Health+ Prescription',
    path: 'prescription',
    component: PrescriptionComponent
  },
  {
    title: 'Health+ Home',
    path: '',
    redirectTo: '/login',
    pathMatch: 'full'
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
