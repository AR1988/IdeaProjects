import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {Contact} from '../model/contact';

@Component({
  selector: 'app-contact-form',
  templateUrl: './contact-form.component.html',
  styleUrls: ['./contact-form.component.css']
})
export class ContactFormComponent implements OnInit {

  constructor() {
  }


  contactIn: Contact;
  @Output()
  contact: EventEmitter<Contact> = new EventEmitter();

  ngOnInit(): void {
    this.contactIn = new Contact();
    this.contact.emit(this.contactIn);
  }
}



