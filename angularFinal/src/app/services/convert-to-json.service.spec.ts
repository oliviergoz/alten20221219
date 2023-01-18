import { TestBed } from '@angular/core/testing';

import { ConvertToJsonService } from './convert-to-json.service';

describe('ConvertToJsonService', () => {
  let service: ConvertToJsonService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ConvertToJsonService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
