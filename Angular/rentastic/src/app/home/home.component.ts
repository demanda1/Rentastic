import { Component, OnInit } from '@angular/core';
import { Router } from "@angular/router";
import { InteractionService } from '../interaction.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  router: any;
  url:any;
  cid:any;
  message:accountInfo;
  constructor(private interactionService:InteractionService) {

   }

  ngOnInit() {

    localStorage.setItem('token', 'CtfssY');
    this.cid=localStorage.getItem('token');
    this.url=`http://172.18.2.253:3000/findcustomer?cid=`+this.cid;
    fetch(this.url)
    .then(res=>res.json())
    .then(data=>{
      console.log(data)
      this.message=data[0];
       this.interactionService.sendMessage(this.message);
    })
  }
 


  profile(){
    console.log("Hello");
    this.router.navigateByUrl('/profile');
  }

}


//creating the interface that we have to send
interface accountInfo{
  customeraddress:any,
  customercontact:any,
  customeremail: any,
  customergender: any,
  customerid: any,
  customername: any,
  customerpassword: any,
  customerwallet: any,
  id: any,
  }
