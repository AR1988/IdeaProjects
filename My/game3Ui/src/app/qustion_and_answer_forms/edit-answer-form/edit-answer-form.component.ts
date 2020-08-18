import {Component, Input, OnInit} from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';
import {InitService} from '../../service/init.service';
import {Answer} from '../../../model/answer';

@Component({
  selector: 'app-edit-answer-form',
  templateUrl: './edit-answer-form.component.html',
  styleUrls: ['./edit-answer-form.component.css']
})
export class EditAnswerFormComponent implements OnInit {
  formA: FormGroup;

  @Input()
  questionId: number;

  answers: Answer[];

  btnName: string;
  editStat: boolean;

  constructor(private initService: InitService) {
  }

  ngOnInit(): void {
    // this.btnName = 'Edit';
    // this.initFormsControls();
    // this.getAnswers();
  }

  getAnswers(): void {
    // this.initService.getAllAnswerByQuestionId(this.questionId).subscribe(value => {
    //   this.answers = value;
    //   this.setFormValues();
    // });
  }

  // private setFormValues(): void {
  //   let correctAnswerNumber: number;
  //   for (let i = 0; i < this.answers.length; i++) {
  //     if (this.answers[i].isCorrect) {
  //       correctAnswerNumber = i;
  //     }
  //   }
  //   let correctAnswerForSelect: string;
  //
  //   switch (correctAnswerNumber) {
  //     case (0):
  //       correctAnswerForSelect = 'answerA';
  //       break;
  //     case (1):
  //       correctAnswerForSelect = 'answerB';
  //       break;
  //     case (2):
  //       correctAnswerForSelect = 'answerC';
  //       break;
  //     case (3):
  //       correctAnswerForSelect = 'answerD';
  //       break;
  //   }
  //
  //   this.formA.patchValue({
  //     answerA: this.answers[0].answer,
  //     answerB: this.answers[1].answer,
  //     answerC: this.answers[2].answer,
  //     answerD: this.answers[3].answer,
  //     correctAnswer: correctAnswerForSelect,
  //   });
  // }

  // private initFormsControls(): void {
  //
  //   this.formA = new FormGroup({
  //     answerA: new FormControl(),
  //     answerB: new FormControl(),
  //     answerC: new FormControl(),
  //     answerD: new FormControl(),
  //     correctAnswer: new FormControl(),
  //   });
  // }

  onSubmit(): void {

  }

  // btnNameSwitch(): void {
  //   this.editStat = !this.editStat;
  //
  //   if (this.editStat) {
  //     this.btnName = 'Edit';
  //   } else {
  //     this.formA.controls.answerA.disable();
  //     this.formA.controls.answerB.disable();
  //     this.formA.controls.answerC.disable();
  //     this.formA.controls.answerD.disable();
  //     this.formA.controls.correctAnswer.disable();
  //     this.btnName = 'Save';
  //   }
  // }
}
