import { Injectable } from '@angular/core';
import { UsuarioModel } from '../models/usuario.model';
import { Observable } from 'rxjs';
import {WebServiceService} from '../business/web-service.service';
import { HttpClient } from '@angular/common/http';
import { SesionModel } from '../models/sesion.model';
import { LoginModel } from '../models/login.model';

@Injectable({
  providedIn: 'root'
})
export class UsuarioFacade {

  registro : UsuarioModel;


  constructor(public  http: HttpClient, public WS: WebServiceService) { }

  //Metodo get es para obtener datos de la base de datos
  //Metodo Put es para actualizar los datos en la base de datos
  //Metodo Post es para ingresar datos en la Base de datos
  //Metodo delete es para eliminar datos

getUsuarios(): Observable<UsuarioModel[]> {
  return this.http
    .get<UsuarioModel[]>(
      this.WS.SOURCEUSUARIO + 'usuarios',
      this.WS.getOptions());
}
 getUsuario(sesion: LoginModel): Observable<SesionModel> {
   return this.http
     .get<SesionModel>(
       this.WS.SOURCEUSUARIO + "usuario/"+sesion,
       this.WS.getOptions());
 }
modificarUsuario( registro: UsuarioModel): Observable<UsuarioModel> {
  return this.http
    .put<UsuarioModel>(''+ this.WS.SOURCEUSUARIO + 'actualizarUsuario/',
      {'usuario' : registro},
      this.WS.getOptions());

}
eliminarUsuario(idUsu : number): Observable<UsuarioModel> {
  console.log(idUsu);
  return this.http
    .delete<UsuarioModel>('' +
      this.WS.SOURCEUSUARIO + 'eliminar/' + idUsu,
      this.WS.getOptions());

}

guardarUsuario(registro: UsuarioModel): Observable<UsuarioModel> {
  return this.http
    .post<UsuarioModel>('' +
      this.WS.SOURCEUSUARIO + 'guardarUsuario/ ',
      {"usuario": {"nombre": ""+registro.nombre, "idcliente": "0", "ap": " ","am": " ","direccion":" "+registro.direccion,"calle":" ","correo":""+registro.correo,"contrasena":""+registro.contrasena,"permisos":"usuario"}} ,
      this.WS.getOptions());

}

}
