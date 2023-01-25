import {Component, OnInit} from '@angular/core';
import {environment} from '@owlink-env/environment';

@Component({
  selector: 'app-footer',
  templateUrl: './footer.component.html',
  styleUrls: ['./footer.component.css']
})
export class FooterComponent implements OnInit {

  public appVersion: string = environment.version;

  constructor() { }

  ngOnInit() {
  }

}
