import { EmployeeDetailsComponent } from './employee-details/employee-details.component';
import { CreateEmployeeComponent } from './create-employee/create-employee.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { EmployeeListComponent } from './employee-list/employee-list.component';
import { UpdateEmployeeComponent } from './update-employee/update-employee.component';
import { UserComponent } from './user/user.component';
import { LoginComponent } from './login/login.component';
import { AuthService } from './auth.service';



const routes: Routes = [
  { path: '', redirectTo: 'login', pathMatch: 'full' },
  { path: 'employees', component: EmployeeListComponent, canActivate: [AuthService] },
  { path: 'add', component: CreateEmployeeComponent, canActivate: [AuthService] },
  { path: 'update/:id', component: UpdateEmployeeComponent, canActivate: [AuthService] },
  { path: 'details/:id', component: EmployeeDetailsComponent,canActivate: [AuthService] },
  { path: 'users', component: UserComponent },
  { path: 'login', component: LoginComponent }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
