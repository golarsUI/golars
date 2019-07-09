import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { URLConstants } from './constants/urlconstants';
import { map} from 'rxjs/operators';
@Injectable({
  providedIn: 'root'
})
export class NotificationService {

  constructor(private http: HttpClient) { }
  sendNotification(modal) {
    return this.http.post<any>(URLConstants.NOTIFICATION_URL, { smgNews: modal.smgNews, 
      smgSchool: modal.smgSchool, youthMin:modal.youthMin, adultFaith: modal.adultFaith,
      childFaith: modal.childFaith,smgMen: modal.smgMen,smgWomen: modal.smgWomen,
      youngFamily: modal.youngFamily,smgSports: modal.smgSports,silverAngle: modal.silverAngle,
      notificationTitle:modal.notificationTitle, notificationMessage: modal.notificationMessage

    }).pipe(map(success => {
            
            return success;
        }));
  }
  saveSettings(modal) {
    return this.http.post<any>(URLConstants.SETTNGS_URL, { id:'disableConnectTab', value:modal.disableConnectTab}).pipe(map(success => {
            
            return success;
        }));
  }
  retrieveSettings() {
    return this.http.get<any>(URLConstants.SETTNGS_URL).pipe(map(result => {
            
            return result;
        }));
  }
}
