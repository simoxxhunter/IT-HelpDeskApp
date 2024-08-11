import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminDashboardComponent } from './Components/admin-dashboard/admin-dashboard.component';
import { AdminTicketsComponent } from './Components/admin-tickets/admin-tickets.component';
import { AdminEquipmentsComponent } from './Components/admin-equipements/admin-equipements.component';

const routes: Routes = [
  { path: "admin", component: AdminDashboardComponent },
  { path: "admin-tickets", component: AdminTicketsComponent },
  { path: 'equipements', component: AdminEquipmentsComponent }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
