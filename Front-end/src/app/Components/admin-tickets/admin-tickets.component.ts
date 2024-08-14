import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { TicketService } from 'src/app/services/ticket.service';
import { TechnicianService } from 'src/app/services/technician.service';
import { Ticket } from 'src/app/models/ticketModel';
import { Technicien } from 'src/app/models/technicianModel';

@Component({
  selector: 'app-admin-tickets',
  templateUrl: './admin-tickets.component.html',
  styleUrls: ['./admin-tickets.component.css']
})
export class AdminTicketsComponent implements OnInit {
  tickets: Ticket[] = [];
  technicians: Technicien[] = [];
  assignForm: FormGroup;

  constructor(
    private ticketService: TicketService,
    private technicianService: TechnicianService,
    private fb: FormBuilder
  ) {
    this.assignForm = this.fb.group({
      ticketId: [''],
      technicianId: ['']
    });
  }

  ngOnInit(): void {
    this.loadTickets();
    this.loadTechnicians();
  }

  loadTickets(): void {
    this.ticketService.getTickets().subscribe(data => {
      this.tickets = data;
    });
  }

  loadTechnicians(): void {
    this.technicianService.getTechnicians().subscribe(data => {
      this.technicians = data;
    });
  }

  assignTicket(ticketId: number | undefined): void {
    if (ticketId !== undefined) {
      const technicianId = this.assignForm.get('technicianId')?.value;
      this.ticketService.assignTicket(ticketId, technicianId).subscribe(
        response => {
          alert('Ticket assigned successfully');
          const updatedTicket = this.tickets.find(t => t.id === ticketId);
          if (updatedTicket) {
            updatedTicket.technicienId = technicianId;
          }
          this.assignForm.reset();
        },
        error => {
          alert('Failed to assign ticket');
        }
      );
    }
  }
}