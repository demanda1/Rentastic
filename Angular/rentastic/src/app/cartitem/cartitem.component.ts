import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-cartitem',
  templateUrl: './cartitem.component.html',
  styleUrls: ['./cartitem.component.css']
})
export class CartitemComponent implements OnInit {
cid:any
List:any
address:any;
  constructor() { }

  ngOnInit() {
    let url3="http://localhost:3000/viewcart?cid=EcSNPq";
    fetch(url3,{
      method:"GET",
      headers:{
        "content-type":"application/json"
      }
    })
    .then(res=>res.json())
    .then(data=>{
      console.log(data);
      this.List=data;
    })

    let url4="http://localhost:3000/findcustomer?cid=EcSNPq";
    fetch(url4,{
      method:"GET",
      headers:{
        "content-type":"application/json"
      }
    })
    .then(res=>res.json())
    .then(data=>{
      console.log(data);
      this.address=data[0].customeraddress;
    })

  }

}
