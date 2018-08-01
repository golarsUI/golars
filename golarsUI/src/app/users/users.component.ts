import { Component, OnInit } from '@angular/core';
import { UserService } from '../services/user.service';
import { Router } from '@angular/router';
import { CommonService } from '../services/common.service';
declare var $: any;

@Component({
  selector: 'golars-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})
export class UsersComponent implements OnInit {
  users;
  actualUsrData;
  constructor( private router: Router,private commonService: CommonService,private userService: UserService) { }
  selectedUser;
  ngOnInit() {
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
      if(data[i].admin)
      continue;
      if(data[i].permissonFolderID != null && data[i].permissonFolderID.indexOf("%%$%%")>0){
      var folderNameArray = data[i].permissonFolderID.split(",");
      var folderDisplayName = "";
      for(var j=0;j<folderNameArray.length;j++){
        var folderName =  folderNameArray[j].substring(folderNameArray[j].indexOf("%%$%%")+5);
        folderDisplayName+=folderName;
        if(j < folderNameArray.length-1)
        folderDisplayName+=", "
      }
      resultData[i].permissonFolderID =folderDisplayName;
      }



    }
    return resultData;
  }
  editUser(user) {
    var index = this.users.indexOf(user);
   localStorage.setItem("editUser",JSON.stringify(this.actualUsrData[index]));
   this.router.navigate(['newuser']);

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

}


