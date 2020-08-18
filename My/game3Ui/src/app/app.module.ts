import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {RouterModule} from '@angular/router';
import {AppRoutingModule} from './app-routing.module';
import {HttpClientModule} from '@angular/common/http';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';

import {AppComponent} from './app.component';
import {StartComponent} from './start/start.component';
import {NewGameComponent} from './new-game/new-game.component';
import {QuestionsFormComponent} from './qustions-form/questions-form.component';
import {AllThemesComponent} from './all-themes/all-themes.component';
import {AddFormComponent} from './qustion_and_answer_forms/add-form/add-form.component';
import {EditFormComponent} from './qustion_and_answer_forms/edit-form/edit-form.component';
import {AddAnswerFormComponent} from './qustion_and_answer_forms/add-answer-form/add-answer-form.component';
import {EditAnswerFormComponent} from './qustion_and_answer_forms/edit-answer-form/edit-answer-form.component';
import { GameComponent } from './game/game/game.component';
import { GamaAnswerComponent } from './game/gama-answer/gama-answer.component';


@NgModule({
  declarations: [
    AppComponent,
    StartComponent,
    NewGameComponent,
    QuestionsFormComponent,
    AllThemesComponent,
    EditFormComponent,
    AddFormComponent,
    AddAnswerFormComponent,
    EditAnswerFormComponent,
    GameComponent,
    GamaAnswerComponent,
  ],
  imports: [
    BrowserModule,
    RouterModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    FormsModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
