import { Component, Output, ViewChild } from '@angular/core';
import { BasePage } from '../app.component';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html'
})
export class LoginComponent implements BasePage {
  
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
      console.log(this.form.value);
      // TODO: perform the necessary login process with these form values
      this.form.reset();
    }
  }
}