import { Injectable } from '@angular/core';
import { UsuarioModel } from '../models/usuario.model';
import { UsuarioFacade } from '../facade/usuario.facade';
import { LoginModel } from '../models/login.model';
import { SesionModel } from '../models/sesion.model';
@Injectable({
  providedIn: 'root'
})
export class UsuarioService {

  usuario: UsuarioModel;
  sesion: SesionModel;
  usuarios: UsuarioModel[];
  constructor(public usuarioFacade : UsuarioFacade) { }

  registrarUsuario(usuarioModel: UsuarioModel){
    this.usuarioFacade.guardarUsuario(usuarioModel).subscribe(data=>{
    this.usuario = data;
    });
  }

  buscarUsuarios(usuarioModel: UsuarioModel){
    this.usuarioFacade.getUsuarios().subscribe(data=>{
      this.usuarios = data;
      });
  }
  iniciarSesion(usuarioModel: LoginModel){
    this.usuarioFacade.getUsuario(usuarioModel).subscribe(data=>{
      this.sesion = data;
      });
  }
}
