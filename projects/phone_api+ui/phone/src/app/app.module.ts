import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {FormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';

import {ContactFormComponent} from './contact-form/contact-form.component';
import {ContactItemComponent} from './contact-item/contact-item.component';
import {ShowContactComponent} from './show-contact/show-contact.component';
import { NavComponent } from './nav/nav.component';
import {SearchComponent} from './search/search.component';
import { EditPhoneFormComponent } from './edit-phone-form/edit-phone-form.component';
import { AddModalComponent } from './add-modal/add-modal.component';
import { AddressFormComponent } from './address-form/address-form.component';
import { AddPhoneFormComponent } from './add-phone-form/add-phone-form.component';


@NgModule({
  declarations: [
    AppComponent,
    ContactFormComponent,
    ContactItemComponent,
    ShowContactComponent,
    NavComponent,
    SearchComponent,
    EditPhoneFormComponent,
    AddModalComponent,
    AddressFormComponent,
    AddPhoneFormComponent,
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    AppRoutingModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
