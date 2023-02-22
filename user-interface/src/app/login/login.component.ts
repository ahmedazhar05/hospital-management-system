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
      text: 'Get Info',
      href: '/info'
    }
  ];

  @ViewChild('f') form: any;
  
  onLogin(){
    if(this.form.valid){
      this.authService.login(this.form.value.login, this.form.value.password).subscribe(
        () => {
          this.router.navigateByUrl('/dashboard');
        }
      );
      // console.log(this.form.value);
      // TODO: perform the necessary login process with these form values
      this.form.reset();
    }
  }
}