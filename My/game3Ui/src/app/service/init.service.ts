import {Injectable} from '@angular/core';
import {Theme} from '../../model/theme';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {UserData} from '../../model/userData';
import {Question} from '../../model/question';
import {Answer} from '../../model/answer';

@Injectable({
  providedIn: 'root'
})
export class InitService {

  host = 'http://localhost:8080/api/';
  themes: Observable<Theme[]>;

  constructor(private http: HttpClient) {
  }

  private reload(): void {
    this.themes = this.http.get<Theme[]>('http://localhost:8080/api/get/themes');
  }

  getAllThemes(): Observable<Theme[]> {
    if (!this.themes) {
      this.reload();
    }
    return this.themes;
  }

  // getAllThemes(): Observable<Theme[]> {
  //   return this.themes = this.http.get<Theme[]>('http://localhost:8080/api/get/themes');
  // }

  sendTheme(theme: Theme): Observable<number> {
    return this.http.post<number>('http://localhost:8080/api/set/theme/', theme);
  }

  sendPass(user: UserData): Observable<any> {
    return this.http.post<any>('http://localhost:8080/api/set/check-user/', user);
  }

  getThemeById(themeId: number): Observable<Theme> {
    return this.http.get<Theme>('http://localhost:8080/api/get/' + themeId + '/theme');
  }

  getAllQuestionsByThemeId(themeId: number): Observable<Question[]> {
    return this.http.get<Question[]>('http://localhost:8080/api/get/' + themeId + '/questions');
  }

  getQuestionsByThemeIdAndQuestionId(themeId: number, questionId: number): Observable<Question> {
    return this.http.get<Question>('http://localhost:8080/api/get/' + themeId + '/question?id=' + questionId);
  }

  getAllAnswersByQuestionId(questionId: number): Observable<Answer[]> {
    return this.http.get<Answer[]>('http://localhost:8080/api/get/' + questionId + '/answers');
  }

  sendClick(): Observable<any> {
    return this.http.get<any>('http://localhost:8080/api/get/click/');
  }
}
