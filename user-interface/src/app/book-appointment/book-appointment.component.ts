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
  selectedDate: number = 0;

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
  }

  onCh(val: any){
    this.slots = this.allSlots.filter((x: any) => 
      x.dayOfWeek.toLowerCase().startsWith(val.toLowerCase())
    )
    console.log(this.slots);
  }

  onBooking() {
    if (this.form.valid) {
      let obj: any = { ...this.form.value };

      delete obj['speciality'];
      obj.patient = { id: this.auth.getUserId() };
      obj.doctor = { id: obj.doctor };
      obj.date = Utilities.formatDate(this.today);
      obj.timeslot = { timeslot: this.selectedSlot };
      // TODO: perform the necessary login process with these form values
      this.form.reset();
    }
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
