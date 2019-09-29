import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {
 city:any
 username:string;
 userid:string;
 key:'123456$#@$^@1ERF';
 _url:any;

  constructor() { }

  ngOnInit() {
    this.city=localStorage.getItem("city");
    this.loggedInUser();
  }


  loggedInUser(){
    this.userid =localStorage.getItem('token');
    if(this.userid!=undefined){ 
    this._url = 'http://172.18.2.253:3000/findcustomer?cid='+this.userid;
    fetch(this._url)
    .then(res=>res.json())
    .then(data=>{
      this.username=data[0].customername;      
    })
  }
  else{
   this.username='noLoggedInUser'
  }
}
  
}
