import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class DemoService {
  constructor() {}

  public sayHello(): string {
    return 'hello world';
  }
}
