import {Component, EventEmitter, Input, OnDestroy, OnInit, Output} from '@angular/core';
import {Phone} from '../model/phone';
import {PhoneService} from '../service/phone.service';
import {ActivatedRoute} from '@angular/router';

@Component({
  selector: 'app-add-phone-form',
  templateUrl: './add-phone-form.component.html',
  styleUrls: ['./add-phone-form.component.css']
})
export class AddPhoneFormComponent implements OnInit, OnDestroy {
  @Input()
  phone: Phone;
  contactId: number;
  @Output()
  cancelByEditForm: EventEmitter<boolean> = new EventEmitter();

  constructor(private phoneService: PhoneService,
              private route: ActivatedRoute) {
  }

  ngOnInit(): void {
    this.contactId = +this.route.snapshot.paramMap.get('id');
    this.phone = new Phone();
  }


  onClickSave() {
    this.phone.contactId = this.contactId;
    this.phoneService.add(this.phone);
    this.onClickCancel();
  }

  onClickCancel() {
    this.cancelByEditForm.emit();
    this.ngOnDestroy();
  }
  // TODO
  ngOnDestroy(): void {
  }
}
