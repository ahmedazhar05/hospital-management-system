import { HttpClient, HttpParams, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ServerService {

  private domain: string = "http://localhost:8080/";

  constructor(private http: HttpClient) { }

  get(uri: string, params: any = {}) {
    let pms: any = null;
    for(let p in params){
      if (pms == null) pms = new HttpParams().set(p, params[p]);
      else pms = pms.set(p, params[p]);
    }
    let parameters: any = pms == null ? {} : { params: pms };
    parameters['responseType'] = 'text';
    /*const headers = new HttpHeaders()
    .set('Content-Type', 'text/plain; charset=utf-8')
    .set('Sec-Fetch-Mode', 'no-cors');*/
    return this.http.get(this.domain + uri, parameters);
  }

  post(uri: string, body: any = {}){
    return this.http.get(this.domain + uri, body);
  }
}

