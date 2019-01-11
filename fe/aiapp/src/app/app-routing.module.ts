import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { UsersComponent } from './users/users.component';
import { AdvertismentsListComponent } from './advertisments-list/advertisments-list.component';
import { AdvertismentDetailsComponent } from './advertisment-details/advertisment-details.component';
import { CreateAdvertismentComponent } from './create-advertisment/create-advertisment.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { UsersListComponent } from './users-list/users-list.component';
import { UserDetailsComponent } from './user-details/user-details.component';
import { CreateUserComponent } from './create-user/create-user.component';
import { EditAdvertismentComponent } from './edit-advertisment/edit-advertisment.component';
import { EditUserComponent } from './edit-user/edit-user.component';
const routes: Routes = [
  { path: '', redirectTo: 'advertisments', pathMatch: 'full' },
  { path: 'users', component: UsersListComponent },
  { path: 'users/:userName', component: UserDetailsComponent },
  { path: 'users/create', component: CreateUserComponent },
  { path: 'users/:userName/edit', component: EditUserComponent },
  { path: 'advertisments', component: AdvertismentsListComponent },
  { path: 'advertisments/create', component: CreateAdvertismentComponent },
  { path: 'advertisments/:id', component: AdvertismentDetailsComponent },
  { path: 'advertisments/:id/edit', component: EditAdvertismentComponent },
  { path: 'auth/login', component: LoginComponent },
  { path: 'signup', component: RegisterComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
