import { Component, OnInit } from '@angular/core';
import { UsuarioService } from '../business/usuario.service';
import { UsuarioModel } from '../models/usuario.model';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  usuarioModel = new UsuarioModel();
  usuarioInput: string;
  passwordInput: string;
  constructor(private usuarioService: UsuarioService) { }

  ngOnInit() {
  }
  iniciarSesion(){
    console.log(this.usuarioModel);
    this.usuarioService.iniciarSesion(this.usuarioModel);
    console.log('metodo enviado');
  }
}
