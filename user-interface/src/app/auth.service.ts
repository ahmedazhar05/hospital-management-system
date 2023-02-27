import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map, Subscriber } from 'rxjs';
import { ServerService } from './server.service';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private server: ServerService) { }
/*
  login(credential: string, password: string) {

    for(let t of ["patient", "doctor", "admin"]){
      if(!this.isLoggedIn()){
        this.server.get(t + 's')
        .subscribe((d: any) => {
          for(let p of JSON.parse(d)){
            if((p.email == credential || p.contact == credential) && password == p.hash){
              this.setSession(new Date().valueOf() + this.ONE_HOUR, t, p.id);
              break;
            }
          }
        })
      } else {
        return true;
      }
    }
    return false;

    /*
    return this.http.post(this.URL + '/login', { username: credential, password })
      .pipe(
        // tap((res: any) => this.setSession),

        tap((val: any) => this.setSession(val)),
        shareReplay()
      )
      * /
    //.do((res: any) => this.setSession) 
    //.shareReplay();
  }
*/
  setSession(expiresAt: number, userType: string, userId: number) {
    // const token_payload = JSON.parse(atob(authResult.token.split('.')[1]));
    // const expiresAt: number = token_payload.exp * 1000;
    // const userType: string = token_payload.user;
    // const userId: number = token_payload.id;
    // const token = authResult.token;
    //localStorage.setItem('id_token', token);
    localStorage.setItem("expires_at", JSON.stringify(expiresAt));
    localStorage.setItem("user_type", userType);
    localStorage.setItem("user_id", JSON.stringify(userId));
  }

/*
  private setSession(authResult: { token: string; }) {
    const token_payload = JSON.parse(atob(authResult.token.split('.')[1]));
    const expiresAt: number = token_payload.exp * 1000;
    const userType: string = token_payload.user;
    const userId: number = token_payload.id;
    const token = authResult.token;
    //localStorage.setItem('id_token', token);
    localStorage.setItem("expires_at", JSON.stringify(expiresAt));
    localStorage.setItem("user_type", userType);
    localStorage.setItem("user_id", JSON.stringify(userId));
  }*/

  logout() {
    //localStorage.removeItem("id_token");
    localStorage.removeItem("expires_at");
    localStorage.removeItem("user_type");
    localStorage.removeItem("user_id");
  }

  public isLoggedIn() {
    return new Date().valueOf() < this.getExpiration().valueOf();
    //moment().isBefore(this.getExpiration());
  }

  isLoggedOut() {
    return !this.isLoggedIn();
  }

  getExpiration() {
    const expiration = localStorage.getItem("expires_at") + "";
    const expiresAt = JSON.parse(expiration);
    return new Date(expiresAt);
  }

  getUserId() {
    const item = localStorage.getItem("user_id") + "";
    const userType = JSON.parse(item);
    return userType;
  }

  getUserType() {
    return localStorage.getItem("user_type") + "";
  }
}