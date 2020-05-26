import { Injectable } from '@angular/core';
import { HttpHeaders } from '@angular/common/http';
import { headersToString } from 'selenium-webdriver/http';
@Injectable({
  providedIn: 'root'
})
export class WebServiceService {

  constructor() { }

 // WS = 'http://192.168.1.74:8080/tiendaOnline/resources/';
  WS = 'http://localhost:8080/tiendaOnline/resources/';
  SOURCECATEGORIA = this.WS + 'CategoriaWS/';
  SOURCEUSUARIO = this.WS + 'UsuarioWS/';



  getOptions(): {} {
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json;charset=utf-8' , //,
        //'Authorization': '' + localStorage.getItem('id_token')
      })
    };
    console.log("getoptions");
    return httpOptions;
  }

  getOptionsUploadFile(rutaArchivo: string, nombreArchivo: string): {} {
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/text;charset=utf-8',
        //'Authorization': '' + localStorage.getItem('id_token'),
        'rutaArchivo': rutaArchivo,
        'nombreArchivo': nombreArchivo

      })
    };
    return httpOptions;
  }
}
