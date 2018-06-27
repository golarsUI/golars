import { Injectable, Component, OnInit } from '@angular/core';
import {HttpClient, HttpParams, HttpHeaders} from '@angular/common/http';
import { Observable } from 'rxjs/Rx';
import { Router, ActivatedRoute } from '@angular/router';
import { AuthenticationService } from '../services/authentication.service';

@Component({
  selector: 'golars-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  model: any = {};
loginData:string=""
returnUrl: string;
  constructor(private route: ActivatedRoute,
    private router: Router,
    private authenticationService: AuthenticationService) { }

  ngOnInit() {
     // reset login status
     this.authenticationService.logout();
     sessionStorage.removeItem("userToken");
      // get return url from route parameters or default to '/'
      this.returnUrl = this.route.snapshot.queryParams['returnUrl'] || '/';
  }
  login() {
    this.authenticationService.login(this.model.username, this.model.password)
        .subscribe(
            data => {
                this.router.navigate([this.returnUrl]);
                sessionStorage.setItem("userToken",data.token)
            },
            error => {
                console.log(error);
            });
}

  getHeaders(){
    var httpheaders = new HttpHeaders();
    httpheaders = httpheaders.set('Content-Type', 'application/json').set('Accept','application/json');
    return httpheaders;
  }
  private handleError(error: any) {
    console.log(error)
    return Observable.throw(error);
  }
  handleResponse(res){
    console.log("test "+res);
  }
}
