import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Root } from '../model/root.model';
import { RootUpdated } from '../model/root.model-upd';

@Injectable({
  providedIn: 'root'
})
export class RootService {

  private URL_API: string = "http://localhost:9092/api";

  constructor(private http: HttpClient) { }

  listarRoot(): Observable<Root[]> {
    return this.http.get<Root[]>(
      this.URL_API + '/root'
    );
  }

  listarRootUpd(): Observable<RootUpdated[]> {
    return this.http.get<RootUpdated[]>(
      this.URL_API + '/root-upd'
    );
  }

}
