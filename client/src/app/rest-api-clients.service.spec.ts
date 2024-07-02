import { TestBed } from '@angular/core/testing';

import { RestApiClientsService } from './rest-api-clients.service';

describe('RestApiClientsService', () => {
  let service: RestApiClientsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RestApiClientsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
