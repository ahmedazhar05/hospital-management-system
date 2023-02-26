import { Component, Output, ViewChild } from '@angular/core';
import { Router } from '@angular/router';
import { BasePage } from '../app.component';
import { Carousel } from '../carousel/carousel.component';
import { ServerService } from '../server.service';
import { ToastComponent } from '../toast/toast.component';

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
      text: 'Login',
      href: '/login'
    },
    {
      text: 'Register',
      href: '/register'
    }
  ];
  
  @ViewChild('f') form: any;

  constructor(private server: ServerService, private router: Router) { }

  @ViewChild(ToastComponent)
  private notify!: ToastComponent;

  onSignup(){
    if(this.form.valid){

      this.server.post('patients', this.form.value)
      .subscribe((d: any) => {
        if(d == 'Saved'){
          this.notify.showToast("Successfully registered", "success", 5000);
          setTimeout(() => {
            this.router.navigate(['/']);
          }, 5000);
        }
      });
      
      this.form.reset();
    }
  }
}
