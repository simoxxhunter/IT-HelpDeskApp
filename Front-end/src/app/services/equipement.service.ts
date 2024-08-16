import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Equipement } from '../models/equipementModel';

@Injectable({
  providedIn: 'root'
})
export class EquipementService {

  private apiUrl = `http://localhost:8083/equipements`;

  constructor(private http: HttpClient) { }

  getAllEquipments(): Observable<Equipement[]> { 
    return this.http.get<Equipement[]>(this.apiUrl + '/ShowAllequipements');
  }

  addEquipment(equipement: Equipement): Observable<Equipement> {
    return this.http.post<Equipement>(this.apiUrl + '/ADMIN/Createequipement', equipement);
  }

  updateEquipment(id: number, equipement: Equipement): Observable<Equipement> {
    return this.http.put<Equipement>(`${this.apiUrl}/ADMIN/Modify/${id}`, equipement);
  }

  deleteEquipment(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/ADMIN/Delete/${id}`);
  }
}
