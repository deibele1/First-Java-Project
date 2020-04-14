import { TestBed } from '@angular/core/testing';

import { EventModelService } from './app-services.service';

describe('EventModelService', () => {
  let service: EventModelService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(EventModelService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
