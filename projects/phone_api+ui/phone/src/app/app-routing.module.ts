import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';

import {ContactItemComponent} from './contact-item/contact-item.component';
import {ShowContactComponent} from './show-contact/show-contact.component';

const routes: Routes = [
  {path: '', redirectTo: '/items', pathMatch: 'full'},
  {path: 'items', component: ContactItemComponent},
  {path: 'detail/:id', component: ShowContactComponent}
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
