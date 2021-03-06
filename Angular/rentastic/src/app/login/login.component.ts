import { Component, OnInit } from '@angular/core';
import {Router, Route} from '@angular/router';
import { InteractionService } from '../interaction.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  message:accountInfo;
  constructor(private router: Router,private interactionService:InteractionService) { }

username: string;
password: string;
userId:string;
error:string;
url:string;
urlnew:string;
cid:string;
city:string;
  
ngOnInit() {

  }

//once user click on login this function will get called 
  login() : void {
    
    //checking if someone has already logged in or in 
    this.userId=localStorage.getItem('token');
    this.city=localStorage.getItem('city');
    if(this.userId==undefined){    //if no-one has logged in then only calling the fetch api for log in the user onto our website 
    this.url=`http://172.18.2.253:3000/login`;
    fetch(this.url,{
      method : "POST",
      headers: {
          "content-type": "application/json",
          'Accept': 'application/json'
         },
      body : JSON.stringify({
          email :this.username,
          password:this.password,
      })
  })
  .then(res=>res.json())
  .then(data=>{
    if(data[0]=="wrongcredentials"){ //incase creadentials are wrong 
      this.error="wrong creadentials"
      alert(this.error);
      this.router.navigate([''])
    }
    else{  //incase creadentials are valid 
      console.log("deepak")
      console.log(data);
      
    localStorage.setItem('token',data[0])
    localStorage.setItem('city',this.city);
    this.cid=localStorage.getItem('token');
    this.url=`http://172.18.2.253:3000/findcustomer?cid=`+this.cid;
    fetch(this.url)
    .then(res=>res.json())
    .then(data=>{
      console.log(data)
      console.log("hello")
      this.message=data[0];
       this.interactionService.sendMessage(this.message);
       window.location.reload();
    })

   
    }

  })
}else{ //if user has already logged in then he will not be able to log once again 
  this.error="user already loggedin, logout first!"
  this.router.navigate(['home']);
}
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