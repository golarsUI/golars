import { Component, OnInit, ViewChild } from '@angular/core';
import { UserService } from '../services/user.service';
import { FormGroup, NgForm } from '@angular/forms';
import { CommonService } from '../services/common.service';
import { Router } from '@angular/router';

@Component({
  selector: 'golars-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {
  model: any = {};
  isEdit;
  showSuccessMessage = false;
  showFailureMessage = false;
  successMessage = null;
  failureMessage = null;
  disableRegisterButton = false;
  selectedDropdownOption;
  searchString;
  showSearch = true;
  showRegister=false;
  showNoResultSearchMessage = false;
  showMoreResultSearchMessage = false;
  dropdownSearch  = [
    {name: 'First Name', value: 'fname'},
    {name: 'Last Name', value: 'lName'},
    {name: 'Email Address', value: 'email'},
];
  user;
  userList =[];
  constructor(private router: Router,private userService: UserService, private commonService: CommonService){

  }
  ngOnInit(){
    this.user = this.commonService.getEditUser();
    if (this.user !== null && this.user !== undefined) {
      this.user = JSON.parse(this.user);
      this.isEdit = true;
      this.populateFields();
     setTimeout(() => {
      this.router.navigate(['newuser']);
     }, 10);
    }
  }
  populateFields() {
    this.model.id = this.user.id;
    this.model.firstName = this.user.firstName;
    this.model.lastName = this.user.lastName;
    this.model.email = this.user.emailAddress;
    this.model.admin = this.user.admin;
    this.model.userManager = this.user.userManager;
    // this.model.active = this.user.active;
    this.model.username = this.user.username;
    this.model.password = this.user.password;
  }
  resetSuccessAndFailureMessages() {
    this.showSuccessMessage = false;
    this.showFailureMessage = false;
    this.successMessage = null;
    this.failureMessage = null;
    this.disableRegisterButton = false;
  }
  register() {
    this.resetSuccessAndFailureMessages();
    if(this.isEdit){
      this.model.edit = this.isEdit;
    }
    this.model.newlyCreated = true;
    this.userService.registerUser(this.model)
      .subscribe(
        user => {
          if (user != null && user != undefined && user ) {

            // this.model=[];
            this.showSuccessMessage = true;
            if(this.isEdit){
              this.successMessage = "User Updated Successfully.";
            }else

            this.successMessage = "User Created Successfully.";
            this.disableRegisterButton = true;
          } else {
            this.showFailureMessage = true;
            this.failureMessage = "User Already Exists.";
          }
          // console.log(result)
        },
        error => {
          console.log(error)
        });
  }
  setUser(user)
  {
    this.user = user;
  }
  
  changeAdminUserManagerValue(type){
    if(type === "user"){
      if(this.model.userManager === false)return;
      this.model.admin= !this.model.userManager;
    }else{
      if(this.model.admin === false)return;
    this.model.userManager= !this.model.admin;
  }

  }
  cancelClick(){
    this.router.navigate(['/login']);
  }
  checkDisabled(){
    return !this.commonService.isAdmin() && this.isEdit;

  }
}
