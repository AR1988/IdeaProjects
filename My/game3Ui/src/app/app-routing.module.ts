import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {StartComponent} from './start/start.component';
import {NewGameComponent} from './new-game/new-game.component';
import {QuestionsFormComponent} from './qustions-form/questions-form.component';
import {AllThemesComponent} from './all-themes/all-themes.component';
import {GameComponent} from './game/game/game.component';


const routes: Routes = [
  {path: '', redirectTo: 'start', pathMatch: 'full'},
  {path: 'start/', component: StartComponent},
  {path: 'new-game', component: NewGameComponent},
  {path: 'edit/:themeId', component: QuestionsFormComponent},
  {path: 'themes', component: AllThemesComponent},
  {path: 'game/:themeId', component: GameComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

export class AppRoutingModule {
}
