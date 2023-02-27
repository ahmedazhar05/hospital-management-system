import { Component, Output, ViewChild } from '@angular/core';
import { Router } from '@angular/router';
import { BasePage } from '../app.component';
import { AuthService } from '../auth.service';
import { ServerService } from '../server.service';
import { ToastComponent } from '../toast/toast.component';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html'
})
export class LoginComponent implements BasePage {

  constructor(private authService: AuthService, private router: Router, private server: ServerService) { }

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
  @ViewChild(ToastComponent)
  private notify!: ToastComponent;

  private ONE_HOUR = 1000 * 60 * 60;

  onLogin() {
    if (this.form.valid) {
      /*
      this.authService.login(this.form.value.login, this.form.value.password)
      .subscribe(() => {
        // this.router.navigate(['/prescription'])
        this.router.navigateByUrl('/dashboard');
      });
      */
      
      // let isLoggedIn: boolean = 
      let isLogged = false;
      let pid = -1;
      let credential = this.form.value.login;
      let passwd = this.form.value.password;

      for(let t of ["patient", "doctor", "admin"]){
        if(!isLogged){          
          this.server.get(t + 's')
          .subscribe((d: any) => {
            for(let p of JSON.parse(d)){
              if((p.email == credential || p.contact == credential) && passwd == p.hash){
                isLogged = true;
                pid = p.id;
                this.authService.setSession(new Date().valueOf() + this.ONE_HOUR, t, pid);
                this.router.navigate(['/dashboard']);
                break;
              }
            }
          })
        }
      }
      setTimeout(() => {
        if(!isLogged){
          this.notify.showToast('Incorrect user details', 'danger', 2000);
        }
      }, 1000);

/*
      this.authService.login(this.form.value.login, this.form.value.password);
      setTimeout(() => {
        if(this.authService.isLoggedIn()){
          this.router.navigate(['/dashboard']);
        } else {
          this.notify.showToast('Incorrect user details', 'danger', 2000);
        }
      }, 1000);
*/
      // if(isLoggedIn) this.router.navigateByUrl('/dashboard');
      // else {
      //   this.notify.showToast('Incorrect user details', 'danger', 2000);
      // }
      // console.log(this.form.value);
      // TODO: perform the necessary login process with these form values
      this.form.reset();
    }
  }
}