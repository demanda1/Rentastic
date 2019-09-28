import { NgModule, Component } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { SelectcityComponent } from './selectcity/selectcity.component';
import { HomepageComponent } from './homepage/homepage.component';
import { ProductcatalogueComponent } from './productcatalogue/productcatalogue.component';
import { CartpageComponent } from './cartpage/cartpage.component';


const routes: Routes = [
  {path:'',component:SelectcityComponent},
  {path:'homepage/:city' ,component:HomepageComponent},
  {path:'productcatalogue/:category/:city', component:ProductcatalogueComponent},
  {path:'cartpage',component:CartpageComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
export const RoutingComponent =[SelectcityComponent, HomepageComponent ,ProductcatalogueComponent, CartpageComponent];
