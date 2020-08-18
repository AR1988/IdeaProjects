import {Component, OnDestroy, OnInit} from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';
import {Question} from '../../../model/question';
import {InitService} from '../../service/init.service';
import {ActivatedRoute} from '@angular/router';
import {Subscription} from 'rxjs';

@Component({
  selector: 'app-game',
  templateUrl: './game.component.html',
  styleUrls: ['./game.component.css']
})
export class GameComponent implements OnInit, OnDestroy {
  constructor(public initService: InitService, private route: ActivatedRoute) {
  }

  form: FormGroup;
  // questions: Question[];
  question: Question;
  user: string;
  // formA: FormGroup;
  questionNumber = 1;
  public themeId: number;
  private subscription: Subscription;

  ngOnInit(): void {
    this.themeId = +this.route.snapshot.paramMap.get('themeId');
    this.questionRequest();
    this.initFormsControls();
    // this.initFormsControls();
    window.addEventListener('storage', this.eventHandler, false);
  }

  private questionRequest = (): void => {
    this.subscription = this.initService.getQuestionsByThemeIdAndQuestionId(this.themeId, this.questionNumber)
      .subscribe(value => this.question = value);
  }

  // onSubmit(): void {
  //   this.user = this.form.value.user;
  // }

  ngOnDestroy(): void {
    this.subscription.unsubscribe();
  }

  nextQuestion(): void {
    this.questionNumber++;
    localStorage.setItem('key', Math.random().toString());
    this.eventHandler();
  }

  private initFormsControls(): void {
    this.form = new FormGroup({
      user: new FormControl()
    });
  }

  private eventHandler(): void {
    console.log(this.questionNumber);
    this.questionRequest();
  }
}

