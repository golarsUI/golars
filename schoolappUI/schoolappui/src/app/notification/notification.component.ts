import { Component, OnInit } from '@angular/core';
import { NotificationService } from '../notification.service';
import { Router } from '@angular/router';

@Component({
  selector: 'schoolapp-notification',
  templateUrl: './notification.component.html',
  styleUrls: ['./notification.component.css']
})
export class NotificationComponent implements OnInit {

  constructor( private router: Router,private notificationService: NotificationService) {
   }
  notificationMessage;
  sendButtonDisabled;
  showSuccess=false;
  successNotificationMessage ="";
  showFailure=false;
  failureNotificationMessage ="";
  modal={smgNews:true,smgSchool:true,youthMin:true,adultFaith:true,childFaith:true,
    smgMen:true,smgWomen:true,youngFamily:true,smgSports:true,silverAngle:true,notificationTitle:"",
    notificationMessage:""};
  ngOnInit() { 
    if(localStorage.getItem("currentUser") === null ||  localStorage.getItem('loginSuccessful')==null){
      localStorage.removeItem("currentUser");
      this.router.navigate(['/login']);
    }
    
  }
  sendNotification(){
    this.showFailure = false;
    this.showSuccess=false;
    this.successNotificationMessage="";
    this.failureNotificationMessage="";
    this.notificationService.sendNotification(this.modal)
    .subscribe(
      result => {
        // data.fo
        console.log(result);
        if(result){
          this.showSuccess=true;
          this.successNotificationMessage ="Notification sent successfully";
        }else{
          this.showFailure=true;
          this.failureNotificationMessage ="Notification sent failed. Please check server logs";
        }
      },
      error => {
        console.log(error);
      });
  }
}
