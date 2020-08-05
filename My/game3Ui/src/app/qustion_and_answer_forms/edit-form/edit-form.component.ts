import {Component, Input, OnInit} from '@angular/core';
import {InitService} from '../../service/init.service';
import {Question} from '../../../model/question';
import {FormControl, FormGroup} from '@angular/forms';
import {Answer} from '../../../model/answer';


@Component({
  selector: 'app-edit-form',
  templateUrl: './edit-form.component.html',
  styleUrls: ['./edit-form.component.css']
})
export class EditFormComponent implements OnInit {


  constructor(private initService: InitService) {

  }

  @Input()
  question: Question;
  form: FormGroup;
  btnName: string;
  editStat: boolean;
  answers: Answer[];

  range: HTMLElement;

  ngOnInit(): void {
    this.btnName = 'Edit';
    this.initFormsControls();
    this.getAnswers();
    this.disableFormInputs();
  }


  getAnswers(): void {
    this.initService.getAllAnswersByQuestionId(this.question.id).subscribe(value => {
      this.answers = value;
      this.setFormValues();
    });
  }

  onSubmit(): void {

  }

  btnNameSwitch(): void {
    this.editStat = !this.editStat;

    if (!this.editStat) {
      this.btnName = 'Edit';
      this.disableFormInputs();
    } else {
      this.btnName = 'Save';
      this.enableFormInputs();
    }
  }

  private setFormValues(): void {
    let correctAnswerNumber: number;
    for (let i = 0; i < this.answers.length; i++) {
      if (this.answers[i].isCorrect) {
        correctAnswerNumber = i;
      }
    }
    let correctAnswerForSelect: string;

    switch (correctAnswerNumber) {
      case (0):
        correctAnswerForSelect = 'answerA';
        break;
      case (1):
        correctAnswerForSelect = 'answerB';
        break;
      case (2):
        correctAnswerForSelect = 'answerC';
        break;
      case (3):
        correctAnswerForSelect = 'answerD';
        break;
    }

    this.form.patchValue({
      question: this.question.question,
      hit: this.question.hit,
      answerA: this.answers[0].answer,
      answerB: this.answers[1].answer,
      answerC: this.answers[2].answer,
      answerD: this.answers[3].answer,
      correctAnswer: correctAnswerForSelect,
    });
  }

  private initFormsControls(): void {
    this.form = new FormGroup({
      question: new FormControl(),
      hit: new FormControl(),
      answerA: new FormControl(),
      answerB: new FormControl(),
      answerC: new FormControl(),
      answerD: new FormControl(),
      correctAnswer: new FormControl(),
    });

  }

  private disableFormInputs(): void {
    this.form.controls.question.disable();
    this.form.controls.hit.disable();
    this.form.controls.answerA.disable();
    this.form.controls.answerB.disable();
    this.form.controls.answerC.disable();
    this.form.controls.answerD.disable();
    this.form.controls.correctAnswer.disable();

  }

  private enableFormInputs(): void {
    this.form.controls.question.enable();
    this.form.controls.hit.enable();
    this.form.controls.answerA.enable();
    this.form.controls.answerB.enable();
    this.form.controls.answerC.enable();
    this.form.controls.answerD.enable();
    this.form.controls.correctAnswer.enable();

  }
}


