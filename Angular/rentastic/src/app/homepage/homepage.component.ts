import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-homepage',
  templateUrl: './homepage.component.html',
  styleUrls: ['./homepage.component.css']
})
export class HomepageComponent implements OnInit {
  city:any;
  constructor(private router:Router,private activatedRoute:ActivatedRoute) {
    this.activatedRoute.params.subscribe(params=>{this.city=params['city']});
   }

  ngOnInit() {
    localStorage.setItem("city",this.city);
    let url= "http://localhost:3000/showallproduct?city="+this.city;
    fetch(url,{
      method:"GET",
      headers:{
        "content-type":"application/json"
      }
    })
    .then(res => res.json())
    .then(data=> 
      {
      console.log(data)})
      

    }

    handleClick(city:any){
      localStorage.setItem("city",city);
      let url= "http://localhost:3000/showproduct?city="+city;
    fetch(url,{
      method:"GET",
      headers:{
        "content-type":"application/json"
      }
    })
    .then(res => res.json())
    .then(data=> 
      {
      console.log(data)})
    }
}
