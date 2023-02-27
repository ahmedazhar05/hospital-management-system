import { Component, OnInit, ViewChild } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { BasePage } from '../app.component';
import { AuthService } from '../auth.service';
import { ServerService } from '../server.service';
import Utilities from '../utilities/utility';

@Component({
  selector: 'app-prescription-list',
  templateUrl: './prescription-list.component.html',
  styleUrls: ['./prescription-list.component.css']
})
export class PrescriptionListComponent implements OnInit, BasePage {
  
  constructor(private auth: AuthService, private server: ServerService, private router: Router) { }
  options: { text: string; href: string; }[] = [
    {
      text: 'Dashboard',
      href: '/dashboard'
    }
  ];

  prescriptions: any[] = [];

  uid = this.auth.getUserId()

  ngOnInit(): void {
    let userId = this.uid;
    
    this.server.get('prescriptions/search', {
      patient: userId
    })
    .subscribe((d: any) => {
      let data: any[] = JSON.parse(d);
      for(let p of data){
        this.prescriptions.push({
          ...p,
          href: ['..', 'view', p.id]
        })
      }
    })
  }
}
