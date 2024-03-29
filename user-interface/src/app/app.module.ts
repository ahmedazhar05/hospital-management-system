import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { BookAppointmentComponent } from './book-appointment/book-appointment.component';
import { SchemeComponent } from './scheme/scheme.component';
import { SignupComponent } from './signup/signup.component';
import { PrescriptionComponent } from './prescription/prescription.component';
import { CalendarComponent } from './calendar/calendar.component';
import { CarouselComponent } from './carousel/carousel.component';
import { MainComponent } from './main/main.component';
import { HttpClientModule } from '@angular/common/http';
import { DashboardComponent } from './dashboard/dashboard.component';
import { LogoutComponent } from './logout/logout.component';
import { VerifyComponent } from './verify/verify.component';
import { ToastComponent } from './toast/toast.component';
import { PrescriptionListComponent } from './prescription-list/prescription-list.component';
import { ReportsListComponent } from './reports-list/reports-list.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    BookAppointmentComponent,
    SchemeComponent,
    SignupComponent,
    PrescriptionComponent,
    CalendarComponent,
    CarouselComponent,
    MainComponent,
    DashboardComponent,
    LogoutComponent,
    VerifyComponent,
    ToastComponent,
    PrescriptionListComponent,
    ReportsListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
