import { Component, OnInit, ViewChild, ElementRef } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-viewproduct',
  templateUrl: './viewproduct.component.html',
  styleUrls: ['./viewproduct.component.css']
})
export class ViewproductComponent implements OnInit {
  @ViewChild('openModal',undefined) openModal:ElementRef;
city:any;
List:any;
List2:any;
pid:any;
myFullresImage:any;
myThumbnail:any;
cid:string; 
urlnew:string;
cart:string;
username:string;

  constructor(private router:Router,private activatedRoute:ActivatedRoute) {
    this.activatedRoute.params.subscribe(params=>{ this.pid=params['pid'], this.city=params['city']});
     }

  ngOnInit() {
    this.cid =localStorage.getItem('token');
    if(this.cid!=undefined){ 
    this.urlnew = 'http://172.18.2.253:3000/findcustomer?cid='+this.cid;
    fetch(this.urlnew)
    .then(res=>res.json())
    .then(data=>{
      this.username=data[0].customername;      
    })
  }
  else{
   this.username='noLoggedInUser'
  }

    let url= "http://localhost:3000/showproductbyid?pid="+ this.pid;
      fetch(url,{
        method:"GET",
        headers:{
          "content-type":"application/json"
        }
      })
      .then(res => res.json())
      .then(data=> 
        {
          console.log(data)
        this.List=data;
        this.myFullresImage=data[0].productimage;
        this.myThumbnail=data[0].productimage;
      })



      let url3="http://localhost:3000/viewcart?cid="+this.cid;
      fetch(url3,{
        method:"GET",
        headers:{
          "content-type":"application/json"
        }
      })
      .then(res=>res.json())
      .then(data=>{
        console.log(data);
        if(data[0]!=null){
          this.cart='items';
        }
        else{
          this.cart='noitems';
        }
      })



      let url2= "http://localhost:3000/showallproduct?city="+this.city;
    fetch(url2,{
      method:"GET",
      headers:{
        "content-type":"application/json"
      }
    })
    .then(res => res.json())
    .then(data=> 
      {
        console.log(data)
      this.List2=data;
    })



     

  }
  

  addtocart(pid:any){
    console.log("bought the product",pid);
    this.cid=localStorage.getItem('token');
    if(this.cid!==undefined){
    let addurl="http://localhost:3000/mycart/"+pid+"/"+this.cid;
    fetch(addurl,{
      method:"GET",
      headers:{
        "content-type":"application/json"
      }
    })
    .then(res=>res.json())
    .then(data=>{
      console.log(data);
      if(data!=null){
        this.openModal.nativeElement.click();
      }
    })
  }
}
}
