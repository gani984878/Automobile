import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './pages/home/home.component';
import { CarExplorerComponent } from './pages/car-explorer/car-explorer.component';
import { CarDetailComponent } from './pages/car-detail/car-detail.component';
import { KnowledgeHubComponent } from './pages/knowledge-hub/knowledge-hub.component';
import { DashboardComponent } from './pages/dashboard/dashboard.component';
import { AdminPanelComponent } from './pages/admin-panel/admin-panel.component';
import { LoginComponent } from './pages/login/login.component';

const routes: Routes = [
  { path: '', component: HomeComponent, data: { animation: 'home' } },
  { path: 'explore', component: CarExplorerComponent, data: { animation: 'explore' } },
  { path: 'car/:id', component: CarDetailComponent, data: { animation: 'detail' } },
  { path: 'knowledge', component: KnowledgeHubComponent, data: { animation: 'knowledge' } },
  { path: 'dashboard', component: DashboardComponent, data: { animation: 'dashboard' } },
  { path: 'admin', component: AdminPanelComponent, data: { animation: 'admin' } },
  { path: 'login', component: LoginComponent, data: { animation: 'login' } },
  { path: '**', redirectTo: '' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes, {
    scrollPositionRestoration: 'top',
    enableTracing: false
  })],
  exports: [RouterModule]
})
export class AppRoutingModule { }

