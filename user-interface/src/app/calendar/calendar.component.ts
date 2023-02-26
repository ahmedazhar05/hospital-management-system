import { Component, Input, OnInit, ViewChild } from '@angular/core';
import { AuthService } from '../auth.service';
import { ServerService } from '../server.service';
import { ToastComponent } from '../toast/toast.component';
import Utilities from '../utilities/utility';

@Component({
  selector: 'app-calendar',
  templateUrl: './calendar.component.html',
  styleUrls: ['./calendar.component.css']
})
export class CalendarComponent implements OnInit {

  constructor(private server: ServerService, private auth: AuthService) { }

  order: (number | null)[][] = [];
  calendar: {
    month: number;
    monthName: string;
    year: number
  } = {
    month: 0,
    monthName: "",
    year: 0
  }
  selected: Date | null = new Date();
  appointments: {
    doctor: {
      firstName: string;
      lastName: string;
      id: number
    },
    patient: {
      firstName: string;
      lastName: string;
      id: number
    },
    timeslot: {
      time: string;
    };
    href: any;
    id: number;
  }[] = []

  shiftCalendar(m: number){
    this.order = [];
    this.calendar.month += m;
    if(this.calendar.month < 0){
      this.calendar.year -= 1;
      this.calendar.month += 12;
    } else if(this.calendar.month > 11) {
      this.calendar.year += 1;
      this.calendar.month -= 12;
    }
    this.calendar.monthName = ["January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"][this.calendar.month];

    const someDay = new Date(this.calendar.year, this.calendar.month);
    const daysCount = 32 - new Date(this.calendar.year, this.calendar.month, 32).getDate();
    const offset = someDay.getDay();
    let week: (number | null)[] = [];

    // populating calendar numbers in the `this.order` 2D array
    for(let i = 1 - offset, j = 0; i <= daysCount || j % 7 != 0; i++, j++){
      week.push(i > 0 && i <= daysCount ? i: null);
      if((j + 1) % 7 == 0 && week.length > 0) {
        this.order.push(week);
        week = [];
      }
    }
  }

  userId: number = 0;
  userType: string = "";

  toggle: any = 'modal';
  mod: any = '#deleteModal';

  ngOnInit(): void {
    this.userId = this.auth.getUserId();
    this.userType = this.auth.getUserType();
    if(this.userType == 'doctor'){
      this.toggle = this.mod = null;
    } else {
      this.toggle = 'modal';
      this.mod = '#deleteModal';
    }

    const today = new Date();
    this.calendar = {
      month: today.getMonth(),
      monthName: ["January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"][this.calendar.month],
      year: today.getFullYear()
    }
    this.shiftCalendar(0);

    this.getAppointments(new Date().getDate());
  }

  appToDelete = -1;

  delete(id: number){
    if(this.userType == 'doctor') return;
    this.appToDelete = id;
  }

  @ViewChild(ToastComponent)
  private notify!: ToastComponent;

  yesDelete(){
    this.server.delete('appointments/' + this.appToDelete)
    .subscribe((d: any) => {
      this.appToDelete = -1;
      this.notify.showToast('Appointment Deleted', 'white', 5000);
      this.appointments = [];
      this.selected = null;
    });
  }

  getAppointments(day: number){
    // TODO: implement the process of fetching appointments of that day
    this.selected = new Date(this.calendar.year, this.calendar.month, day);
    // console.log(this.selected);

    this.server.get('appointments/search', {
      [this.userType]: this.userId,
      date: Utilities.formatDate(this.selected)
    })
    .subscribe((data: any) => {
      let val: any[] = JSON.parse(data);
      val.map(x => x.href = this.userType == 'patient' ? null : ['prescription', 'create', x.id]);
      this.appointments = val;
    });
    // ?' + this.userType + "=" + this.userId + "&date=" + this.formatDate(this.selected)
  }

  isSelected(date: number){
    if(this.selected == null) return false;
    return this.selected.getFullYear() == this.calendar.year && this.selected.getMonth() == this.calendar.month && this.selected.getDate() == date;
  }
}
