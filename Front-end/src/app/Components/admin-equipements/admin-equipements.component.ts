// src/app/components/equipement-list/equipement-list.component.ts
import { Component, OnInit } from '@angular/core';
import { EquipementService } from '../../services/equipement.service';
import { Equipement } from 'src/app/models/equipementModel';
@Component({
  selector: 'app-equipement-list',
  templateUrl: './admin-equipements.component.html',
  styleUrls: ['./admin-equipements.component.css']
})
export class EquipementListComponent implements OnInit {
  equipments: Equipement[] = []; 

  constructor(private equipementService: EquipementService) { }

  ngOnInit(): void {
    this.equipementService.getAllEquipments().subscribe(data => {
      this.equipments = data;
    }, error => {
      console.error('Error fetching equipment data', error);
    });
  }
}
