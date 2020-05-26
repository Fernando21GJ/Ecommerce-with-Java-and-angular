import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { UsuarioService } from '../business/usuario.service';
import { CustomValidators } from './custom-validators';
import { UsuarioModel } from '../models/usuario.model';

@Component({
  selector: 'app-registro',
  templateUrl: './registro.component.html',
  styleUrls: ['./registro.component.css']
})
export class RegistroComponent implements OnInit {
   usuarioModel = new UsuarioModel();
   nombreInput: string;
   correoInput: string;
   public frmSignup: FormGroup;

  constructor(private usuarioService: UsuarioService, private fb: FormBuilder) {
    this.frmSignup = this.createSignupForm();
  }
  createSignupForm(): FormGroup {
    return this.fb.group(
      {
        nombre:[
          null,
          Validators.compose([ Validators.required,
            CustomValidators.patternValidator(
              /[ !@#$%^&*()_+\-=\[\]{};':"\\|,.<>\/?]/,
              {
                hasSpecialCharacters: false
              }
            )])
        ],
        
        email: [
          null,
          Validators.compose([Validators.email, Validators.required])
        ],
        password: [
          null,
          Validators.compose([
            Validators.required,
            // check whether the entered password has a number
            CustomValidators.patternValidator(/\d/, {
              hasNumber: true
            }),
            // check whether the entered password has upper case letter
            CustomValidators.patternValidator(/[A-Z]/, {
              hasCapitalCase: true
            }),
            // check whether the entered password has a lower case letter
            CustomValidators.patternValidator(/[a-z]/, {
              hasSmallCase: true
            }),
            // check whether the entered password has a special character
            CustomValidators.patternValidator(
              /[ !@#$%^&*()_+\-=\[\]{};':"\\|,.<>\/?]/,
              {
                hasSpecialCharacters: true
              }
            ),
            Validators.minLength(8)
          ])
        ],
        confirmPassword: [null, Validators.compose([Validators.required])]
      },
      {
        // check whether our password and confirm password match
        validator: CustomValidators.passwordMatchValidator
      }
    );
  }
  ngOnInit() {}
  registrarUsuario() {
   console.log(this.usuarioModel);
   this.usuarioService.registrarUsuario(this.usuarioModel);
   console.log('metodo enviado')
  }
  submit() {
    // do signup or something
    console.log(this.frmSignup.value);
    console.log(this.usuarioModel);
    this.usuarioService.registrarUsuario(this.usuarioModel);
    console.log('metodo enviado')
  }
}
