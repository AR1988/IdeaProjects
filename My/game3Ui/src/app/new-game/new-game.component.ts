import {Component, OnInit} from '@angular/core';
import {InitService} from '../service/init.service';

@Component({
  selector: 'app-new-game',
  templateUrl: './new-game.component.html',
  styleUrls: ['./new-game.component.css']
})
export class NewGameComponent implements OnInit {
  players = [];
  maxPlayersNumber = 10;

  constructor(public initService: InitService) {
  }

  ngOnInit(): void {
    this.fillPlayersArray();
    this.initService.getAllThemes();
  }

  private fillPlayersArray(): void {
    for (let i = 1; i <= this.maxPlayersNumber; i++) {
      this.players.push(i);
    }
  }

}
