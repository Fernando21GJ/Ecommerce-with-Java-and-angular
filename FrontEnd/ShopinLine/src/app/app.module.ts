import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {CommonModule} from '@angular/common';
// import {MultiSelectModule} from 'primeng/multiselect';
import { AppComponent } from './app.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import { InicioComponent } from './inicio/inicio.component';
import { LoginComponent } from './login/login.component';
import { RegistroComponent } from './registro/registro.component';
import { RecuperarComponent } from './recuperar/recuperar.component';
import { CategoriaComponent } from './categoria/categoria.component';
import { ProductoComponent } from './producto/producto.component';
import { LocalizacionComponent } from './localizacion/localizacion.component';
import { AppRoutingModule } from './app-routing.module';
import { MenuComponent } from './menu/menu.component';
import {SidebarModule} from 'primeng/sidebar';
import {ButtonModule} from 'primeng/button';
import {GalleriaModule} from 'primeng/galleria';
import { ProdutosComponent } from './produtos/produtos.component';
import {CarouselModule} from 'primeng/carousel';
import { FooterComponent } from './footer/footer.component';
import { AdministradorComponent } from './administrador/administrador.component';
import { CarritoComponent } from './carrito/carrito.component';
 import {ScrollPanelModule} from 'primeng/scrollpanel';
 import { FormsModule } from '@angular/forms';
 import {DropdownModule} from 'primeng/dropdown';
 import {SplitButtonModule} from 'primeng/splitbutton';
 import {ToastModule} from 'primeng/toast';
import {DataViewModule} from 'primeng/dataview';
import {PanelModule} from 'primeng/panel';
import {DialogModule} from 'primeng/dialog';
import {HttpClientModule, HttpClient} from '@angular/common/http';
import { WebServiceService } from './business/web-service.service';
import {CardModule} from 'primeng/card';
import {SpinnerModule} from 'primeng/spinner';
import {ConfirmDialogModule} from 'primeng/confirmdialog';
import {ConfirmationService} from 'primeng/api';
import {MessagesModule} from 'primeng/messages';
import {MessageModule} from 'primeng/message';
import {LightboxModule} from 'primeng/lightbox';
import 'hammerjs';
import {NgxGalleryModule} from 'ngx-gallery';
import {TabViewModule} from 'primeng/tabview';
import {SliderModule} from 'primeng/slider';
import {RatingModule} from 'primeng/rating';
import {FieldsetModule} from 'primeng/fieldset';
import {SlideMenuModule} from 'primeng/slidemenu';
import {MenuModule} from 'primeng/menu';
import {CATEGORIAService} from './business/categoria.service';
import {UsuarioService} from './business/usuario.service';
import { ReactiveFormsModule } from '@angular/forms';










@NgModule({
  declarations: [
    AppComponent,
    InicioComponent,
    LoginComponent,
    RegistroComponent,
    RecuperarComponent,
    CategoriaComponent,
    ProductoComponent,
    LocalizacionComponent,
    MenuComponent,
    ProdutosComponent,
    FooterComponent,
    AdministradorComponent,
    CarritoComponent,
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    AppRoutingModule,
    ButtonModule,
    GalleriaModule,
    CarouselModule,
    DropdownModule,
    DialogModule,
    DataViewModule,
    SidebarModule,
    // MultiSelectModule,
    CardModule,
    SpinnerModule,
    ConfirmDialogModule,
    MessagesModule,
    ScrollPanelModule,
    LightboxModule,
    RatingModule,
    NgxGalleryModule,
    PanelModule,
    CommonModule,
    TabViewModule,
    SliderModule,
    ToastModule,
    FormsModule,
    SplitButtonModule,
    FieldsetModule,
    SlideMenuModule,
    MenuModule,
    HttpClientModule,
    ReactiveFormsModule


  ],
  providers: [ConfirmationService,
              UsuarioService,
              CATEGORIAService
  ],
  bootstrap: [AppComponent],

})
export class AppModule { }
