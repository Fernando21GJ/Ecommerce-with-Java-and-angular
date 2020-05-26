import { Component, OnInit, ViewEncapsulation } from '@angular/core';
import { Message, ConfirmationService } from 'primeng/api';
import { NgxGalleryOptions, NgxGalleryImage, NgxGalleryAnimation } from 'ngx-gallery';

@Component({
  selector: 'app-producto',
  templateUrl: './producto.component.html',
  styleUrls: ['./producto.component.css'],
  providers: [ConfirmationService],
  styles: [`
  .custombar1 .ui-scrollpanel-wrapper {
      border-right: 9px solid #757575;
  }
      
  .custombar1 .ui-scrollpanel-bar {
      background-color: #1976d2;
      opacity: 1;
      transition: background-color .3s;
  }
      
  .custombar1 .ui-scrollpanel-bar:hover {
      background-color: #135ba1;
  }
      
  .custombar2 .ui-scrollpanel-wrapper {
      border-right: 9px solid #757575;
      border-bottom: 9px solid #757575;
  }
      
  .custombar2 .ui-scrollpanel-bar {
      background-color: #68C77D;
      border-radius: 0;
      opacity: 1;
      transition: background-color .3s;
  }
      
  .custombar2:hover .ui-scrollpanel-bar {
      background-color: #46A55A;
  }
`],
encapsulation: ViewEncapsulation.None
})
export class ProductoComponent implements OnInit {
   maximo:number;
   msgs: Message[] = [];
   images: any[];
   alto : number;
   ancho : number;
   val3: number;
   msg: string;
   galleryOptions: NgxGalleryOptions[];
   galleryImages: NgxGalleryImage[];
   score: number;

   constructor(private confirmationService: ConfirmationService) {
    this.ancho= window.innerWidth; 
    this.alto = (window.innerHeight);
    this.images = [];
    this.images.push({source:'assets/img/abi.png', thumbnail: 'assets/img/miniatura/abi-min.png', title:'Luciernaga Yagami'});
    this.images.push({source:'assets/img/abi2.png', thumbnail: 'assets/img/miniatura/abi2-min.png', title:'Luciernaga Yagami'});
     }

     confirm1() {
      this.confirmationService.confirm({
          message: '¿Agregar a carrito?',
          header: 'Confirmacion',
          icon: 'pi pi-shopping-cart',
          accept: () => {
              this.msgs = [{severity:'info', summary:'Carrito', detail:'Se agrego correctamente'}];
          },
          reject: () => {
              this.msgs = [{severity:'info', summary:'Carrito', detail:'Accion cancelada'}];
          }
      });
  }

  ngOnInit() {
    
    this.galleryOptions = [
      {
          width: '600px',
          height: '400px',
          thumbnailsColumns: 4,
          imageAnimation: NgxGalleryAnimation.Zoom,
           
      },
      // max-width 800
      {
          breakpoint: 800,
          width: '100%',
          height: '350px',
          imagePercent: 80,
          thumbnailsPercent: 20,
          thumbnailsMargin: 20,
          thumbnailMargin: 20,
          
      },
      // max-width 400
      {
          breakpoint: 400,
          preview: true,
          thumbnails: false,
          //previewForceFullscreen: true,
          previewCloseOnClick: true,
          previewInfinityMove: true,
          arrowPrevIcon: "pi pi-chevron-left",
          arrowNextIcon: "pi pi-chevron-right"
      }
  ];

  this.galleryImages = [
      {
          small: 'assets/img/abi.png',
          medium: 'assets/img/abi.png',
          big: 'assets/img/abi.png'
      },
      {
          small: 'assets/img/abi2.png',
          medium: 'assets/img/abi2.png',
          big: 'assets/img/abi2-big.png'
      }
  ];

  }

}
