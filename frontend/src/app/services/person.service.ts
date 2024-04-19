import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Person } from '../model/person.model';
import { PersonUpdated } from '../model/person.model-upd';


@Injectable({
  providedIn: 'root'
})
export class PersonService {
  private httpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });
  private URL_API: string = "http://localhost:9092/api";

  constructor(private http: HttpClient) { }

  listarPerson(): Observable<Person[]> {
    return this.http.get<Person[]>(
      this.URL_API + '/person'
    );
  }

  listarPersonUpd(): Observable<PersonUpdated[]> {
    return this.http.get<PersonUpdated[]>(
      this.URL_API + '/person-upd'
    );
  }

}
