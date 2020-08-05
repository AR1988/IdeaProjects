import {Component, OnDestroy, OnInit} from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';
import {Question} from '../../../model/question';
import {InitService} from '../../service/init.service';
import {Answer} from '../../../model/answer';
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

  static questionNumber: number;
  static initService: InitService;
  static subscription: Subscription;
  static question: Question;
  static themeId: number;

  form: FormGroup;
  // questions: Question[];
  question: Question;
  user: string;
  answers: Answer[];

  formA: FormGroup;
  correctAnswer: Answer;
  questionNumber = 1;
  private subscription: Subscription;
  public themeId: number;

  private static eventHandler(): void {
    console.log('cliced');
  }

  static nextQuestion(): void {
    localStorage.setItem('key', Math.random().toString());

    this.questionNumber++;
    this.subscription = this.initService.getQuestionsByThemeIdAndQuestionId(this.themeId, this.questionNumber)
      .subscribe(value => this.question = value);
    GameComponent.eventHandler();
  }

  ngOnInit(): void {
    this.themeId = +this.route.snapshot.paramMap.get('themeId');

    this.subscription = this.initService.getQuestionsByThemeIdAndQuestionId(this.themeId, this.questionNumber)
      .subscribe(value => this.question = value);

    this.initFormsControls();

    window.addEventListener('storage', GameComponent.eventHandler, false);

  }

  onSubmit(): void {
    this.user = this.form.value.user;
  }

  private initFormsControls(): void {
    this.form = new FormGroup({
      user: new FormControl()
    });
  }

  ngOnDestroy(): void {
    this.subscription.unsubscribe();
  }

  nextQuestion(): void {
    GameComponent.nextQuestion();
  }
}

