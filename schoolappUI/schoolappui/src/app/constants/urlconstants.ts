import { environment } from "../../environments/environment";

export class URLConstants {
    public static NOTIFICATION_URL = environment.server+'/SchoolApp/rest/notifications';
    public static LOGIN_URL = environment.server+'/SchoolApp/rest/login';
    public static USER_CHANGE_PASSWORD_URL = environment.server+'/SchoolApp/rest/users/changepassword';
    public static USERS_URL = environment.server+'/SchoolApp/rest/users';
    public static SETTNGS_URL = environment.server+'/SchoolApp/rest/settings';
   
  }