import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-inicio',
  templateUrl: './inicio.component.html',
  styleUrls: ['./inicio.component.css']
})
export class InicioComponent implements OnInit {

  constructor() { }
  images: any[];
  alto : number;
  ancho : number;
    
  ngOnInit() {
      this.ancho= window.innerWidth; 
      this.alto = (window.innerHeight); 
      this.images = [];
      this.images.push({source:'/src/assets/img/1.jpg', alt:'Description for Image 1', title:'Title 1'});
      this.images.push({source:'/src/assets/img/2.jpg', alt:'Description for Image 1', title:'Title 1'});
      this.images.push({source:'/src/assets/img/3.jpg', alt:'Description for Image 1', title:'Title 1'});
      this.images.push({source:'/src/assets/img/4.jpg', alt:'Description for Image 1', title:'Title 1'});
    }

}
