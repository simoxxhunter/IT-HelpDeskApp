// src/app/services/equipement.service.ts
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Equipement } from '../models/equipementModel';

@Injectable({
  providedIn: 'root'
})
export class EquipementService {

  private apiUrl = `http://localhost:8083/equipements/ShowAllequipements`;

  constructor(private http: HttpClient) { }

  getAllEquipments(): Observable<Equipement[]> { 
    return this.http.get<Equipement[]>(this.apiUrl);
  }
}
