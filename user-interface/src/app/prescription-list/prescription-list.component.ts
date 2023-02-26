import { Component, OnInit } from '@angular/core';
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
  
  constructor(private auth: AuthService, private server: ServerService, private route: Router) { }
  options: { text: string; href: string; }[] = [
    {
      text: 'Dashboard',
      href: '/dashboard'
    }
  ];

  prescriptions: any[] = [];
  reports: any[] = [];
  type = 'prescriptions';

  selectDelete:number = -1;
  today: any = Utilities.formatDate(new Date());

  uid = this.auth.getUserId()

  ngOnInit(): void {
    let userId = this.uid;

    let url: string = this.route.url + "";
    this.type = url.indexOf('/reports') >= 0 ? 'reports': 'prescriptions';
    
    this.server.get(this.type + '/search', {
      patient: userId
    })
    .subscribe((d: any) => {
      let data: any[] = JSON.parse(d);
      for(let p of data){
        console.log(data, this.type);
        if(this.type == 'reports'){
          this.reports = data;
          this.prescriptions = [];
        } else {
          this.prescriptions.push({
            ...p,
            href: ['..', 'view', p.id]
          })
          this.reports = [];
        }
      }
    })
  }

  deleteReport(index: number){
    this.selectDelete = index;
  }

  yesDelete(){
    console.log(this.reports[this.selectDelete].id);
    this.server.delete('report/' + this.reports[this.selectDelete].id)
    .subscribe((d: any) => {
      this.route.navigate(['/dashboard/reports']);
    });
    this.selectDelete = -1;
  }

  addReport(form: any){
    console.log(form.value);
    this.server.post('reports', {
      ...form.value,
      patient: {
        id: this.uid
      }
    }).subscribe((d: any) => console.log(d));
  }
}
