import { TestBed } from '@angular/core/testing';

import { InterneGuardService } from './interne-guard.service';

describe('InterneGuardService', () => {
  let service: InterneGuardService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(InterneGuardService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
