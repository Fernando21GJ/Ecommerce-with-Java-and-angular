import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { InicioComponent } from './inicio/inicio.component';
import { RegistroComponent } from './registro/registro.component';
import { RecuperarComponent } from './recuperar/recuperar.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {SlideMenuModule} from 'primeng/slidemenu';
import {TieredMenuModule} from 'primeng/tieredmenu';
import {MenuItem} from 'primeng/api';


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    InicioComponent,
    RegistroComponent,
    RecuperarComponent,
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    SlideMenuModule,
    TieredMenuModule

  ],
  providers: [
    
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
