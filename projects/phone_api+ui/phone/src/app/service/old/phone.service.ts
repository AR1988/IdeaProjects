// import {Injectable} from '@angular/core';
// import {Phone} from "../model/phone";
// import {Observable} from "rxjs";
// import {PhoneControllerService} from "./phone-controller.service";
//
// @Injectable({
//   providedIn: 'root'
// })
// export class PhoneService {
//   phones: Phone[];
//   phone: Phone;
//
//  private contactId: number;
//
//   constructor(private controller: PhoneControllerService) {
//   }
//
//   setContactIdAndGetAllPhones(contactId: number): void {
//     this.contactId = contactId;
//     this.getAll();
//   }
//
//   add(phone: Phone): void {
//     this.controller.add(phone)
//       // .subscribe(_ => this.getAll(contactId),
//       .subscribe(_ => this.getAll(),
//         error => console.log(error));
//   }
//
//
//   getAll(): void {
//     this.controller.getAll(this.contactId).subscribe(value => this.phones = value,
//       error => console.log(error));
//   }
//
//   remove(phoneId: number) {
//     // this.controller.removeById(contactId).subscribe(value => this.getAll(contactId),
//     this.controller.removeById(phoneId).subscribe(() => this.getAll(),
//       error => console.log(error)
//     );
//   }
//
//   editPhone(phoneToEdit: Phone) {
//     this.controller.update(phoneToEdit)
//       .subscribe(() => this.getAll());
//   }
//
//   getById(phoneId: number): Observable<Phone> {
//     return this.controller.getById(phoneId);
//   }
// }
