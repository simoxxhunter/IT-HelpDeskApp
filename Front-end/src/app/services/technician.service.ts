import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TechnicianService {
  private baseUrl = 'http://localhost:8083/technicians'; 

  constructor(private http: HttpClient) { }

  getTechnicians(): Observable<any[]> {
    return this.http.get<any[]>(`${this.baseUrl}`);
  }
}
