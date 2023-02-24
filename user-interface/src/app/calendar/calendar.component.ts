import { Component, Input, OnInit } from '@angular/core';
import { ServerService } from '../server.service';
import Utilities from '../utilities/utility';

@Component({
  selector: 'app-calendar',
  templateUrl: './calendar.component.html',
  styleUrls: ['./calendar.component.css']
})
export class CalendarComponent implements OnInit {
  @Input()
  userId = 0;
  @Input()
  userType = '';

  constructor(private server: ServerService) { }

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
  selected = new Date();
  appointments: {
    name: string;
    time: string;
    href: string
  }[] = [
    {
      name: 'Dr. Mohammed Azhar Ahmed',
      time: '7am',
      href: '#'
    },
    {
      name: 'Dr. Kuber Saiprabhu Kanade',
      time: '9am',
      href: '#'
    },
    {
      name: 'Dr. Vishal Pasumarthi',
      time: '12pm',
      href: '#'
    }
  ]

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

  ngOnInit(): void {
    const today = new Date();
    this.calendar = {
      month: today.getMonth(),
      monthName: ["January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"][this.calendar.month],
      year: today.getFullYear()
    }
    this.shiftCalendar(0);

    this.getAppointments(new Date().getDate());
  }

  getAppointments(day: number){
    // TODO: implement the process of fetching appointments of that day
    this.selected = new Date(this.calendar.year, this.calendar.month, day);
    // console.log(this.selected);
    this.server.get('/reports/search', {
      [this.userType]: this.userId,
      date: Utilities.formatDate(this.selected)
    })
    .subscribe((data: any) => this.appointments = data);
    // ?' + this.userType + "=" + this.userId + "&date=" + this.formatDate(this.selected)
  }

  isSelected(date: number){
    return this.selected.getFullYear() == this.calendar.year && this.selected.getMonth() == this.calendar.month && this.selected.getDate() == date;
  }
}
