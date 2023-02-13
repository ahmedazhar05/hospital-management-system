import { Component, ViewChild } from '@angular/core';

@Component({
  selector: 'app-prescription',
  templateUrl: './prescription.component.html',
  styleUrls: ['./prescription.component.css']
})
export class PrescriptionComponent {
  address = "Hospital, Mumbai, Matoshree Nagar, Nashik, Maharashtra 422002"
  mob_no = "8087030000"
  phn_no = "1234567891"
  mail_id = "ahmedazhar@gmail.com"
  name = "Dr. kuber kanade"
  degree = "MBBS, DNB(Gen. Surgeon), MS, MNAMS, FMAS, FIAGES, FALS, AFIH"

@ViewChild("f") form:any;

  onPrescribe(){
    if(this.form.valid){
      console.log(this.form.value);
      // TODO: perform the necessary login process with these form values
      this.form.reset();
    }
  }
}
