import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-cartitem',
  templateUrl: './cartitem.component.html',
  styleUrls: ['./cartitem.component.css']
})
export class CartitemComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

  public List:any[] = [
    {image:"https://github.com/demanda1/Project/blob/master/images/beds.png?raw=true", productname:"Maharaja Bed",
     rentersname:"Deepak Mandal", price:"10000",amount:"10000"},
     {image:"https://github.com/demanda1/Project/blob/master/images/chair.png?raw=true", productname:"Wodden chair",
     rentersname:"Deepak Mandal", price:"500",amount:"500"},
     {image:"https://github.com/demanda1/Project/blob/master/images/fridge.png?raw=true", productname:"samsung refrigerator",
     rentersname:"Deepak Mandal", price:"3000",amount:"3000"},
     
  ]

}
