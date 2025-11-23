import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { NgChartsModule } from 'ng2-charts';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { FooterComponent } from './components/footer/footer.component';
import { LoadingComponent } from './components/loading/loading.component';
import { HomeComponent } from './pages/home/home.component';
import { CarExplorerComponent } from './pages/car-explorer/car-explorer.component';
import { CarDetailComponent } from './pages/car-detail/car-detail.component';
import { KnowledgeHubComponent } from './pages/knowledge-hub/knowledge-hub.component';
import { DashboardComponent } from './pages/dashboard/dashboard.component';
import { AdminPanelComponent } from './pages/admin-panel/admin-panel.component';
import { LoginComponent } from './pages/login/login.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    FooterComponent,
    LoadingComponent,
    HomeComponent,
    CarExplorerComponent,
    CarDetailComponent,
    KnowledgeHubComponent,
    DashboardComponent,
    AdminPanelComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    NgChartsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

