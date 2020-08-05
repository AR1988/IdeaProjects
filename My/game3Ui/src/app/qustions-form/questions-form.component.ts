import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';
import {InitService} from '../service/init.service';
import {Theme} from '../../model/theme';
import {UserData} from '../../model/userData';
import {ActivatedRoute, Router} from '@angular/router';
import {Question} from '../../model/question';

@Component({
  selector: 'app-question-form',
  templateUrl: './questions-form.component.html',
  styleUrls: ['./questions-form.component.css']
})
export class QuestionsFormComponent implements OnInit {
  errorMessage: string;

  form: FormGroup;
  formPass: FormGroup;
  themeSelected: boolean;
  passCorrect: boolean;

  theme: Theme;
  questions: Question[];
  formT: FormGroup;
  setShadow: boolean;
  themeId: number;
  addStat: boolean;

  constructor(public initService: InitService,
              private router: Router,
              private route: ActivatedRoute) {
  }

  ngOnInit(): void {
    this.initFormsControls();
    this.getTheme();

    this.initService.getAllQuestionsByThemeId(this.themeId).subscribe(value => this.questions = value);
  }

  getTheme(): void {
    this.themeId = +this.route.snapshot.paramMap.get('themeId');
    this.initService.getThemeById(this.themeId).subscribe(value => this.theme = value);
  }


  onSubmitTheme(): void {
    const theme: Theme = new Theme();
    theme.themeName = this.form.value.themeName;

    this.initService.sendTheme(theme).subscribe(_ => {
      this.themeSelected = true;
      this.errorMessage = '';
    }, error => {
      this.errorMessage = error.message.message;
    });
  }

  onSubmitPass(): void {
    const user: UserData = new UserData();
    user.pass = this.formPass.value.pass;


    this.initService.sendPass(user)
      .subscribe(_ => this.passCorrect = true,
        error => {
          this.errorMessage = error.error.message;
        });
  }


  onSubmit(): void {

  }

  activateShadowOnForm(): boolean {
    this.setShadow = true;
    return this.setShadow;
  }

  disableShadowOnForm(): boolean {
    this.setShadow = false;
    return this.setShadow;
  }

  private initFormsControls(): void {
    this.formT = new FormGroup({
      themeName: new FormControl()
    });

    this.formPass = new FormGroup({
      pass: new FormControl()
    });
    this.theme = new Theme();
  }

  onClickaAddNew(): void {
    this.addStat = !this.addStat;
  }
}
