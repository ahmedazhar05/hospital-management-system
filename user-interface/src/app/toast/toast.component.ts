import { Component } from '@angular/core';

@Component({
  selector: 'app-toast',
  templateUrl: './toast.component.html'
})
export class ToastComponent {
  type = 'white';
  message = '';

  classes = ""

  constructor() { }


  hideToast(){
    this.message = "";
    this.type = "white";

    this.classes = "";
  }

  showToast(message: string, type : string = 'white', millis: number = 10000){
    this.message = message;
    this.type = type;

    this.classes = "fade show";

    setTimeout(()=>{
      this.hideToast();
    }, millis);
  }
}
