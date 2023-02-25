import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import { AuthService } from './auth.service';

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {

  constructor(private authService: AuthService, private router: Router) { }

  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot
  ): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {

    let url: string = state.url;
    return this.checkLogin(url);

  }

  checkLogin(url: string): true | UrlTree {
    console.log("Url: " + url)
    // let val: string | null = localStorage.getItem('isUserLoggedIn');
    const val: boolean = this.authService.isLoggedIn();

    //if (val != null && val == "true") {
    if (val) {
      if (url == "/login"){
        return this.router.parseUrl('/dashboard');
      } else {
        return true;
      }
    } else {
      return this.router.parseUrl('/login');
    }
  }
}
