import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationService } from './services/authentication.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  loginSuccesful=false;
  constructor( private router: Router,private authenticationService: AuthenticationService){

  }
  ngOnInit(){
    console.log( sessionStorage.getItem("userToken"));
    if(sessionStorage.getItem("userToken") === null)
      this.router.navigate(['/login']);
      else{
      this.loginSuccesful=true;
      this.router.navigate(['/home']);
      }
  }
  logout(){
    this.authenticationService.logout();
    this.router.navigate(['/login']);
  }
}
