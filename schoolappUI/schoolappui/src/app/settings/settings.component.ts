import { Component, OnInit } from '@angular/core';
import { NotificationService } from '../notification.service';
import { Router } from '@angular/router';

@Component({
  selector: 'school-settings',
  templateUrl: './settings.component.html',
  styleUrls: ['./settings.component.css']
})
export class SettingsComponent implements OnInit {
  modal: any = {};
  constructor( private router: Router,private notificationService: NotificationService) { }

  ngOnInit() {
    this.retrieveSettings();
  }
  showSuccess = false;
  successSettingsMessage = "";
  showFailure=false;
  failureSettingsMessage="";
retrieveSettings(){
  this.notificationService.retrieveSettings()
  .subscribe(
    result => {
      this.modal={};
      // data.fo
      console.log(result);
      if(result != null && result.length>0){
        for(var i=0;i<result.length;i++)
        this.modal[result[i].id] = (result[i].value == 'true');
      }
    },
    error => {
      console.log(error);
    });
}
  saveSettings(){
    this.showSuccess=false;
    this.showFailure=false;
    this.notificationService.saveSettings(this.modal)
    .subscribe(
      result => {
        // data.fo
        console.log(result);
        if(result){
          this.showSuccess=true;
          this.successSettingsMessage ="Settings updated successfully";
        }else{
          this.showFailure=true;
          this.failureSettingsMessage ="Settings update failed. Please check server logs";
        }
      },
      error => {
        console.log(error);
      });
  }
  }

