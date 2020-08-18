import {Component, OnInit} from '@angular/core';
import {ContactService} from '../service/contact.service';

@Component({
  selector: 'app-contact-item',
  templateUrl: './contact-item.component.html',
  styleUrls: ['./contact-item.component.css']
})
export class ContactItemComponent implements OnInit {
  constructor(public contactService: ContactService) {
  }

  ngOnInit(): void {
  }

  onClickRemove(id: number) {
    this.contactService.remove(id);
  }

}
