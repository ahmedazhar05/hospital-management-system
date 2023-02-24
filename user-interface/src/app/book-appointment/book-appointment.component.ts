import { Component, OnInit, Output, ViewChild } from '@angular/core';
import { BasePage } from '../app.component';

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
    'Fever or chills  ',
    'Cough  ',
    'Shortness of breath or difficulty breathing  ',
    'Fatigue  ',
    'Muscle or body aches  ',
    'Headache  ',
    'New loss of taste or smell  ',
    'Sore throat  ',
    'Congestion or runny nose  ',
    'Nausea or vomiting  ',
    'Diarrhea  ',
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

  doctors = [
    'Dr. Kuber Kanade',
    'Dr. Vishal Pasumarthi',
    'Dr. Amar Kumar',
    'Dr. Azhar Ahmed',
  ];

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

  @ViewChild('f') form: any;

  onBooking() {
    if (this.form.valid) {
      console.log(this.form.value);
      // TODO: perform the necessary login process with these form values
      this.form.reset();
    }
  }

  days: string[] = [];
  slots: string[] = [
    '11am',
    '4pm',
    '6am',
    '2pm',
    '7pm'
  ];

  ngOnInit(): void {
    let week = ["Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"];
    let dow = new Date().getDay() + 1;
    this.days = week.concat(week).slice(dow, 7 + dow);
  }

}
