import { Subject } from "rxjs";
import { Injectable } from "@angular/core";
import { Router } from "@angular/router";
import { SchoolConstants } from '../constants/SchoolConstants';

@Injectable()
export class CommonService {
  constructor(private router: Router) { }
  loginSuccessful = false;;
  tankAlertList=null;
  checkValidLogin() {
    if (localStorage.getItem('loginSuccessful') == "true")
      return true;
    return false;
  }
  validLogin() {
    this.loginSuccessful = true;
    localStorage.setItem('loginSuccessful', this.loginSuccessful + "");
    localStorage.setItem('loginTime', new Date()+"");
  }
  checkAndUpdateLoginTime(){
    var loginTime = localStorage.getItem('loginTime');
    // console.log("login time ---"+loginTime);
    if(loginTime != undefined){
    var loginDate = new Date(loginTime);
    var currentTime  =new Date();
    var timeDiff = Math.abs(currentTime.getTime() - loginDate.getTime());
    var seconds = Math.ceil(timeDiff / 1000); 
    // console.log(seconds);
    if(seconds > SchoolConstants.LOGOUT_TIME)
    {
      this.logout(true);
      return false;
      // this.router.navigate(['ussboa']);
    }else{
    localStorage.setItem('loginTime', new Date()+"");
    return true;
  }
    
  }else{
    this.logout(true);
  }
  }
  isEditUserPresent() {
    if (localStorage.getItem('editUser') != null)
      return true;
    return false;
  }
  emoveEditUser() {
    localStorage.removeItem("editUser");
  }
  updateUser() {
   if (localStorage.getItem('currentUser')) {
      localStorage.setItem('editUser', localStorage.getItem('currentUser'));
    }
  }
  updateUserforEdit(user){
    localStorage.setItem('editUser', JSON.stringify(user));
  }
  getEditUser() {
    if (localStorage.getItem("editUser") !== null)
      return localStorage.getItem("editUser");
    else
      return null;

  }
  getFullName() {
    var user;
      user = localStorage.getItem('currentUser');
    if (user != null && user != undefined) {
      var localuser = JSON.parse(user);
      return localuser.fullName;

    }

  }
  addCurrentUser(user) {
    localStorage.setItem('currentUser', JSON.stringify(user));
  }

  isAdmin(){
    var user = localStorage.getItem('currentUser');
    if (user != null && user != undefined) {
      var localuser = JSON.parse(user);
      return localuser.admin;

    }
  }
  getCurrentUser() {
    if (localStorage.getItem('currentUser')) {
      var localuser = localStorage.getItem('currentUser');
      if (localuser != null && localuser != undefined) {
        var userObj = JSON.parse(localuser);
          return userObj;
      }
    }
    return null;
  }
  logout(complete) {

    if(complete){
      localStorage.clear();
      location.reload();
      return;
    }
    
}
}
