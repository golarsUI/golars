import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { UsersComponent } from './users/users.component';
import { UserComponent } from './user/user.component';
import { NotificationComponent } from './notification/notification.component';
import { SettingsComponent } from './settings/settings.component';

const appRoutes: Routes = [
    { path: '', component: NotificationComponent},
    { path: 'login', component: LoginComponent },
    { path: 'users', component: UsersComponent },
    { path: 'newuser', component: UserComponent },
    { path: 'settings', component: SettingsComponent },
    // otherwise redirect to home
    { path: '**', redirectTo: 'login' } 
];

export const routing = RouterModule.forRoot(appRoutes);