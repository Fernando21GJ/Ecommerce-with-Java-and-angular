import { Component, OnInit } from '@angular/core';
import { CategoriaModel } from '../models/categoria.model';
import { CATEGORIAService } from '../business/categoria.service';
import { SelectItem } from 'primeng/components/common/selectitem';

@Component({
  selector: 'app-administrador',
  templateUrl: './administrador.component.html',
  styleUrls: ['./administrador.component.css']
})
export class AdministradorComponent implements OnInit {

  
  selectedCat: CategoriaModel;
  displayDialog: boolean;
  sortOptions: SelectItem[];
  sortKey: string;
  sortField: string;
  sortOrder: number;
  constructor(private categoriaService : CATEGORIAService) {  }

  ngOnInit() {
      this.categoriaService.onSelectCategorias();
  }

  selectCat(event: Event, cat: CategoriaModel) {
    this.selectedCat = cat;
    this.displayDialog = true;
    event.preventDefault();
  }

  onDialogHide() {
    this.selectedCat = null;
  }

  

}
