// import { Injectable } from '@angular/core';
// import {HttpClient, HttpHeaders} from "@angular/common/http";
// import {Observable, of} from "rxjs";
// import {Phone} from "../model/phone";
// import {catchError} from "rxjs/operators";
//
// @Injectable({
//   providedIn: 'root'
// })
// export class PhoneControllerService {
//
//   private serverUrl = 'http://localhost:8080/phone/';
//
//   httpOptions = {
//     headers: new HttpHeaders({'Content-Type': 'application/json'})
//   };
//
//   constructor(private http: HttpClient) {
//
//   }
//
//   getAll(contactId: number ): Observable<Phone[]> {
//     const url: string = `http://localhost:8080/${contactId}/phone/`
//     return this.http.get<Phone[]>(url);
//       // .pipe(
//       //   catchError(this.handleError<Phone[]>('getAllContacts', []))
//       // );
//   }
//
//   getById(id: number): Observable<Phone> {
//     const url: string = `${this.serverUrl}${id}`;
//     return this.http.get<Phone>(url, this.httpOptions);
//     // .pipe(catchError(this.handleError<Phone[]>('getById', []))
//     // );
//   }
//
//
//   removeById(id: number): Observable<Phone> {
//     const url = `${this.serverUrl}${id}`;
//     return this.http.delete<Phone>(url, this.httpOptions);
//     // .pipe(
//     //   catchError(this.handleError<Phone[]>('removeById', []))
//     // );
//   }
//
//   add(phone: Phone): Observable<any> {
//     console.log(phone);
//     return this.http.post(this.serverUrl, phone, this.httpOptions);
//     // .pipe(
//     // catchError(this.handleError<Phone>('addContact')));
//   }
//
//   update(phone: Phone): Observable<any> {
//     console.log(phone);
//     return this.http.put(this.serverUrl, phone, this.httpOptions).pipe(
//       catchError(this.handleError<Phone>('addContact')));
//   }
//
//
//   /**
//    * Handle Http operation that failed.
//    * Let the app continue.
//    * @param operation - name of the operation that failed
//    * @param result - optional value to return as the observable result
//    */
//   private handleError<T>(operation = 'operation', result?: T) {
//     return (error: any): Observable<T> => {
//       // TODO: send the error to remote logging infrastructure
//       console.error(error); // log to console instead
//       // Let the app keep running by returning an empty result.
//       return of(result as T);
//     };
//   }
// }
