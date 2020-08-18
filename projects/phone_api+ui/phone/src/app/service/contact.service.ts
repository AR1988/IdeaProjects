import {Injectable} from '@angular/core';
import {Contact} from '../model/contact';
import {Observable, of} from 'rxjs';
import {HttpClient, HttpHeaders} from '@angular/common/http';

@Injectable()
export class ContactService {
  contacts: Observable<Contact[]>;
  // contact: Contact;

  private host = 'http://localhost:8080/';

  httpOptions = {
    headers: new HttpHeaders({'Content-Type': 'application/json'})
  };

  constructor(private http: HttpClient) {
  }

  private reload(): void {
    this.contacts = this.http.get<Contact[]>(this.host);
  }

  getAll(): Observable<Contact[]> {
    if (!this.contacts) {
      this.reload();
    }
    return this.contacts;
  }

  getById(id: number): Observable<Contact> {
    const url = `${this.host}/${id}`;
    return this.http.get<Contact>(url, this.httpOptions);
  }


  remove(id: number): void {
    const url = `${this.host}/${id}`;
    this.http.delete<Contact>(url, this.httpOptions)
      .subscribe(_ => this.reload());
  }

  add(contact: Contact): void {
    this.http.post(this.host, contact, this.httpOptions)
      .subscribe(_ => this.reload());
  }

  edit(contact: Contact): void {
    this.http.put(this.host, contact, this.httpOptions)
      .subscribe(_ => this.reload());
  }

  getByMethod(method: string, term: string): Observable<Contact[]> {
    if (!term.trim()) {
      return of([]);
    }
    return this.http.get<Contact[]>(`${this.host}/search/?method=${method}&&name=${term}`);
  }
}
