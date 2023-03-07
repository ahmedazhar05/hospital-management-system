import { Component, Input, OnInit } from '@angular/core';

export type Carousel = {
  image: string;
  title?: string;
  description?: string;
};

@Component({
  selector: 'app-carousel',
  templateUrl: './carousel.component.html',
  styles: [`
  .carousel-caption > * {
    text-shadow: 0 0 10px white;
  }
  `]
})
export class CarouselComponent implements OnInit {
  
  @Input() carousels: Carousel[] = [];
  
  ngOnInit(): void {
    if(this.carousels.length == 0){
      this.carousels = [
        {
          image: "https://www.rubyhospital.com/images/departments/general-medicine.jpg",
        },
        {
          image: "https://www.rubyhospital.com/images/departments/interventional-cardiology.jpg",
          description: "All the hospital facilities at your fingertips."
        },
        {
          image: "https://thumbs.dreamstime.com/b/doctor-office-banner-background-healthcare-hospital-background-concept-87323968.jpg",
          title: "Our Doctors"
        }
      ];
    }
  }

}
