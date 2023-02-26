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

  private setSession(authResult: { token: string; }) {
    const token_payload = JSON.parse(atob(authResult.token.split('.')[1]));
    const expiresAt: number = token_payload.exp * 1000;
    const userType: string = token_payload.user;
    const userId: number = token_payload.id;
    const token = authResult.token;
    localStorage.setItem('id_token', token);
    localStorage.setItem("expires_at", JSON.stringify(expiresAt));
    localStorage.setItem("user_type", userType);
    localStorage.setItem("user_id", JSON.stringify(userId));
  }

  logout() {
    localStorage.removeItem("id_token");
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