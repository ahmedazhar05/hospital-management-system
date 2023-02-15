import { Component, Output, ViewChild } from '@angular/core';
import { BasePage } from '../app.component';

@Component({
  selector: 'app-book-appointment',
  templateUrl: './book-appointment.component.html',
  styleUrls: ['./book-appointment.component.css']
})
export class BookAppointmentComponent implements BasePage {
  @Output()
  options: { text: string; href: string; }[]=[
    {
      text: 'Home',
      href: '/'
    },
    {
      text: 'Doctors',
      href: '/doctors'
    },
    {
      text: 'Departmentss',
      href: '/departments'
    },
    {
      text: 'Get Info',
      href: '/info'
    }
  ];

  Symptoms=[
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

  Speciality=[
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

  Doctors=[
    'Dr. Kuber Kanade',
                  'Dr. Vishal Pasumarthi',
                  'Dr. Amar Kumar',
                  'Dr. Azhar Ahmed',
  ]

  @ViewChild('f') form: any;
  
  onBooking(){
    if(this.form.valid){
      console.log(this.form.value);
      // TODO: perform the necessary login process with these form values
      this.form.reset();
    }
  }

}
