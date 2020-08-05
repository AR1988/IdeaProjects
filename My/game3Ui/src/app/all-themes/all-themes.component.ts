import {Component, OnInit} from '@angular/core';
import {InitService} from '../service/init.service';

@Component({
  selector: 'app-all-themes',
  templateUrl: './all-themes.component.html',
  styleUrls: ['./all-themes.component.css']
})
export class AllThemesComponent implements OnInit {

  constructor(public initService: InitService) {
  }

  ngOnInit(): void {
    this.initService.getAllThemes();
  }

}
