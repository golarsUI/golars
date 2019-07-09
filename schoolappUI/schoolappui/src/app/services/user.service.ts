import { Injectable } from '@angular/core';
import 'rxjs/Rx';
import { URLConstants } from '../constants/urlconstants';
import { map } from 'rxjs/operators';
import { HttpClient, HttpParams } from '@angular/common/http';
import { SchoolConstants } from '../constants/SchoolConstants';

@Injectable()
export class UserService {
  constructor(private http: HttpClient) { }

  getAllUsers() {
      return this.http.get(URLConstants.USERS_URL)
          .pipe(map(users => {
              
              return users;
          }));
  }
  deleteUser(user){
    return this.http.delete<any>(URLConstants.USERS_URL,this.getDeleteUserOptions(user.username))
    .map(users => {
        
        return users;
    });
  }
  registerUser(modal){
    return this.http.post(URLConstants.USERS_URL, {firstName: modal.firstName, lastName: modal.lastName, emailAddress:modal.email,
      edit: modal.edit,  admin: modal.admin,username:modal.username,password:modal.password,newlyCreated:modal.newlyCreated})
    .pipe(map(user => {
        // Registration response 
        return user;
    }));

  }
  private getDeleteUserOptions(username) {
    return {
      params: new HttpParams().set(SchoolConstants.USERNAME,username)
    };
  }
}
