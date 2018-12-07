import { TestBed } from '@angular/core/testing';

import { AdvertismentService } from './advertisment.service';

describe('AdvertismentService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: AdvertismentService = TestBed.get(AdvertismentService);
    expect(service).toBeTruthy();
  });
});
