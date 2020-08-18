import {Component, Input, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {Theme} from '../../../model/theme';
import {InitService} from '../../service/init.service';
import {Question} from '../../../model/question';
import {Answer} from '../../../model/answer';
import validate = WebAssembly.validate;

@Component({
  selector: 'app-add-form',
  templateUrl: './add-form.component.html',
  styleUrls: ['./add-form.component.css']
})
export class AddFormComponent implements OnInit {

  @Input()
  themeId: number;

  form: FormGroup;
  passCorrect: boolean;

  theme: Theme;

  constructor(private initService: InitService,
  ) {
  }

  ngOnInit(): void {
    this.initFormsControls();
  }

  onSubmit(): void {
    const question: Question = new Question();
    const answerA: Answer = new Answer();
    const answerB: Answer = new Answer();
    const answerC: Answer = new Answer();
    const answerD: Answer = new Answer();

    question.question = this.form.value.question;

    answerA.answer = this.form.value.answerA;
    answerA.isCorrect = false;

    answerB.answer = this.form.value.answerB;
    answerB.isCorrect = false;

    answerC.answer = this.form.value.answerC;
    answerC.isCorrect = false;

    answerD.answer = this.form.value.answerD;
    answerD.isCorrect = false;

    const correctAnswer = this.form.value.correctAnswer;


    switch (correctAnswer) {
      case 'answerA':
        answerA.isCorrect = true;
        break;
      case 'answerB':
        answerB.isCorrect = true;
        break;
      case 'answerC':
        answerC.isCorrect = true;
        break;
      case 'answerD':
        answerD.isCorrect = true;
        break;
    }

    const array: Answer[] = [];

    array.push(answerA);
    array.push(answerB);
    array.push(answerC);
    array.push(answerD);

    // this.initService.setQuestion(question);
    // this.initService.setAnswer();

  }


  private initFormsControls(): void {
    this.form = new FormGroup({
      question: new FormControl(null, [
        Validators.required,
      ]),
      hit: new FormControl(null, [
        Validators.required,
      ]),
      answerA: new FormControl(null, [
        Validators.required,
      ]),
      answerB: new FormControl(null, [
        Validators.required,
      ]),
      answerC: new FormControl(null, [
        Validators.required,
      ]),
      answerD: new FormControl(null, [
        Validators.required,
      ]),
      correctAnswer: new FormControl(null, [
        Validators.required,
      ]),
    });
  }

  onClickCancel(): void {
    this.form.reset();
  }
}
