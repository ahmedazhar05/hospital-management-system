import { Component, OnInit, ViewChild } from '@angular/core';
import { Router } from '@angular/router';
import { BasePage } from '../app.component';
import { ServerService } from '../server.service';
import { ToastComponent } from '../toast/toast.component';
import Utilities from '../utilities/utility';

@Component({
  selector: 'app-verify',
  templateUrl: './verify.component.html',
  styleUrls: ['./verify.component.css']
})
export class VerifyComponent implements OnInit, BasePage {
  patient: {
    id: number;
    hash: string;
    email: string;
    contact: string;
    credential: string,
    role: string,
    firstName: string;
    lastName: string;
    dateOfBirth: string;
    gender: string;
    addressLine1: string;
    addressLine2: string;
    addressLine3: string;
    state: string;
    city: string;
    zip: number;
    documentType: string;
    documentNumber: string;
    weight: number;
    bloodGroup: string;
    status: string;
} = {
    id: 0,
    hash: "",
    email: "",
    contact: "",
    credential: "",
    role: "",
    firstName: "",
    lastName: "",
    dateOfBirth: "",
    gender: "",
    addressLine1: "",
    addressLine2: "",
    addressLine3: "",
    state: "",
    city: "",
    zip: 0,
    documentType: "",
    documentNumber: "",
    weight: 0,
    bloodGroup: "",
    status: "",
  }
  dob: string = '';

  constructor(private server: ServerService, private router: Router){ }
  options: { text: string; href: string; }[] = [
    {
      text: 'Dashboard',
      href: '/dashboard'
    }
  ];

  plist: any[] = [];

  @ViewChild('searchinput')
  search: any = "";

  @ViewChild('f')
  form: any = "";

  ngOnInit(): void {
    this.server.get('patients')
    .subscribe((d: any) => {
      this.plist = JSON.parse(d);
    })
  }

  highlight(){
    let pat = this.search.nativeElement.value;
    this.patient = this.plist.filter(x => x.id == Number(pat.slice(pat.lastIndexOf('#') + 1)))[0];
    this.dob = Utilities.formatDate(new Date(this.patient.dateOfBirth));
  }

  @ViewChild(ToastComponent)
  private notify!: ToastComponent;

  verify(){
    if(this.form.valid){
      this.server.put('patients/' + this.patient.id + "?status=" + this.form.value.status, {})
      .subscribe((d: any) => {
        if(d == 'Update'){
          this.notify.showToast("Successfully updated patient status", "success", 2000);
          setTimeout(() => {
            this.router.navigate(['/dashboard']);
          }, 2000);
        } else {
          this.notify.showToast("Failed to update the patient", "danger", 2000);
        }
      })
    }
  }
}

