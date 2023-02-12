import { Component } from '@angular/core';

type navOptionsType = {
  text: string,
  href: string
}[];

export interface BasePage {
  options: navOptionsType;
}

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements BasePage {
  options: navOptionsType = [{
    text: 'Home',
    href: '/'
  }];
  title: string = "Health+";
  public setNavbarNavigations(component: { options: navOptionsType }){
    this.options = component.options;
  }
}