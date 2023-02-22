import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { shareReplay, tap } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private http: HttpClient) { }

  login(credential: string, password: string ) {
    return this.http.post('/authenticate', {credential, password}, {responseType: 'text'})
    .pipe(
      tap((res: any) => this.setSession),
      shareReplay()
    )
    //.do((res: any) => this.setSession) 
    //.shareReplay();
  }

  private setSession(authResult: { expiresIn: number; idToken: string; }) {
    //const expiresAt = moment().add(authResult.expiresIn,'second');
    const expiresAt: number = new Date().valueOf() + authResult.expiresIn;

    localStorage.setItem('id_token', authResult.idToken);
    localStorage.setItem("expires_at", JSON.stringify(expiresAt));
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
}