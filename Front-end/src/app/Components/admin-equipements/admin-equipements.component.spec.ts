import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminEquipementsComponent } from './admin-equipements.component';

describe('AdminEquipementsComponent', () => {
  let component: AdminEquipementsComponent;
  let fixture: ComponentFixture<AdminEquipementsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AdminEquipementsComponent]
    });
    fixture = TestBed.createComponent(AdminEquipementsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
