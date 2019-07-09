import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import 'rxjs/add/operator/map'
import { URLConstants } from '../constants/urlconstants';
import { CommonService } from './common.service';
import { Router } from '@angular/router';
import { SchoolConstants } from '../constants/SchoolConstants';
import { map} from 'rxjs/operators';

@Injectable()
export class AuthenticationService {

    constructor(private http: HttpClient,private commonService:CommonService,private router: Router) { }

    login(username: string, password: string) {
        return this.http.post<any>(URLConstants.LOGIN_URL, { username: username, password: password })
            .pipe(map(user => {
                // login successful if there's a token in the response
                if (user && user.token) {
                    // store user details and token in local storage to keep user logged in between page refreshes
                    this.commonService.addCurrentUser(JSON.stringify(user))
              }

                return user;
            }));
    }


    changePassword(modal){
        return this.http.post<any>(URLConstants.USER_CHANGE_PASSWORD_URL, { username: modal.username, password: modal.password, updatedPassword:modal.confirmPassword,reset:modal.reset })
        .pipe(map(successMessage => {
            // Change password response
            return successMessage;
        }));
    
      }
      private getDeleteUserOptions(username) {
        return {
          params: new HttpParams().set(SchoolConstants.USER_ID,username)
        };
      }
   
}