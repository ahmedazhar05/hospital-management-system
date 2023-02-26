import { Component, Output } from '@angular/core';
import { BasePage } from '../app.component';

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html'
})
export class MainComponent implements BasePage {
  @Output()
  options: {
    text: string;
    href: string;
  }[] = [
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

}
