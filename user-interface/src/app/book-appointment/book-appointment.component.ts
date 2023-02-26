import { Component, OnInit, Output, ViewChild } from '@angular/core';
import { BasePage } from '../app.component';
import { AuthService } from '../auth.service';
import { ServerService } from '../server.service';
import Utilities from '../utilities/utility';

@Component({
  selector: 'app-book-appointment',
  templateUrl: './book-appointment.component.html',
  styleUrls: ['./book-appointment.component.css']
})
export class BookAppointmentComponent implements BasePage, OnInit {
  @Output()
  options: { text: string; href: string; }[] = [
    {
      text: 'Dashboard',
      href: '/dashboard'
    }
  ];

  symptoms = [
    'Fever or chills',
    'Cough',
    'Shortness of breath or difficulty breathing',
    'Fatigue',
    'Muscle or body aches',
    'Headache',
    'New loss of taste or smell',
    'Sore throat  ',
    'Congestion or runny nose',
    'Nausea or vomiting',
    'Diarrhea',
  ];

  speciality = [
    'Orthopedics',
    'Internal Medicine',
    'Obstetrics and Gynecology',
    'Dermatology',
    'Pediatrics',
    'Radiology',
    'General Surgery',
    'Ophthalmology',
    'Family Medicine',
    'Chest Medicine',
    'Anesthesia',
    'Pathology',
    'ENT',
  ];

  doctors: {
    name: string;
    id: number;
  }[] = [];

  reports = [
    {
      name: "Blood Report",
      url: "#"
    },
    {
      name: "CT scan Report",
      url: "#"
    }
  ];

  days: string[] = [];
  slots: {
    time: string,
    id: number
  }[] = [];
  allSlots = [];
  selectedSlot: number = 0;
  selectedDay: any;

  @ViewChild('f') form: any;

  today = new Date();

  constructor(private server: ServerService, private auth: AuthService) { }

  onDoctorChange(){
    let doctorId = this.form.value.doctor;
    this.server.get('timeslots/search', {
      doctor: Number(doctorId),
      //date: Utilities.formatDate(this.today)
    })
    .subscribe((data: any) => {
      this.allSlots = JSON.parse(data);
    })
    this.slots = [];
    this.selectedDay = -1;
  }

  onCh(val: any){
    this.selectedDay = val;
    this.slots = this.allSlots.filter((x: any) => 
      x.dayOfWeek.toLowerCase().startsWith(this.days[val].toLowerCase())
    )
  }

  onBooking() {
    if (this.form.valid) {
      let obj: any = { ...this.form.value };

      delete obj['speciality'];
      obj.patient = { id: this.auth.getUserId() };
      obj.doctor = { id: Number(obj.doctor) };
      obj.date = this.calculateDate(this.allSlots.filter((x: any) => x.id == this.selectedSlot)[0]);
      obj.timeslot = { id: this.selectedSlot };

      console.log(obj);
      
      this.selectedDay = 0;
      this.slots = [];
      // TODO: perform the necessary login process with these form values
      this.form.reset();
    }
  }

  calculateDate(val: any): any {
    let st = val.dayOfWeek;
    let dow: number = this.days.indexOf(st[0] + (st[1] + st[2]).toLowerCase());
    return Utilities.formatDate(new Date(this.today.valueOf() + (dow + 1) * 1000 * 60 * 60 * 24));
  }

  ngOnInit(): void {
    let week = ["Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"];
    let dow = this.today.getDay() + 1;
    this.days = week.concat(week).slice(dow, 7 + dow);

    this.server.get('doctors').subscribe((data: any) => {
      this.doctors = JSON.parse(data).map((x: any) => {
        return {
          name: x.firstName + ' ' + x.lastName,
          id: x.id
        }
      })
    });
  }

}
