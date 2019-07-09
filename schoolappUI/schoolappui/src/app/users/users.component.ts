import { Component, OnInit } from '@angular/core';
import { UserService } from '../services/user.service';
import { Router, ActivatedRoute } from '@angular/router';
import { CommonService } from '../services/common.service';
declare var $: any;

@Component({
  selector: 'golars-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})
export class UsersComponent implements OnInit {
  users;
  userLoginHistoryData;
  actualUsrData;
  selectedUser;
  constructor(private userService: UserService,private commonService:CommonService,private router: Router){

  }
  ngOnInit(){
    this.userService.getAllUsers()
    .subscribe(
      data => {
        this.actualUsrData = JSON.parse(JSON.stringify(data));;
          // data.fo
          
          this.users = this.constructUserData(data);
      },
      error => {
        console.log(error);
      });

  }
  constructUserData(data){
    var resultData=[];
    for(var i=0;i<data.length;i++)
    {
      resultData.push(data[i])
     }
    return resultData;
  }
  loginWithUser(user){
    this.router.navigate(['/']);
  }
  editUser(user){
      this.commonService.updateUserforEdit(user);
      setTimeout(() => {
        this.router.navigate(['newuser']);
      }, 50);
  }
  deleteUser(user) {
    
    this.selectedUser = user;
    $('#user_select_delete_model').modal('show');

  }
  deleteUserOnConfirmation() {
    this.userService.deleteUser(this.selectedUser).subscribe(
      data => {

        // data.fo
        this.users = data;
        $('#user_select_delete_model').modal('hide');

      },
      error => {
        console.log(error);
      });
  }
  getDate(loginTime){
    return new Date(loginTime)
  }
}


