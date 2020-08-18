import {Component, Input, OnInit} from '@angular/core';

import {Contact} from '../model/contact';
import {ContactService} from '../service/contact.service';

import {Observable, Subject} from 'rxjs';
import {debounceTime, switchMap} from 'rxjs/operators';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {

  contacts$: Observable<Contact[]>;
  private searchTerms = new Subject<string>();
  private searchType: string;
  @Input() searchString: string;
  reloaded: boolean;

  constructor(private contactService: ContactService) {
  }

  // Push a search term into the observable stream.
  search(term: string): void {
    this.searchTerms.next(term);
  }

  ngOnInit(): void {
    this.reloaded = false;
    this.contacts$ = this.searchTerms.pipe(
      // wait 300ms after each keystroke before considering the term
      debounceTime(200),

      // ignore new term if same as previous term
      // distinctUntilChanged(),

      // switch to new search observable each time the term changes
      switchMap((term: string) => this.contactService.getByMethod(this.searchType, term))
    );
  }

  onReload() {
    this.search('');
    this.searchString = '';
    this.reloaded = true;
  }

  searchTypeChange(value: string) {
    this.searchType = value;
    this.searchTerms.next(this.searchString);
  }
}
