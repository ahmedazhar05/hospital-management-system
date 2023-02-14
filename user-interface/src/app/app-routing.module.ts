import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';

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
