import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import * as bootstrap from 'bootstrap';
import { Ticket } from 'src/app/models/ticketModel';
import { TicketService } from 'src/app/services/ticket.service';
import { PanneService } from 'src/app/services/panne.service';
import { EquipementService } from 'src/app/services/equipement.service';
import { Panne } from 'src/app/models/panneModel';
import { Equipement } from 'src/app/models/equipementModel';

@Component({
  selector: 'app-user-component',
  templateUrl: './user-component.component.html',
  styleUrls: ['./user-component.component.css']
})
export class UserComponent implements OnInit {
  ticketForm: FormGroup;
  pannes: Panne[] = [];
  equipements: Equipement[] = [];
  etats = ['Open', 'In Progress', 'Closed']; // Add status options
  currentUserId: any;

  constructor(
    private fb: FormBuilder,
    private ticketService: TicketService,
    private panneService: PanneService,
    private equipementService: EquipementService
  ) {
    this.ticketForm = this.fb.group({
      description: ['', Validators.required],
      dateCreation: [{ value: new Date().toISOString().split('T')[0], disabled: true }, Validators.required],
      panneId: ['', Validators.required],
      equipementId: ['', Validators.required],
      etat: ['Pending', Validators.required] // Default value
    });
    
  }

  ngOnInit(): void {
    this.loadPannes();
    this.loadEquipements();
  }

  loadPannes(): void {
    this.panneService.getAllPannes().subscribe(data => {
      this.pannes = data;
    });
  }

  loadEquipements(): void {
    this.equipementService.getAllEquipments().subscribe(data => {
      this.equipements = data;
    });
  }

  openAddModal(): void {
    this.ticketForm.reset({
      dateCreation: new Date().toISOString().split('T')[0],
    });
    const addModal = new bootstrap.Modal(document.getElementById('addModal')!);
    addModal.show();
  }


  saveTicket(): void {
    if (this.ticketForm.valid) {
      const equipementId = this.ticketForm.get('equipementId')?.value;
      const panneId = this.ticketForm.get('panneId')?.value;
  
      const utilisateurId = 1; 
  
      const ticketData = {
        description: this.ticketForm.get('description')?.value,
        dateCreation: new Date, 
        etat: this.ticketForm.get('etat')?.value,
        equipement: { id: equipementId },
        panne: { id: panneId },
        utilisateur: { id: utilisateurId } 
      };
  
      this.ticketService.createTicket(ticketData).subscribe({
        next: (response) => {
          console.log('Ticket created successfully', response);
          this.resetForm();
        },
        error: (error) => {
          console.error('Error creating ticket:', error);
        }
      });
    } else {
      console.error('Form is invalid');
    }
  }
  
  


  
  
  
  

  resetForm(): void {
    this.ticketForm.reset();
    const addModalElement = document.getElementById('addModal');
    if (addModalElement) {
      const addModal = bootstrap.Modal.getInstance(addModalElement);
      if (addModal) {
        addModal.hide();
      }
    }
  }
}
