import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule }    from '@angular/forms';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { routing } from './app.routing';
import { AuthenticationService } from './services/authentication.service';
import { ImportComponent } from './import/import.component';
import { UsersComponent } from './users/users.component';


@NgModule({
  declarations: [

    AppComponent,
    HomeComponent,
    LoginComponent,
    ImportComponent,
    UsersComponent
  ],
  imports: [
    routing,
    BrowserModule,
    FormsModule,
    HttpClientModule,
    
    
  ],
  providers: [ 
    AuthenticationService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
