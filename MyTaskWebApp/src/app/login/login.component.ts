import { Component, OnInit } from '@angular/core';
import {AuthentificationService} from '../../services/authentification.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  mode: number = 0;

  constructor(private authService: AuthentificationService, private router: Router) { }

  ngOnInit() {

  }

  onLogin(user) {
    this.authService.login(user)
      .subscribe(resp => {
        let jwtToken = resp.headers.get('authorization');
        this.authService.saveToken(jwtToken);
        this.router.navigateByUrl('/tasks');
      }, err => {
        this.mode = 1;
      });
  }

}
