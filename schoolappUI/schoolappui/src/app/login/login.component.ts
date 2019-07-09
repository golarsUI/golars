import { Component, OnInit, ViewChild } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationService } from '../services/authentication.service';
import { CommonService } from '../services/common.service';
import { FormGroup } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private router: Router, public authenticationService: AuthenticationService,private commonService:CommonService) { }
  newlyCretedUser = false;
  model: any = {};
  loginErrorMessage = null;
  showresetErrorMessage = false;
  passwordDoesnotmatch=false; 
  @ViewChild('f') formGroup: FormGroup; 
  username; 
  ngOnInit() {
    if(this.commonService.checkValidLogin()){
      
console.log("login init")
    this.router.navigate(['/']);
    }
    
  }
  login() {
    this.authenticationService.login(this.model.username, this.model.password)
      .subscribe(
        data => {
          if(data == null){
            this.loginErrorMessage = "Invalid Username or Password";
            return;
          }
          if(data.newlyCreated != null && data.newlyCreated === true){
          this.newlyCretedUser = true;
          this.username = data.username;
        }else{
         this.commonService.validLogin();
         this.commonService.addCurrentUser(data);
          this.router.navigate(["/"]);
        }
        },
        error => {
          this.loginErrorMessage = "Invalid Username or Password";
          console.log(error);
        });
  }
 //reset password start
 changePassword(){
  this.model.username = this.username;
  this.model.reset = false;
if(this.model != null && this.model.newPassword!=null &&  this.model.confirmPassword != null  && this.model.newPassword !== this.model.confirmPassword){
this.formGroup.controls['confirmPassword'].setErrors({'mismatch': true});
this.passwordDoesnotmatch=true;
}else{
this.authenticationService.changePassword(this.model) .subscribe(
data => {
   // console.log(message)
   if(data === true){
    this.model.password=this.model.newPassword;
// this.showSuccessMessage=true;
this.login();
// this.authenticationService.logout();

  //  console.log(data)
  }else{
   this.showresetErrorMessage =true; 
  }
},
error => {
  console.log(error)
});
}
}
}
