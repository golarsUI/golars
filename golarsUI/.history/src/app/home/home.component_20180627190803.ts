import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'golars-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor( private router: Router) { }

  ngOnInit() {
    console.log( sessionStorage.getItem("userToken"));
    if(sessionStorage.getItem("userToken") === null)
    this.router.navigate(['login']);
               
  }

}
