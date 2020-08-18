import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Address} from '../model/address';

@Component({
  selector: 'app-address-form',
  templateUrl: './address-form.component.html',
  styleUrls: ['./address-form.component.css']
})
export class AddressFormComponent implements OnInit {
  @Input()
  address: Address;

  @Output()
  removeAddress: EventEmitter<any> = new EventEmitter();

  editState: boolean;
  editBtnName: string;

  constructor() {
  }

  ngOnInit(): void {
    this.editState = true;
    this.editBtnName = 'Edit';
    this.address = new Address();
  }

  onClickRemove() {
    this.removeAddress.emit();
  }

  onClickEdit() {
    this.editState = false;
    this.editBtnName = 'Save';
  }

  statSwitch() {
    this.editState = !this.editState;
    if (this.editState) {
      this.editBtnName = 'Edit';
      // this.contactService.editContact(this.contact);
    } else {
      this.editBtnName = 'Save';
    }
  }

}
