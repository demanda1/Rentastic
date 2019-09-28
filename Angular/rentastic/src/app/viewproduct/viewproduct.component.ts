import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-viewproduct',
  templateUrl: './viewproduct.component.html',
  styleUrls: ['./viewproduct.component.css']
})
export class ViewproductComponent implements OnInit {
List:any;
pid:any;
myFullresImage:any;
myThumbnail:any;
  constructor(private router:Router,private activatedRoute:ActivatedRoute) {
    this.activatedRoute.params.subscribe(params=>{ this.pid=params['pid']});
     }

  ngOnInit() {
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
  }
}
