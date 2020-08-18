import {Component, Input, OnInit} from '@angular/core';
import {Phone} from '../model/phone';
import {PhoneService} from '../service/phone.service';

@Component({
  selector: 'app-edit-phone-form',
  templateUrl: './edit-phone-form.component.html',
  styleUrls: ['./edit-phone-form.component.css']
})
export class EditPhoneFormComponent implements OnInit {
  @Input()
  phone: Phone;

  editState: boolean;
  editBtnName: string;
  private contactId: number;


  constructor(private phoneService: PhoneService) {
  }

  ngOnInit(): void {
    this.editBtnName = 'Edit';
    this.editState = true;
    this.contactId = this.phone.contactId;
  }

  onClickRemove(id: number) {
    this.phoneService.remove(id);
  }

  statSwitch() {
    this.editState = !this.editState;
    if (this.editState) {
      this.editBtnName = 'Edit';
      this.phone.contactId = this.contactId;
      this.phoneService.edit(this.phone);
    } else {
      this.editBtnName = 'Save';
    }
  }
}
