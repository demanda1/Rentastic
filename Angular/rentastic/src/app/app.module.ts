import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule, RoutingComponent } from './app-routing.module';
import { AppComponent } from './app.component';
import { SelectcityComponent } from './selectcity/selectcity.component';
import { HomepageComponent } from './homepage/homepage.component';
import { NavbarComponent } from './navbar/navbar.component';
import { ProductcatalogueComponent } from './productcatalogue/productcatalogue.component';
import { AdvertiseComponent } from './advertise/advertise.component';
import { CartpageComponent } from './cartpage/cartpage.component';
import { CartitemComponent } from './cartitem/cartitem.component';

@NgModule({
  declarations: [
    AppComponent,
   RoutingComponent,
   NavbarComponent,
   ProductcatalogueComponent,
   AdvertiseComponent,
   CartpageComponent,
   CartitemComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
