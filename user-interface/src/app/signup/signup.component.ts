import { Component, Output, ViewChild } from '@angular/core';
import { BasePage } from '../app.component';
import { Carousel } from '../carousel/carousel.component';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements BasePage {
  carousel: Carousel[] = [
    {
      image: "https://png.pngtree.com/thumb_back/fh260/back_pic/02/50/63/71577e1cf59d802.jpg"
    },
    {
      image: "https://png.pngtree.com/thumb_back/fh260/back_pic/03/51/70/585791ffa147edc.jpg"
    }
  ];


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
  
  firstname = "Amar"
  lastname = "Kumar"
  
  @ViewChild('f') form: any;

  onSignup(){
    if(this.form.valid){
      console.log(this.form.value);
      // TODO: perform the necessary signup process with these form values
      this.form.reset();
    }
  }
}
