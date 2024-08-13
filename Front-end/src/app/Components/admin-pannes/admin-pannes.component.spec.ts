import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminPannesComponent } from './admin-pannes.component';

describe('AdminPannesComponent', () => {
  let component: AdminPannesComponent;
  let fixture: ComponentFixture<AdminPannesComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AdminPannesComponent]
    });
    fixture = TestBed.createComponent(AdminPannesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
