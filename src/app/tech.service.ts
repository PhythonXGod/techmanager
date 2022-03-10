import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Tech } from './tech';
import { environment } from 'src/environments/environment';

//Angular crud implements knapi kautko te sataisiju
@Injectable({
  providedIn: 'root'
})
export class TechService {
  private apiServerUrl = environment.apiBaseUrl;

  constructor(private http: HttpClient) {}

  public getTechs(): Observable<Tech[]> {
    return this.http.get<Tech[]>(`${this.apiServerUrl}/tech/all`);
  }

  public addTech(tech: Tech): Observable<Tech> {
    return this.http.post<Tech>(`${this.apiServerUrl}/tech/add`, tech);
  }

  public updateTech(tech: Tech): Observable<Tech> {
    return this.http.put<Tech>(`${this.apiServerUrl}/tech/update`, tech);
  }

  public deleteTech(techId: number): Observable<void> {
    return this.http.delete<void>(`${this.apiServerUrl}/tech/delete/${techId}`);
  }
}
