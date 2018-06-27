import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  loginSuccesful=false;
  constructor( private router: Router){

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
  }
}
