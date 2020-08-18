import {Injectable} from '@angular/core';
import {Phone} from '../model/phone';
import {Observable} from 'rxjs';

import {HttpClient, HttpHeaders} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class PhoneService {

  phones: Observable<Phone[]>;

  private contactId: number;
  private host = 'http://localhost:8080/';

  httpOptions = {
    headers: new HttpHeaders({'Content-Type': 'application/json'})
  };

  constructor(private http: HttpClient) {
  }

  private reload(): void {
    const url = `${this.host}${this.contactId}/phone/`;
    this.phones = this.http.get<Phone[]>(url);
  }

  getAll(contactId: number): Observable<Phone[]> {
    this.contactId = contactId;
    if (!this.phones) {
      this.reload();
    }
    return this.phones;
  }

  // getById(id: number): Observable<Phone> {
  //   const url = `${this.host}${id}`;
  //   return this.http.get<Phone>(url, this.httpOptions);
  // }

  remove(id: number): void {
    this.http.delete<any>(`${this.host}phone/${id}`, this.httpOptions)
      .subscribe(_ => this.reload());
    this.reload();
  }

  add(phone: Phone): void {
    this.http.post(`${this.host}phone/`, phone, this.httpOptions)
      .subscribe(_ => this.reload());
    this.reload();
  }

  edit(phone: Phone): void {
    this.http.put(`${this.host}phone/`, phone, this.httpOptions)
      .subscribe(_ => this.reload());
  }
}
