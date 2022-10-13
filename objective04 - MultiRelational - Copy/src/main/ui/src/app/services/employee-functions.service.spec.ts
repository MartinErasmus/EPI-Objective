import { TestBed } from '@angular/core/testing';

import { EmployeeFunctionsService } from './employee-functions.service';

describe('EmployeeFunctionsService', () => {
  let service: EmployeeFunctionsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(EmployeeFunctionsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
