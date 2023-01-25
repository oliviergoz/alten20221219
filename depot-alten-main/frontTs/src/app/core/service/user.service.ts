import {Injectable} from '@angular/core';
import {EMPTY, Observable, Subject} from 'rxjs';

@Injectable()
export class UserService {

  public user: Subject<any>;

  public userInfo = {
    username: 'Guest'
  };

  constructor() {
    this.user = new Subject();
  }

  getLoginInfo(): Observable<any> {
    return EMPTY;
  }

}
