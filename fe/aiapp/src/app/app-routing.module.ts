import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { UsersComponent } from './users/users.component';
import { AdvertismentsListComponent } from './advertisments-list/advertisments-list.component';
import { AdvertismentDetailsComponent } from './advertisment-details/advertisment-details.component';
import { CreateAdvertismentComponent } from './create-advertisment/create-advertisment.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { UsersListComponent } from './users-list/users-list.component';
const routes: Routes = [
  { path: '', redirectTo: 'advertisments', pathMatch: 'full' },
  { path: 'users', component: UsersListComponent },
  { path: 'advertisments', component: AdvertismentsListComponent },
  { path: 'advertisments/create', component: CreateAdvertismentComponent },
  { path: 'advertisments/:id', component: AdvertismentDetailsComponent },
  { path: 'auth/login', component: LoginComponent },
  { path: 'signup', component: RegisterComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
