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
amount:any;
data:number;
plusval:any;
quantity:any;

  constructor() { }

  ngOnInit() {
    this.cid=localStorage.getItem('token');
    
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
      this.List=data;
    })
    
    let url4="http://localhost:3000/findcustomer?cid="+this.cid;
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

    plus(id:any){
      console.log(id);
      let elementid="input"+id;
      console.log(elementid);
     this.plusval=+((<HTMLInputElement>document.getElementById(elementid)).value);
     console.log(this.plusval);
     var price="price"+id;
     var subtotal=+((<HTMLInputElement>document.getElementById(price)).innerHTML);
     this.quantity=this.plusval+1;
     (<HTMLOutputElement>document.getElementById(elementid)).value=String(this.quantity);
     console.log(subtotal*this.quantity);
     let subtot="subtotal"+id;
     (<HTMLOutputElement>document.getElementById(subtot)).innerHTML=String(this.quantity*subtotal);
     var sum=0;
     for (let i of this.List) {
       let id="subtotal"+i.productid;
       console.log(id);
       var p=+(<HTMLInputElement>document.getElementById(id)).innerText;
      sum=sum+p;
      }
     (<HTMLOutputElement>document.getElementById('amount')).innerHTML=String(sum);
     (<HTMLOutputElement>document.getElementById('finalamount')).innerHTML=String(sum+50);
    }
    minus(id:any){
      console.log(id);
      let elementid="input"+id;
     this.plusval=+((<HTMLInputElement>document.getElementById(elementid)).value);
     var subtotal=+((<HTMLInputElement>document.getElementById("price")).innerHTML);
     if(this.plusval>0){
     this.quantity=this.plusval-1;
     }
     (<HTMLOutputElement>document.getElementById(elementid)).value=String(this.quantity);
     (<HTMLOutputElement>document.getElementById('subtotal')).innerHTML=String(this.quantity*subtotal);
    }

}
