import { Injectable } from '@angular/core';
import { CategoriaModel } from '../models/categoria.model';
import { Observable } from 'rxjs';
import {WebServiceService} from '../business/web-service.service';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CategoriaFacade {
  
  categoria : CategoriaModel;
  
   
  constructor(public  http: HttpClient, public WS: WebServiceService) { }

  //Metodo get es para obtener datos de la base de datos
  //Metodo Put es para actualizar los datos en la base de datos
  //Metodo Post es para ingresar datos en la Base de datos
  //Metodo delete es para eliminar datos

getCategorias(): Observable<CategoriaModel[]> {
  return this.http
    .get<CategoriaModel[]>(
      this.WS.SOURCECATEGORIA + "categorias",
      this.WS.getOptions());
}
// getUsuario(idUsuario : number): Observable<Usuario> {
//   return this.http
//     .get<Usuario>(
//       this.WS.SOURCEUSUARIO + "usuario/"+idUsuario,
//       this.WS.getOptions());
// }
modificarCategoria( categoria: CategoriaModel): Observable<CategoriaModel> {
  return this.http
    .put<CategoriaModel>(""+
      this.WS.SOURCEUSUARIO + "actualizarCategoria/",
      {"categoria" : categoria},
      this.WS.getOptions());
      
}
eliminarCategoria(idCat : number): Observable<CategoriaModel> {
  console.log(idCat);   
  return this.http
    .delete<CategoriaModel>(""+
      this.WS.SOURCECATEGORIA + "eliminar/"+idCat,
      this.WS.getOptions());
      
}

guardarCategoria(categoria: CategoriaModel): Observable<CategoriaModel> {
  return this.http
    .post<CategoriaModel>(""+
      this.WS.SOURCECATEGORIA + "guardarCategoria/",
      {"categoria" : categoria},
      this.WS.getOptions());
      
}
  
}
