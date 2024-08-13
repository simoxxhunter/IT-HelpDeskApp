import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Panne } from '../models/panneModel';

@Injectable({
  providedIn: 'root'
})
export class PanneService {
  private apiUrl = 'http://localhost:8083/panne'; 

  constructor(private http: HttpClient) { }

  getAllPannes(): Observable<Panne[]> {
    return this.http.get<Panne[]>(`${this.apiUrl}/ShowAllPannes`);
  }

  addPanne(panne: Panne): Observable<Panne> {
    return this.http.post<Panne>(`${this.apiUrl}/add`, panne);
  }

  updatePanne(id: number, panne: Partial<Panne>): Observable<any> {
    return this.http.put(`${this.apiUrl}/Modify/${id}`, panne);
  }
  

  deletePanne(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/Delete/${id}`);
  }
}
