import { Component, OnInit, ViewChild } from '@angular/core';
import { ServerService } from '../server.service';
import Utilities from '../utilities/utility';

@Component({
  selector: 'app-verify',
  templateUrl: './verify.component.html',
  styleUrls: ['./verify.component.css']
})
export class VerifyComponent implements OnInit {
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

  constructor(private server: ServerService){ }

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

  verify(){
    if(this.form.valid){
      console.log(this.form.value);
    }
  }
}

