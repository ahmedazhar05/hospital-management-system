import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { shareReplay, tap } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private URL = 'http://localhost:8009';

  constructor(private http: HttpClient) { }

  login(credential: string, password: string) {
    return this.http.post(this.URL + '/login', { username: credential, password })
      .pipe(
        // tap((res: any) => this.setSession),

        tap((val: any) => this.setSession(val)),
        shareReplay()
      )
    //.do((res: any) => this.setSession) 
    //.shareReplay();
  }

  private setSession(authResult: { userType: string; expiresIn: number; idToken: string; }) {
    //const expiresAt = moment().add(authResult.expiresIn,'second');
    const expiresAt: number = new Date().valueOf() + authResult.expiresIn;
    const token = authResult.idToken;
    localStorage.setItem('id_token', token);
    localStorage.setItem("expires_at", JSON.stringify(expiresAt));
    localStorage.setItem("user_type", JSON.stringify(authResult.userType));
  }

  logout() {
    localStorage.removeItem("id_token");
    localStorage.removeItem("expires_at");
  }

  public isLoggedIn() {
    return new Date().valueOf() < this.getExpiration();
    //moment().isBefore(this.getExpiration());
  }

  isLoggedOut() {
    return !this.isLoggedIn();
  }

  getExpiration() {
    const expiration = localStorage.getItem("expires_at") + "";
    const expiresAt = JSON.parse(expiration);
    return new Date(expiresAt).valueOf();
  }

  getUserType() {
    const item = localStorage.getItem("user_type") + "";
    const userType = JSON.parse(item);
    return userType;
  }
}