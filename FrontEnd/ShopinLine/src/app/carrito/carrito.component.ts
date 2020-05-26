import { Component, OnInit, ViewEncapsulation } from '@angular/core';




@Component({
  selector: 'app-carrito',
  templateUrl: './carrito.component.html',
  styleUrls: ['./carrito.component.css'],
  
  
})
export class CarritoComponent implements OnInit {
    
    cities: any[];

    constructor() {
        this.cities = [
            {name: '1', code: '1'},
            {name: '2', code: '2'},
            {name: '3', code: '3'},
            {name: '4', code: '4'},
            {name: '5', code: '5'}
        ];

        
    }

    ngOnInit() {
     
    }

}
