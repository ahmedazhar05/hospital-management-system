import { Component, OnInit, Output, ViewChild } from '@angular/core';
import { NgForm, NgModelGroup } from '@angular/forms';
import { BasePage } from '../app.component';
import { AuthService } from '../auth.service';
import { ServerService } from '../server.service';
import Utilities from '../utilities/utility';
import { ActivatedRoute, Router } from '@angular/router'

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
export class PrescriptionComponent implements BasePage, OnInit {
  @Output()
  options: { text: string; href: string; }[] = [
    {
      text: 'Dashboard',
      href: '/dashboard'
    }
  ];
  userId: any;
  userType: any;
  access: string = "";

  constructor(private auth: AuthService, private server: ServerService, private route: ActivatedRoute, private router: Router) { }

  address = "Mumbai, Matoshree Nagar, Nashik, Maharashtra 422002"
  mob_no = "8087030000"
  mail_id = "ahmedazhar@gmail.com"
  name = "Dr. Vishal Pasumarthi"
  degree = "MBBS, DNB(Gen. Surgeon)"

  prescription: {
    patientName: string;
    patientAge: number | string;
    diagnosis: string;
    investigation: string;
    medicinePlan: {
      name: string,
      dosage: string,
      duration: number
    }[];
    dietPlan: {
      food: string;
      duration: number
    }[];
    avoidables: string;
  } = {
    patientName: "",
    patientAge: "",
    diagnosis: "",
    investigation: "",
    medicinePlan: [],
    dietPlan: [],
    avoidables: ""
  }

  @ViewChild("f")
  form: any;

  dosage_list = Object.values(DOSAGE);
  dietEnabled = false;

  appendMedPlan(){
    // if(Object.entries(this.medicine) == Object.entries({ name: "", dosage: "", duration: 0 }))
    this.prescription.medicinePlan.push(this.form.value.medPlan);
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
      food: "",
      duration: 0
    };
  }

  deleteMedPlan(index: number){
    this.prescription.medicinePlan.splice(index, 1);
  }
  
  deleteDietPlan(index: number){
    this.prescription.dietPlan.splice(index, 1);
  }

  onPrescribe() {
    // Note: only consider diet plan values if the `dietEnabled` is true, otherwise ignore all the inputted values
    if (this.form.valid) {

      let pres = {
        diagnosis: this.form.value.diagnosis,
        investigation: this.form.value.investigation,
        avoidables: this.form.value.avoidables,
        date: Utilities.formatDate(new Date()),
        isIpd: 0,
        patient: {
          id: 1 // TODO: need to fetch
        },
        doctor: {
          id: this.userId
        }
      };
      this.server.post('prescriptions', pres)
      .subscribe((data: any) => {
        console.log(data);
      });
      
      for(let dp of this.prescription.dietPlan) this.server.post('diet', dp).subscribe((data: any) => {
        console.log(data);
      });
      for(let mp of this.prescription.medicinePlan) this.server.post('medicine', mp).subscribe((data: any) => {
        console.log(data);
      });
      
      console.log(pres);
      // TODO: perform the necessary login process with these form values
      this.form.reset();
    }
  }

  ngOnInit(): void {
    this.userId = this.auth.getUserId();
    this.userType = this.auth.getUserType();

    let url = this.router.url.split('/');
    let pid = Number(url[url.length - 1]);
    this.access = url[url.length - 2];

    if(this.access == 'view'){
      this.server.get('prescriptions/' + pid)
      .subscribe((d: any) => {
        let data = JSON.parse(d);
        this.prescription.patientName = data.patient.firstName + ' ' + data.patient.lastName;
        this.prescription.diagnosis = data.diagnosis;
        this.prescription.investigation = data.investigation;
        this.prescription.avoidables = data.avoidables;

        this.fillDoctor(data.doctor);
      })

      this.server.get('medicines/search', {
        prescription: pid
      }).subscribe((d: any) => {
        this.prescription.medicinePlan = JSON.parse(d);
      })
      this.server.get('diet/search', {
        prescription: pid
      }).subscribe((d: any) => {
        let data = JSON.parse(d);
        if(this.dietEnabled = data.length > 0){
          this.prescription.dietPlan = data;
        }
      })

    } else if(this.access == 'create') {
      this.server.get('appointments/' + pid)
      .subscribe((d: any) => {
        let data = JSON.parse(d);
        this.prescription.patientName = data.patient.firstName + ' ' + data.patient.lastName;
        this.prescription.patientAge = Utilities.calculateAge(data.patient.dateOfBirth);

        this.fillDoctor(data.doctor);
      })
    } else {
      this.server.get('doctors/' + this.userId)
      .subscribe((d: any) => this.fillDoctor(JSON.parse(d)))
    }
  }

  fillDoctor(data: any){
    this.name = data.firstName + ' ' + data.lastName;
    this.degree = data.degrees;
    this.mob_no = data.contact;
    this.mail_id = data.email;
  }
}

