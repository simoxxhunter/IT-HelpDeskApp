import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminEquipmentsComponent } from './admin-equipements.component';

describe('AdminEquipementsComponent', () => {
  let component: AdminEquipmentsComponent;
  let fixture: ComponentFixture<AdminEquipmentsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AdminEquipmentsComponent]
    });
    fixture = TestBed.createComponent(AdminEquipmentsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
