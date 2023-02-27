import { Component, OnInit, Output, ViewChild } from '@angular/core';
import { Router } from '@angular/router';
import { isBlock } from 'typescript';
import { BasePage } from '../app.component';
import { AuthService } from '../auth.service';
import { ServerService } from '../server.service';
import { ToastComponent } from '../toast/toast.component';
import Utilities from '../utilities/utility';

@Component({
  selector: 'app-reports-list',
  templateUrl: './reports-list.component.html',
  styleUrls: ['./reports-list.component.css']
})
export class ReportsListComponent implements OnInit, BasePage {
  
  constructor(private auth: AuthService, private server: ServerService, private router: Router) { }
  @Output()
  options: { text: string; href: string; }[] = [
    {
      text: 'Dashboard',
      href: '/dashboard'
    }
  ];
  reports: any[] = [];
  today: any = Utilities.formatDate(new Date());

  uid = this.auth.getUserId()

  @ViewChild(ToastComponent)
  private notify!: ToastComponent;

  isBlocked: boolean = false;

  ngOnInit(): void {
    let userId = this.uid;

    let pid = this.auth.getUserId();
    this.server.get('patients/' + pid)
    .subscribe((d: any) => {
      let pat = JSON.parse(d);
      this.isBlocked = pat.status == 'BLOCKED';
    })
    
    this.server.get('reports/search', {
      patient: userId
    })
    .subscribe((d: any) => {
      let data: any[] = JSON.parse(d);
      this.reports = data;
    })
  }

  selectDelete:number = -1;

  deleteReport(index: number){
    this.selectDelete = index;
  }

  yesDelete(){
    this.server.delete('reports/' + this.reports[this.selectDelete].id)
    .subscribe((d: any) => {
      this.reports.splice(this.selectDelete, 1);
      this.notify.showToast("Deleted successfully", "success", 2000);
    });
    this.selectDelete = -1;
  }

  @ViewChild('dismiss')
  private dismiss!: any;

  addReport(form: any){
    let id = this.uid;
    if(form.valid){
      this.dismiss.nativeElement.click();
      this.server.post('reports', {
        ...form.value,
        patient: {
          id: id
        }
      }).subscribe((d: any) => {
        this.reports.push({
          ...form.value,
          patient: { id }
        });

        // re-fetching the reports collection
        this.server.get('reports/search', {
          patient: id
        })
        .subscribe((d: any) => {
          let data: any[] = JSON.parse(d);
          this.reports = data;
        })
        this.notify.showToast("Added a new report", "success", 2000);
        form.reset();
      });
    }
  }
}
