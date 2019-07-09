import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule }    from '@angular/forms';
import { AppComponent } from './app.component';
import { NotificationComponent } from './notification/notification.component';
import { LoginComponent } from './login/login.component';
import { routing } from './app.routing';
import { HomeComponent } from './home/home.component';
import { LocationStrategy, HashLocationStrategy } from '@angular/common';
import { UserComponent } from './user/user.component';
import { UsersComponent } from './users/users.component';
import {TableModule} from 'primeng/table';
import { AuthenticationService } from './services/authentication.service';
import { CommonService } from './services/common.service';
import { UserService } from './services/user.service';
import { SettingsComponent } from './settings/settings.component';
import {CheckboxModule} from 'primeng/checkbox';
@NgModule({
  declarations: [
    AppComponent,
    NotificationComponent,
    LoginComponent,
    UserComponent,
    UsersComponent,
    HomeComponent,
    SettingsComponent
  ],
  imports: [
    routing,
    BrowserModule,
    FormsModule,
    TableModule,
    CheckboxModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [
    UserService,
    CommonService,
    AuthenticationService, {provide: LocationStrategy, useClass: HashLocationStrategy}],
  bootstrap: [AppComponent]
})
export class AppModule { }
