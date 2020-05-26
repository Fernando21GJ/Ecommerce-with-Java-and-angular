import { Injectable } from '@angular/core';
import { CategoriaModel } from '../models/categoria.model';
import { CategoriaFacade } from '../facade/categoria.facade';

@Injectable({
  providedIn: 'root'
})
export class CATEGORIAService {
  categorias: CategoriaModel[];
  constructor(public categoriaFacade : CategoriaFacade) { }

  onSelectCategorias() {
    console.log('onSelectCategorias');// imprimir en consola
    this.categoriaFacade.getCategorias().subscribe(data => {
    this.categorias = data;
    console.log(this.categorias);
    
  });
 }
}
