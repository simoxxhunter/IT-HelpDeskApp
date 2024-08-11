import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { EquipementService } from 'src/app/services/equipement.service';
import { Equipement } from 'src/app/models/equipementModel';
import * as bootstrap from 'bootstrap';

@Component({
  selector: 'app-admin-equipments',
  templateUrl: './admin-equipements.component.html',
  styleUrls: ['./admin-equipements.component.css']
})
export class AdminEquipmentsComponent implements OnInit {
  equipments: Equipement[] = [];
  equipmentForm: FormGroup;
  isEditing = false;
  currentEquipmentId: number | null = null;

  constructor(
    private fb: FormBuilder,
    private equipmentService: EquipementService
  ) {
    this.equipmentForm = this.fb.group({
      nom: ['', Validators.required],
      type: ['', Validators.required],
      etat: ['', Validators.required]
    });
  }

  ngOnInit(): void {
    this.loadEquipments();
  }

  loadEquipments(): void {
    this.equipmentService.getAllEquipments().subscribe(data => {
      this.equipments = data;
    });
  }

  openAddModal(): void {
    this.isEditing = false;
    this.currentEquipmentId = null;
    this.equipmentForm.reset();
    const addModal = new bootstrap.Modal(document.getElementById('addModal')!);
    addModal.show();
  }

  openEditModal(equipment: Equipement): void {
    this.isEditing = true;
    this.currentEquipmentId = equipment.id;
    this.equipmentForm.patchValue(equipment);
    const editModal = new bootstrap.Modal(document.getElementById('editModal')!);
    editModal.show();
  }

  saveEquipment(): void {
    if (this.equipmentForm.valid) {
      this.equipmentService.addEquipment(this.equipmentForm.value)
        .subscribe(() => {
          this.loadEquipments();
          this.resetForm();
        });
    }
  }

  updateEquipment(): void {
    if (this.equipmentForm.valid && this.currentEquipmentId) {
      this.equipmentService.updateEquipment(this.currentEquipmentId, this.equipmentForm.value)
        .subscribe(() => {
          this.loadEquipments();
          this.resetForm();
        });
    }
  }

  deleteEquipment(id: number): void {
    if (confirm('Are you sure you want to delete this equipment?')) {
      this.equipmentService.deleteEquipment(id).subscribe(() => {
        this.loadEquipments();
      });
    }
  }

  resetForm(): void {
    this.equipmentForm.reset();
    this.isEditing = false;
    this.currentEquipmentId = null;
    
    const addModalElement = document.getElementById('addModal');
    const editModalElement = document.getElementById('editModal');
    
    if (addModalElement) {
      const addModal = bootstrap.Modal.getInstance(addModalElement);
      if (addModal) {
        addModal.hide();
      }
    }
    
    if (editModalElement) {
      const editModal = bootstrap.Modal.getInstance(editModalElement);
      if (editModal) {
        editModal.hide();
      }
    }

    const backdrop = document.querySelector('.modal-backdrop');
    if (backdrop) {
      backdrop.remove();
    }
  }
}
