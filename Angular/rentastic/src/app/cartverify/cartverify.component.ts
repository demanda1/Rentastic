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
  constructor() { 

  }

  ngOnInit() {
    this.amount=+localStorage.getItem('amount');
    ((<HTMLInputElement>document.getElementById("spinner")).hidden=true);
    this.cid=localStorage.getItem('token');
    let url="http://localhost:3000/findcustomer?cid="+this.cid;
    fetch(url)
    .then(res=>res.json())
    .then(data=>{
      console.log(data)
      this.wallet=+data[0].customerwallet; 
      console.log(this.wallet+" "+this.amount);
      this.active="active";
      if(this.wallet<=this.amount){
        console.log("deactivated")
        this.active="inactive";
      }    
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
    // fetch(url,{
    //   method:"GET",
    //   headers:{
    //     "content-type":"application/json"
    //   }
    // })
  }

  transaction(){
    // let url="http://localhost:3000/walletpayment?cid="+this.cid+"&amount="+this.amount;
    // fetch(url)
    // .then(res=>res.json())
    // .then(data=>{
    //   console.log(data);
    //   if(data[0].equals("success")){
    //     let url="http://localhost:3000/checkout?cid="+this.cid+"&status=success";
    //     fetch(url)
    //     .then(res=>res.json())
    //     .then(data=>{
    //       console.log(data)
    //       if(data[0]!=null){
    //         this.openModal.nativeElement.click();
    //       } 
    //     })
    //   }    
    // })

    ((<HTMLInputElement>document.getElementById("spinner")).hidden=false);
    setTimeout(()=>{
      this.openModal.nativeElement.click()
      (<HTMLInputElement>document.getElementById("spinner")).hidden=true;;
    },3000)
    
  }


}
