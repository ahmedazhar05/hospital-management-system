import { Component, ViewChild } from '@angular/core';

@Component({
  selector: 'app-gov-scheme',
  templateUrl: './gov-scheme.component.html',
  styleUrls: ['./gov-scheme.component.css']
})
export class GovSchemeComponent {
  dataType = "Health Scheme"

  dlist = [
    {
      name: 'Rajiv Gandhi Jeevandayee yojana',
      description: 'blah blah blah1'
    },
    {
      name: 'Mahatma Jyotiba Phule yojana',
      description: 'blah blah blah3'
    },
    {
      name: 'Ayushman Bharat yojana',
      description: 'blah blah blah4'
    },
    {
      name: 'Awaz Health Insurance Scheme',
      description: 'blah blah blah5'
    },
    {
      name: 'Bhamashah Swasthya Bima Yojana',
      description: 'blah blah blah6'
    },
    {
      name: 'Central Government Health Scheme (CGHS)',
      description: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer lobortis dictum purus, placerat dignissim dolor viverra id. Etiam eget condimentum erat, et posuere libero. Integer tempus, ex at hendrerit tempus, tortor turpis feugiat ante, ac eleifend velit mi pellentesque ante. Sed auctor, arcu ut auctor maximus, felis mauris sagittis felis, consectetur eleifend lectus metus id orci. Ut tincidunt lacinia placerat. Morbi justo nulla, commodo quis consequat sit amet, commodo in elit. Nulla commodo urna tincidunt, fringilla purus ac, varius augue. Vivamus bibendum venenatis rutrum. Aenean ultrices vestibulum enim nec luctus. Aenean quis dolor dignissim, bibendum augue non, pellentesque libero. Donec scelerisque auctor gravida.<br><br>Pellentesque facilisis risus ut venenatis vehicula. Quisque non volutpat orci. Aenean consequat orci et eros placerat, quis pellentesque diam consectetur. Sed eu eros in ligula finibus mollis. Quisque felis nunc, volutpat vitae interdum at, feugiat non enim. Suspendisse semper gravida dui eget rhoncus. Phasellus sodales, leo vitae tristique sagittis, quam odio ornare elit, efficitur fermentum tellus justo eget odio. Nulla gravida feugiat vulputate. Phasellus et ipsum rutrum, eleifend mi eu, rutrum ipsum.'
    }
  ];

  selected: number = this.dlist.length > 0 ? 0 : -1;

  @ViewChild('searchinput')
  search: any = "";

  highlight(){
    this.selected = this.dlist.map(s => s.name).indexOf(this.search.nativeElement.value);
    this.search.nativeElement.value = '';
  }

  @ViewChild('data')
  form: any = "";

  @ViewChild('modalClose')
  modalClose: any;

  addEntry(){
    if(this.form.valid){
      // TODO: send add request to the backend
      console.log(this.form.value);
      this.form.reset();
      this.modalClose.nativeElement.click();
    }
  }
}
