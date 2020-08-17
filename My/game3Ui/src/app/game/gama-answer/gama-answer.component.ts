import {Component, EventEmitter, Input, OnDestroy, OnInit, Output} from '@angular/core';
import {Question} from '../../../model/question';
import {InitService} from '../../service/init.service';
import {Answer} from '../../../model/answer';
import {Subscription} from 'rxjs';

@Component({
  selector: 'app-gama-answer',
  templateUrl: './gama-answer.component.html',
  styleUrls: ['./gama-answer.component.css']
})
export class GamaAnswerComponent implements OnInit, OnDestroy {

  @Input()
  question: Question;
  answers: Answer[];
  @Output()
  nextQuestion: EventEmitter<any> = new EventEmitter();
  private subscription: Subscription;

  constructor(public initService: InitService) {
  }

  ngOnInit(): void {
    this.subscription = this.initService.getAllAnswersByQuestionId(this.question.id).subscribe(value => this.answers = value);
  }

  onClick(isCorrect: boolean): void {
    // if (isCorrect) {
    //   alert('correct');
    // } else {
    // alert('incorrect');
    // }
    console.log(isCorrect);
    this.nextQuestion.emit();
    this.ngOnInit();
  }

  ngOnDestroy(): void {
    this.subscription.unsubscribe();
  }
}
