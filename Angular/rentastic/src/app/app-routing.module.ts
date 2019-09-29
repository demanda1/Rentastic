import { NgModule, Component } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { SelectcityComponent } from './selectcity/selectcity.component';
import { HomepageComponent } from './homepage/homepage.component';
import { ProductcatalogueComponent } from './productcatalogue/productcatalogue.component';
import { CartpageComponent } from './cartpage/cartpage.component';
import { ViewproductComponent } from './viewproduct/viewproduct.component';
import { AdvertiseComponent } from './advertise/advertise.component';
import { NavbarComponent } from './navbar/navbar.component';
import { CartitemComponent } from './cartitem/cartitem.component';
import { LoginComponent } from './login/login.component';
import { RegistrationComponent } from './registration/registration.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';

const routes: Routes = [
  {path:'',component:SelectcityComponent},
  {path:'home',component:HomepageComponent},
  {path:'homepage/:city' ,component:HomepageComponent},
  {path:'productcatalogue/:category/:city', component:ProductcatalogueComponent},
  {path:'cartpage',component:CartpageComponent},
  {path:'viewproduct/:city/:pid',component:ViewproductComponent},
  {path:'advertise',component:AdvertiseComponent},
  {path:'navbar',component:NavbarComponent},
  {path:'cartitem',component:CartitemComponent},
  {path:'register',component:RegistrationComponent},
  {path:'**',component:PageNotFoundComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
export const RoutingComponent =[SelectcityComponent, HomepageComponent ,ProductcatalogueComponent, CartpageComponent,
                                ViewproductComponent, AdvertiseComponent, NavbarComponent,CartitemComponent,
                                LoginComponent,RegistrationComponent,PageNotFoundComponent];
