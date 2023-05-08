import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Skills } from '../model/skills';

@Injectable({
  providedIn: 'root'
})
export class SSkillsService {
  expURL = 'http://localhost:8080/skillslab/'


  constructor(private httpClient: HttpClient) { }

  public lista(): Observable<Skills[]> {
    return this.httpClient.get<Skills[]>(this.expURL + 'lista');
  }

  public detail(id: number): Observable<Skills> {
    return this.httpClient.get<Skills>(this.expURL + `detail/${id}`);
  }

  public save(Skills: Skills): Observable<any> {
    return this.httpClient.post<any>(this.expURL + 'create', Skills);
  }

  public update(id: number, Skills: Skills): Observable<any> {
    return this.httpClient.put<any>(this.expURL + `update/${id}`, Skills);
  }
  public delete(id: number): Observable<any> {
    return this.httpClient.delete<any>(this.expURL + `delete/${id}`);
  }

}
