import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import * as bootstrap from 'bootstrap';
import { Panne } from 'src/app/models/panneModel';
import { PanneService } from 'src/app/services/panne.service';

@Component({
  selector: 'app-admin-pannes',
  templateUrl: './admin-pannes.component.html',
  styleUrls: ['./admin-pannes.component.css']
})
export class AdminPannesComponent implements OnInit {
  pannes: Panne[] = [];
  panneForm: FormGroup;
  isEditing = false;
  currentPanneId: number | null = null;

  constructor(
    private fb: FormBuilder,
    private panneService: PanneService
  ) {
    this.panneForm = this.fb.group({
      description: ['', Validators.required],
      etat: ['', Validators.required]
    });
  }

  ngOnInit(): void {
    this.loadPannes();
  }

  loadPannes(): void {
    this.panneService.getAllPannes().subscribe(data => {
      this.pannes = data;
    });
  }

  openAddModal(): void {
    this.isEditing = false;
    this.currentPanneId = null;
    this.panneForm.reset();
    const addModal = new bootstrap.Modal(document.getElementById('addModal')!);
    addModal.show();
  }

  openEditModal(panne: Panne): void {
    this.isEditing = true;
    this.currentPanneId = panne.id;
    this.panneForm.patchValue(panne);
    const editModal = new bootstrap.Modal(document.getElementById('editModal')!);
    editModal.show();
  }
  

  savePanne(): void {
    if (this.panneForm.valid) {
      this.panneService.addPanne(this.panneForm.value)
        .subscribe(() => {
          this.loadPannes();
          this.resetForm();
        });
    }
  }
 
  
  updatePanne(): void {
    if (this.panneForm.valid && this.currentPanneId) {
      const updatedPanne = { ...this.panneForm.value };  
      this.panneService.updatePanne(this.currentPanneId, updatedPanne).subscribe({
        next: () => {
          this.loadPannes();
          this.resetForm();
          console.log('Panne updated successfully');
        },
        error: (err) => {
          alert('Error updating panne. Please try again.');
        }
      });
    } else {
      alert('Please fill out all required fields');
    }
  }
  
 
  deletePanne(id: number): void {
    if (confirm('Are you sure you want to delete this panne?')) {
      this.panneService.deletePanne(id).subscribe(() => {
        this.loadPannes();
      });
    }
  }

  resetForm(): void {
    this.panneForm.reset();
    this.isEditing = false;
    this.currentPanneId = null;
    
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
