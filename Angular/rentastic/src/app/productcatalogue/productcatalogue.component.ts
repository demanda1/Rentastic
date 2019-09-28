import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-productcatalogue',
  templateUrl: './productcatalogue.component.html',
  styleUrls: ['./productcatalogue.component.css']
})
export class ProductcatalogueComponent implements OnInit {
 city:any;
 category:any;
 List:any
  constructor(private router:Router,private activatedRoute:ActivatedRoute) {
    this.activatedRoute.params.subscribe(params=>{ this.category=params['category'],this.city=params['city']});
    }

  ngOnInit() {
    let url= "http://localhost:3000/showproduct?category="+this.category+"&city="+this.city;
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
    })
     
    }

    handleClick(city:any){
      localStorage.setItem("city",city);
      let url= "http://localhost:3000/showproduct?category="+this.category+"&city="+city;
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
      })
    }
    handleClick2(category:any){
      localStorage.setItem("city",this.city);
      let url= "http://localhost:3000/showproduct?category="+category+"&city="+city;
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
      })
    }

}
