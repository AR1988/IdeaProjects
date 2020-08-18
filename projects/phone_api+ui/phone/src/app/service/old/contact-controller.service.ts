import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable, of} from 'rxjs';
import {Contact} from '../../model/contact';
import {catchError} from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class ContactControllerService {
  private host = 'http://localhost:8080';

  httpOptions = {
    headers: new HttpHeaders({'Content-Type': 'application/json'})
  };

  constructor(private http: HttpClient) {

  }

  getAll(): Observable<Contact[]> {
    const url = `${this.host}/`;
    return this.http.get<Contact[]>(url)
      .pipe(
        catchError(this.handleError<Contact[]>('getAllContacts', []))
      );
  }

  getById(id: number): Observable<Contact> {
    const url = `${this.host}/${id}`;
    return this.http.get<Contact>(url, this.httpOptions);
    // .pipe(catchError(this.handleError<Contact[]>('getById', []))
    // );
  }


  removeById(id: number): Observable<Contact> {
    const url = `${this.host}/${id}`;
    return this.http.delete<Contact>(url, this.httpOptions);
    // .pipe(
    //   catchError(this.handleError<Contact[]>('removeById', []))
    // );
  }

  add(contact: Contact): Observable<any> {
    return this.http.post(this.host, contact, this.httpOptions);
  }

  update(contact: Contact): Observable<any> {
    console.log(contact);
    return this.http.put(this.host, contact, this.httpOptions).pipe(
      catchError(this.handleError<Contact>('addContact')));
  }


  /**
   * Handle Http operation that failed.
   * Let the app continue.
   * @param operation - name of the operation that failed
   * @param result - optional value to return as the observable result
   */
  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      // TODO: send the error to remote logging infrastructure
      console.error(error); // log to console instead
      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }

  getByMethod(method: string, term: string): Observable<Contact[]> {
    if (!term.trim()) {
      // if not search term, return empty hero array.
      return of([]);
    }
    return this.http.get<Contact[]>(`${this.host}/search/?method=${method}&&name=${term}`).pipe(
      catchError(this.handleError<Contact[]>('searchHeroes', []))
    );
  }
}
