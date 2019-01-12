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
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { AdminComponent } from './admin/admin.component';
import { httpInterceptorProviders } from './auth/auth-interceptor';
import { UsersListComponent } from './users-list/users-list.component';
import { UserDetailsComponent } from './user-details/user-details.component';
import { CreateUserComponent } from './create-user/create-user.component';
import { EditAdvertismentComponent } from './edit-advertisment/edit-advertisment.component';
import { EditUserComponent } from './edit-user/edit-user.component';
import { ChatComponent } from './chat/chat.component';

@NgModule({
  declarations: [
    AppComponent,
    UsersComponent,
    AdvertismentsListComponent,
    AdvertismentDetailsComponent,
    CreateAdvertismentComponent,
    LoginComponent,
    RegisterComponent,
    AdminComponent,
    UsersListComponent,
    UserDetailsComponent,
    CreateUserComponent,
    EditAdvertismentComponent,
    EditUserComponent,
    ChatComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
  ],
  providers: [httpInterceptorProviders],
  bootstrap: [AppComponent]
})
export class AppModule { }
