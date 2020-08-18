import {Component, Input, OnInit} from '@angular/core';
import {Contact} from '../model/contact';
import {ActivatedRoute} from '@angular/router';
import {ContactService} from '../service/contact.service';
import {PhoneService} from '../service/phone.service';
import {Phone} from '../model/phone';


@Component({
  selector: 'app-show-contact',
  templateUrl: './show-contact.component.html',
  styleUrls: ['./show-contact.component.css']
})
export class ShowContactComponent implements OnInit {
  @Input()
  contact: Contact;
  contactId: number;
  phones: Phone[];
  showStat: boolean;
  nameBtnEdit: string;
  displayNewForm: boolean;

  constructor(private route: ActivatedRoute,
              private contactService: ContactService,
              public phoneService: PhoneService
  ) {
  }


  ngOnInit() {
    this.contactId = +this.route.snapshot.paramMap.get('id');
    this.getContact();
    this.showStat = true;
    this.nameBtnEdit = 'Edit';
  }

  onAddPhoneForm() {
    this.displayNewForm = !this.displayNewForm;
  }

  getContact(): void {
    this.contactService.getById(this.contactId).subscribe(value => this.contact = value);
  }

  statSwitch() {
    this.showStat = !this.showStat;
    if (this.showStat) {
      this.nameBtnEdit = 'Edit';
      this.contactService.edit(this.contact);
    } else {
      this.nameBtnEdit = 'Save';
    }
  }
}
