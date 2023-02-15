import { Component, Output } from '@angular/core';
import { BasePage } from '../app.component';

@Component({
  selector: 'app-gov-scheme',
  templateUrl: './gov-scheme.component.html',
  styleUrls: ['./gov-scheme.component.css']
})
export class GovSchemeComponent implements BasePage {
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
      text: 'Departments',
      href: '/departments'
    },
    {
      text: 'Get Info',
      href: '/info'
    }
  ];

  Schemes=[
    
'1. Rajiv Gandhi Jeevandayee yojana',
'2. Mahatma Jyotiba Phule yojana',
'3. Ayushman Bharat yojana',
'4. Awaz Health Insurance Scheme',
'5. Bhamashah Swasthya Bima Yojana',
'6. Central Government Health Scheme (CGHS)'
  ];

}
