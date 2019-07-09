import { Component } from '@angular/core';
import { CommonService } from './services/common.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'schoolappui';
  constructor(private router: Router,public commonService: CommonService){

   
    }
  ngOnInit(){
    var self = this;
    if(!this.commonService.checkValidLogin())
     this.router.navigate(['/login']);
    
  }
}
