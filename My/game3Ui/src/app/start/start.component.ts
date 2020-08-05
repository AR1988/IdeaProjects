import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-start',
  templateUrl: './start.component.html',
  styleUrls: ['./start.component.css']
})
export class StartComponent implements OnInit {

  constructor() {
  }

  private static eventHandler(): void {
    const elt = document.getElementById('btn');
    elt.innerText = 'Clicked';
  }

  ngOnInit(): void {
    window.addEventListener('storage', StartComponent.eventHandler, false);
  }

  onClick(): void {
    localStorage.setItem('key', Math.random().toString());
    StartComponent.eventHandler();
  }
}


