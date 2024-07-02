import { ComponentFixture, TestBed } from '@angular/core/testing';
import {HttpClientTestingModule} from "@angular/common/http/testing";
import {of} from "rxjs";
import {ActivatedRoute} from "@angular/router";
import { UserDataComponent } from './user-data.component';
import {RestApiClientsService} from "../../rest-api-clients.service";

describe('UserDataComponent', () => {
  let component: UserDataComponent;
  let fixture: ComponentFixture<UserDataComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [UserDataComponent],
      imports: [ HttpClientTestingModule ],
      providers: [
        RestApiClientsService,
        {
          provider: ActivatedRoute,
          useValue: {
            params: of({ docType: "c", docNumber: '12345678' })
          }
        }
      ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UserDataComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
