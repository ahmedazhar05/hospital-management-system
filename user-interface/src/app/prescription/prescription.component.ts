import { Component, OnInit, Output, ViewChild } from '@angular/core';
import { NgForm, NgModelGroup } from '@angular/forms';
import { BasePage } from '../app.component';
import { AuthService } from '../auth.service';
import { ServerService } from '../server.service';
import Utilities from '../utilities/utility';
import { ActivatedRoute, Router } from '@angular/router'
import { ToastComponent } from '../toast/toast.component';

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

  @ViewChild(ToastComponent)
  private notify!: ToastComponent;

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
  patientId: number = 0;

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
        patient: { id: this.patientId },
        doctor: { id: this.userId }
      };
      this.server.post('prescriptions', pres)
      .subscribe((data: any) => {
        let pid = JSON.parse(data).id;
        console.log(pid);
        if(pid > 0){
          
          for(let dp of this.prescription.dietPlan) {
            console.log(dp);
            this.server.post('diet', {
              ...dp,
              prescription: { id: pid }
            }).subscribe((d: any) => {
              console.log(d);
            });
          }
          for(let mp of this.prescription.medicinePlan) {
            console.log(mp);
            this.server.post('medicines', {
              ...mp,
              prescription: { id: pid }
            }).subscribe((d: any) => {
              console.log(d);
            });
          }

          this.notify.showToast('Prescription Saved', 'success', 10000);
          setTimeout(() => {
            this.router.navigate(['/dashboard']);
          }, 5000);
        }
      });
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
        this.patientId = data.patient.id;

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

