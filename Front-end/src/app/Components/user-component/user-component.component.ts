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
  etats = ['Open', 'In Progress', 'solved'];
  tickets: Ticket[] = [];
  panneMap = new Map<number, Panne>();
  equipementMap = new Map<number, Equipement>();
  userId: number = 1; 

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
      etat: ['Pending', Validators.required]
    });
  }

  ngOnInit(): void {
    this.loadPannes();
    this.loadEquipements();
    this.loadUserTickets();
  }

  loadPannes(): void {
    this.panneService.getAllPannes().subscribe(data => {
      this.pannes = data;
      this.pannes.forEach(panne => this.panneMap.set(panne.id, panne));
    });
  }

  loadEquipements(): void {
    this.equipementService.getAllEquipments().subscribe(data => {
      this.equipements = data;
      this.equipements.forEach(equipement => this.equipementMap.set(equipement.id, equipement));
    });
  }

  loadUserTickets(): void {
    this.ticketService.getTicketsByUserId(this.userId).subscribe(
      (data) => {
        this.tickets = data;
      },
      (error) => {
        console.error('Error fetching user tickets:', error);
      }
    );
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
  
      const ticketData: any = {
        description: this.ticketForm.get('description')?.value,
        dateCreation: new Date().toISOString().split('T')[0],
        etat: this.ticketForm.get('etat')?.value,
        utilisateur: { id: this.userId },
        equipement: { id: equipementId },
        panne: { id: panneId }
      };
  
      console.log('Ticket data being sent:', ticketData);
  
      this.ticketService.createTicket(ticketData).subscribe({
        next: (response) => {
          console.log('Ticket created successfully', response);
          this.resetForm();
          this.loadUserTickets();
        },
        error: (error) => {
          console.error('Error creating ticket:', error);
        }
      });
    } else {
      console.error('Form is invalid');
    }
  }

  getPanneDescription(panneId: number | undefined): string {
    return panneId ? (this.panneMap.get(panneId)?.description || 'Unknown') : 'Unknown';
  }

  getEquipementNom(equipementId: number | undefined): string {
    return equipementId ? (this.equipementMap.get(equipementId)?.nom || 'Unknown') : 'Unknown';
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