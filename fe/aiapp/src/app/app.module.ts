import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { UsersComponent } from './users/users.component';
import { HttpClientModule } from '@angular/common/http';
import { AdvertismentsListComponent } from './advertisments-list/advertisments-list.component';
import { AdvertismentDetailsComponent } from './advertisment-details/advertisment-details.component';
import { CreateAdvertismentComponent } from './create-advertisment/create-advertisment.component';

@NgModule({
  declarations: [
    AppComponent,
    UsersComponent,
    AdvertismentsListComponent,
    AdvertismentDetailsComponent,
    CreateAdvertismentComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
  ],
  providers: [AppService],
  bootstrap: [AppComponent]
})
export class AppModule { }
