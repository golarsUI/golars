import { Injectable, Component, OnInit } from '@angular/core';
import {HttpClient, HttpParams, HttpHeaders} from '@angular/common/http';
import { Observable } from 'rxjs/Rx';

@Component({
  selector: 'golars-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
username;
password;
loginData:string=""
  constructor(private http:HttpClient) { }

  ngOnInit() {
  }
  submitLogin(){
    this.loginData="";
    this.loginData=JSON.stringify({username: this.username,password: this.password});
  console.log(this.username)
  console.log(this.password)
 
  return this.http.post('https://jsonplaceholder.typicode.com/posts', {data :  this.loginData})
  .map((res: Response) => {
    return this.handleResponse(res);
  })
  .catch((error: Response) => Observable.throw(error))
  .finally(() => {
    // this.helperService.stopLoader();
  });
  

  // return this.http.post("http://localhost:8080/golars/rest/login", 
  // {data :  this.loginData}, 
  
  
  // { headers : this.getHeaders()} )
  // .map(res => {
  //   console.log(res)
  // })
  // .catch(
  //   this.handleError);
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