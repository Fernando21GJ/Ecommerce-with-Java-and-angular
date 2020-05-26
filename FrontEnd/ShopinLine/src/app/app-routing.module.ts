import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { InicioComponent } from './inicio/inicio.component';
import { AdministradorComponent } from './administrador/administrador.component';
import { LoginComponent } from './login/login.component';
import { ProductoComponent } from './producto/producto.component';
import { RecuperarComponent } from './recuperar/recuperar.component';
import { RegistroComponent } from './registro/registro.component';
import { CarritoComponent } from './carrito/carrito.component';


const routes: Routes = [
  { path: 'inicio', component: InicioComponent },
  { path:'', component: InicioComponent},
  { path:'administrador', component: AdministradorComponent},
  { path:'producto', component: ProductoComponent},
  { path:'login', component: LoginComponent},
  { path:'recuperar', component: RecuperarComponent},
  { path:'registro', component: RegistroComponent},
  { path:'carrito', component: CarritoComponent}


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
