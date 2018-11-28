import {Injectable} from '@angular/core';
import {HttpClient, HttpHandler, HttpHeaders} from '@angular/common/http';
import {JwtHelper} from 'angular2-jwt';

@Injectable()
export class AuthentificationService {

  private host: string = 'http://localhost:8080';
  private jwtToken = null;
  private roles: Array<any>;
  private jwtHelper = new JwtHelper();

  constructor(private http: HttpClient) {

  }

  login(user) {
      return this.http.post(this.host + '/login', user, {observe: 'response'});
  }

  logout() {
    this.jwtToken = null;
    localStorage.removeItem('token');
  }

  isAdmin() {
      for (let r of this.roles) {
        if(r.authority == 'ADMIN') {
          return true;
        }
        else {
          return false;
        }
      }
  }

  saveToken(jwtToken) {
      localStorage.setItem('token', jwtToken);
      this.loadToken();
      this.roles = this.jwtHelper.decodeToken(this.jwtToken).roles;
  }

  loadToken() {
    this.jwtToken = localStorage.getItem('token');
  }
  getTasks() {
    if (this.jwtToken == null) {
      this.loadToken();
    }
    return this.http.get(this.host + '/tasks', {headers: new HttpHeaders({ 'Authorization': this.jwtToken})});
  }

  saveTask(task) {
    let headers=new HttpHeaders();
    headers.append('authorization', this.jwtToken);
    return this.http.post(this.host + '/tasks', task, {headers: new HttpHeaders({ 'Authorization': this.jwtToken})});
  }

}
