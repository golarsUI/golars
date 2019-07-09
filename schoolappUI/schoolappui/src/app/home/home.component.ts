import { Component, OnInit } from '@angular/core';
import { CommonService } from '../services/common.service';
import { Router } from '@angular/router';

@Component({
  selector: 'school-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor( private router: Router,private commonService:CommonService) { }
  user;
  isAdmin=false;
  fullName;
  ngOnInit() {
  }
  checkLoginSuccesful(){
    if(this.commonService.checkValidLogin()){
      this.fullName = this.commonService.getFullName();
      this.isAdmin = this.commonService.isAdmin();
      return true;
    }
    return false;
  }
  
  checkValidUser(){
   if(localStorage.getItem("currentUser") === null)
     this.router.navigate(['/login']);
     else{
      this.user = this.commonService.getCurrentUser();
     if(this.user!==null && this.user.admin &&(this.router.url == '/users' || this.router.url == '/resetpassword' || this.router.url == '/newuser'|| this.router.url == '/settings' || this.router.url == '/configuration'))
      this.router.navigate([this.router.url]);
      else {
    this.router.navigate(['']);
     }
    }
  }
  logout(){
    this.commonService.logout(true)
   }
}
