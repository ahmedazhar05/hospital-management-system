import { Component, Input, OnInit } from '@angular/core';

export type Carousel = {
  image: string;
  title?: string;
  description?: string;
};

@Component({
  selector: 'app-carousel',
  templateUrl: './carousel.component.html'
})
export class CarouselComponent implements OnInit {
  
  @Input() carousels: Carousel[] = [];
  
  ngOnInit(): void {
    if(this.carousels.length == 0){
      this.carousels = [
        {
          image: "https://png.pngtree.com/thumb_back/fh260/back_pic/02/50/63/71577e1cf59d802.jpg",
          title: "Doctor",
          description: "Some representative placeholder content for the first slide."
        },
        {
          image: "https://png.pngtree.com/thumb_back/fh260/back_pic/03/51/70/585791ffa147edc.jpg",
          description: "Some representative placeholder content for the second slide."
        },
        {
          image: "https://png.pngtree.com/thumb_back/fh260/back_pic/03/51/70/585791ffa147edc.jpg",
          title: "Patient"
        }
      ];
    }
  }

}
