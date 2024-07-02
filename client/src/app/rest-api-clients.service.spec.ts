import { TestBed } from '@angular/core/testing';

import { RestApiClientsService } from './rest-api-clients.service';
import {HttpClientModule} from "@angular/common/http";

describe('RestApiClientsService', () => {
  let service: RestApiClientsService;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientModule],
      providers: [RestApiClientsService]
    });
    service = TestBed.inject(RestApiClientsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
