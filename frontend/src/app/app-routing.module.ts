import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppCartComponent } from './app-cart/app-cart.component';
import { AppDashboardComponent } from './app-dashboard/app-dashboard.component';

const routes: Routes = [
  { path: '', component: AppDashboardComponent },
  { path: 'cart', component: AppCartComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
