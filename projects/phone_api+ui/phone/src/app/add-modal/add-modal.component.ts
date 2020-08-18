import {Component, OnInit} from '@angular/core';
import {Contact} from '../model/contact';
import {ContactService} from '../service/contact.service';

@Component({
  selector: 'app-add-modal',
  templateUrl: './add-modal.component.html',
  styleUrls: ['./add-modal.component.css']
})
export class AddModalComponent implements OnInit {

  contactToAdd: Contact;

  constructor(private service: ContactService) {
  }

  ngOnInit(): void {
    this.contactToAdd = new Contact();
  }

  onAdd() {
    this.service.add(this.contactToAdd);
    this.ngOnInit();
  }


  onClose(): void {
    this.ngOnInit();
  }
}
