import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminDashboardComponent } from './Components/admin-dashboard/admin-dashboard.component';
import { AdminTicketsComponent } from './Components/admin-tickets/admin-tickets.component';
import { AdminEquipmentsComponent } from './Components/admin-equipements/admin-equipements.component';
import { AdminPannesComponent } from './Components/admin-pannes/admin-pannes.component';
import { UserComponent } from './Components/user-component/user-component.component';
import { LoginComponent } from './Components/login/login.component';
import { AuthGuard } from './services/auth.guard';
import { RoleGuard } from './services/role.guard';

const routes: Routes = [
  { path: "admin", component: AdminDashboardComponent, canActivate: [AuthGuard], data: { roles: ['ADMIN'] } },
  { path: "admin-tickets", component: AdminTicketsComponent, canActivate: [AuthGuard], data: { roles: ['ADMIN'] } },
  { path: 'equipements', component: AdminEquipmentsComponent, canActivate: [AuthGuard], data: { roles: ['ADMIN'] } },
  { path: 'pannes', component: AdminPannesComponent, canActivate: [AuthGuard], data: { roles: ['ADMIN'] } },
  { path: 'create-ticket', component: UserComponent },
  { path: 'login', component: LoginComponent },
  { path: '**', redirectTo: 'login' }
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
