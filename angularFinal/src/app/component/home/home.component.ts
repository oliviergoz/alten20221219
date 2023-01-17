import { DemoService } from './../../services/demo.service';
import { Component } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
})
export class HomeComponent {
  constructor(private demoService: DemoService) {
    console.log(this.demoService.sayHello());
  }
}
