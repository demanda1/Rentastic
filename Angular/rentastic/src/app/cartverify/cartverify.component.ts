import { Component, OnInit, ViewChild, ElementRef } from '@angular/core';

@Component({
  selector: 'app-cartverify',
  templateUrl: './cartverify.component.html',
  styleUrls: ['./cartverify.component.css']
})
export class CartverifyComponent implements OnInit {
  @ViewChild('openModal',undefined) openModal:ElementRef;

  idtype:any;
  idnum:any;
  cid:any;
  myid:any;
  wallet:any;
  amount:any;
  active:String;
  invoicelist:any;
  tablerows:any;
  name:any;
  email:any;
  constructor() { 

  }

  ngOnInit() {
    this.tablerows="";
    this.amount=+localStorage.getItem('amount');
    ((<HTMLInputElement>document.getElementById("spinner")).hidden=true);
    this.cid=localStorage.getItem('token');
    let url="http://localhost:3000/findcustomer?cid="+this.cid;
    fetch(url)
    .then(res=>res.json())
    .then(data=>{
      console.log(data)
      this.name=data[0].customername;
      this.email=data[0].customeremail;
      this.wallet=+data[0].customerwallet; 
      console.log(this.wallet+" "+this.amount);
      this.active="active";
      if(this.wallet<=this.amount){
        console.log("deactivated")
        this.active="inactive";
      }    
    })

    let url3="http://localhost:3000/viewcart?cid="+this.cid;
     fetch(url3,{
      method:"GET",
      headers:{
        "content-type":"application/json"
      }
    }).then(res=>res.json())
    .then(data=>{
      console.log(data);
      this.invoicelist=data;
    })
    
    
  }

  pay(){
    this.idtype=((<HTMLOutputElement>document.getElementById("idtype")).value);
    this.idnum=((<HTMLOutputElement>document.getElementById("idnum")).value);
    ((<HTMLInputElement>document.getElementById("idtype")).disabled=true);
    ((<HTMLInputElement>document.getElementById("idnum")).disabled=true);
    ((<HTMLInputElement>document.getElementById("submit")).disabled=true);
    ((<HTMLInputElement>document.getElementById("paybtn")).disabled=false);
    ((<HTMLInputElement>document.getElementById("walletbtn")).disabled=false);
    
    this.myid=this.idtype +"-"+this.idnum.toUpperCase();
    console.log(this.myid);
    let url="http://localhost:3000/setidproof?idnum="+this.myid+"&cid="+this.cid;
    fetch(url,{
      method:"GET",
      headers:{
        "content-type":"application/json"
      }
    })
  }

  transaction(){
    let url="http://localhost:3000/walletpayment?cid="+this.cid+"&amount="+this.amount;
    fetch(url).then(res=>res.json())
    .then(data=>{
      console.log(data[0]);
      if(data[0]=="success"){
        let url="http://localhost:3000/checkout?cid="+this.cid+"&status=success";
      fetch(url)
      .then(res=>res.json())
      .then(data=>{
        console.log(data)
        if(data[0]!=null){
          ((<HTMLInputElement>document.getElementById("spinner")).hidden=false);
          setTimeout(()=>{
            this.openModal.nativeElement.click();
            (<HTMLInputElement>document.getElementById("spinner")).hidden=true;;
          },3000)
        }
        
    
      setTimeout(()=>{

      for(let i of this.invoicelist){
      this.tablerows+="<tr><td><img src='"+i.productimage+"' style='width:50px;'></td><td>"+i.productname+"</td><td>"+i.productquantity+"</td><td>"+i.productprice+"</td></tr>";
      }
      this.tablerows+="<tr><td></td><td></td><td>Total Amount: </td><td>"+this.amount+"</td></tr>";
      setTimeout(()=>{
        console.log("Invoice email activated" +this.tablerows);
        let url3="http://localhost:3000/sendinvoice";
        fetch(url3,{
          method:"POST",
          headers:{
            "content-type":"application/json"
          },
          body : JSON.stringify({
            name:this.name,
            to:this.email,
            subject:"Rentastic Invoice for the Orders",
            body:this.tablerows
        })
        }).then(res=>res.json())
        .then(data=>{
          })
      },3000)
     console.log("invoice sent");

    },3000)

        
  })
    }
  })



  }
}
