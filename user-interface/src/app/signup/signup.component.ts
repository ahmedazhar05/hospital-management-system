import { Component, Output, ViewChild } from '@angular/core';
import { BasePage } from '../app.component';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements BasePage {
  @Output()
  options: { text: string; href: string; }[] = [
    {
      text: 'Home',
      href: '/'
    },
    {
      text: 'Register',
      href: '/register'
    },
    {
      text: 'Get Info',
      href: '/info'
    }
  ];
  
  firstname="amar"
  lastname="kumar"
  
  @ViewChild('f') form: any;

  onSignup(){
    if(this.form.valid){
      console.log(this.form.value);
      // TODO: perform the necessary signup process with these form values
      this.form.reset();
    }
  }
}
