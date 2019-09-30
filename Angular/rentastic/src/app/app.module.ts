import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {FormsModule,ReactiveFormsModule} from '@angular/forms'
import { AppRoutingModule, RoutingComponent } from './app-routing.module';
import { AppComponent } from './app.component';
import { SelectcityComponent } from './selectcity/selectcity.component';
import { HomepageComponent } from './homepage/homepage.component';
import { NavbarComponent } from './navbar/navbar.component';
import { ProductcatalogueComponent } from './productcatalogue/productcatalogue.component';
import { AdvertiseComponent } from './advertise/advertise.component';
import { CartpageComponent } from './cartpage/cartpage.component';
import { CartitemComponent } from './cartitem/cartitem.component';
import { ViewproductComponent } from './viewproduct/viewproduct.component';
import { NgxImageZoomModule } from 'ngx-image-zoom';
import { InteractionService } from './interaction.service';
import { CheckoutComponent } from './checkout/checkout.component';

@NgModule({
  declarations: [
    AppComponent,
   RoutingComponent,
   CheckoutComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgxImageZoomModule.forRoot(),
    FormsModule,ReactiveFormsModule
  ],
  providers: [InteractionService],
  bootstrap: [AppComponent]
})
export class AppModule { }
