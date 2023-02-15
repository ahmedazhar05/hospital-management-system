import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { GovSchemeComponent } from './gov-scheme/gov-scheme.component';
import { LoginComponent } from './login/login.component';

const routes: Routes = [
  {
    title: 'Health+ Login',
    path: 'login',
    component: LoginComponent
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
