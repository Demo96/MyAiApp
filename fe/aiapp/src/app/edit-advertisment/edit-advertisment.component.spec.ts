import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EditAdvertismentComponent } from './edit-advertisment.component';

describe('EditAdvertismentComponent', () => {
  let component: EditAdvertismentComponent;
  let fixture: ComponentFixture<EditAdvertismentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EditAdvertismentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EditAdvertismentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
