import { Component, ViewChild } from '@angular/core';
import { NgForm, NgModelGroup } from '@angular/forms';

enum DOSAGE {
  MORNING = "morning",
  BEFORE_LUNCH = "before_lunch",
  AFTER_LUNCH = "after_lunch",
  BEFORE_DINNER = "before_dinner",
  AFTER_DINNER = "after_dinner",
  FEEL_SICK = "sick"
}

@Component({
  selector: 'app-prescription',
  templateUrl: './prescription.component.html',
  styleUrls: ['./prescription.component.css']
})
export class PrescriptionComponent {
  address = "Mumbai, Matoshree Nagar, Nashik, Maharashtra 422002"
  mob_no = "8087030000"
  phn_no = "1234567891"
  mail_id = "ahmedazhar@gmail.com"
  name = "Dr. Vishal Pasumarthi"
  degree = "MBBS, DNB(Gen. Surgeon)"

  prescription: {
    patientName: string;
    patientAge: number;
    diagnosis: string;
    investigation: string;
    medPlan: {
      name: string,
      dosage: string,
      duration: number
    }[];
    dietPlan: {
      name: string;
      duration: number
    }[]
  } = {
    patientName: "Sunil Chawla",
    patientAge: 25,
    diagnosis: "",
    investigation: "",
    medPlan: [
      {
        name: "Calpol",
        dosage: DOSAGE.FEEL_SICK,
        duration: 3
      }
    ],
    dietPlan: [
      {
        name: "Calpol",
        duration: 3
      }
    ]
  }

  @ViewChild("f")
  form: any;

  dosage_list = Object.values(DOSAGE);
  dietEnabled = false;

  appendMedPlan(){
    // if(Object.entries(this.medicine) == Object.entries({ name: "", dosage: "", duration: 0 }))
    this.prescription.medPlan.push(this.form.value.medPlan);
    this.form.value.medPlan = {
      name: "",
      dosage: "",
      duration: 0
    };
  }

  appendDietPlan(){
    //if(Object.entries(this.diet) == Object.entries({ name: "", duration: 0 }))
    this.prescription.dietPlan.push(this.form.value.dietPlan);
    this.form.value.dietPlan = {
      name: "",
      duration: 0
    };
  }

  deleteMedPlan(index: number){
    this.prescription.medPlan.splice(index, 1);
  }
  
  deleteDietPlan(index: number){
    this.prescription.dietPlan.splice(index, 1);
  }

  onPrescribe() {
    // Note: only consider diet plan values if the `dietEnabled` is true, otherwise ignore all the inputted values
    if (this.form.valid) {
      console.log(this.form.value);
      // TODO: perform the necessary login process with these form values
      this.form.reset();
    }
  }
}
