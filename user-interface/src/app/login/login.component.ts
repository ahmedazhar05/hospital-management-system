import { Component, Output, ViewChild } from '@angular/core';
import { Router } from '@angular/router';
import { BasePage } from '../app.component';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html'
})
export class LoginComponent implements BasePage {

  constructor(private authService: AuthService, private router: Router){ }
  
  @Output()
  options = [
    {
      text: 'Home',
      href: '/'
    },
    {
      text: 'Login',
      href: '/login'
    },
    {
      text: 'Register',
      href: '/register'
    }
  ];

  @ViewChild('f') form: any;
  
  onLogin(){
    if(this.form.valid){
      /*
      this.authService.login(this.form.value.login, this.form.value.password)
      .subscribe(() => {
        // this.router.navigate(['/prescription'])
        this.router.navigateByUrl('/dashboard');
      });
      */
      this.router.navigateByUrl('/dashboard');
      // console.log(this.form.value);
      // TODO: perform the necessary login process with these form values
      this.form.reset();
    }
  }
}