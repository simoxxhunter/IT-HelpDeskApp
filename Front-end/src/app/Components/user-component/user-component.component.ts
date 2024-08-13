import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import * as bootstrap from 'bootstrap';
import { TicketService } from 'src/app/services/ticket.service';

@Component({
  selector: 'app-user-component',
  templateUrl: './user-component.component.html',
  styleUrls: ['./user-component.component.css']
})
export class UserComponent implements OnInit {
  ticketForm: FormGroup;

  constructor(
    private fb: FormBuilder,
    private ticketService: TicketService
  ) {
    this.ticketForm = this.fb.group({
      description: ['', Validators.required],
      etat: ['', Validators.required]
    });
  }

  ngOnInit(): void {}

  openAddModal(): void {
    this.ticketForm.reset();
    const addModal = new bootstrap.Modal(document.getElementById('addTicketModal')!);
    addModal.show();
  }

  saveTicket(): void {
    if (this.ticketForm.valid) {
      this.ticketService.createTicket(this.ticketForm.value).subscribe({
        next: () => {
          this.resetForm();
        },
        error: (err) => {
          alert('Error adding ticket. Please try again.');
        }
      });
    } else {
      alert('Please fill out all required fields');
    }
  }

  resetForm(): void {
    this.ticketForm.reset();
    const addModalElement = document.getElementById('addTicketModal');
    if (addModalElement) {
      const addModal = bootstrap.Modal.getInstance(addModalElement);
      if (addModal) {
        addModal.hide();
      }
    }
  }
}
