import { CompteService } from './../services/compte.service';
import { Observable, map } from 'rxjs';
import {
  AbstractControl,
  ValidationErrors,
  ValidatorFn,
  FormGroup,
  AsyncValidatorFn,
} from '@angular/forms';

export class CustomValidator {
  //methodeDeValidation(control:AbstractControl):ValidationErrors|null si pas de parametre

  public static pasChaineToto(
    control: AbstractControl
  ): ValidationErrors | null {
    return control.value == 'toto' ? { toto: true } : null;
  }

  public static pasChaine(chaineInterdite: string): ValidatorFn {
    return (control: AbstractControl): ValidationErrors | null => {
      return control.value == chaineInterdite
        ? { chaineInterdite: true }
        : null;
    };
  }

  public static pasEgaux(control: AbstractControl): ValidationErrors | null {
    let group = control as FormGroup;
    return control.get('control1')?.value == group.get('control2')?.value
      ? { groupEgaux: true }
      : null;
  }

  public static egaux(control: AbstractControl): ValidationErrors | null {
    let group = control as FormGroup;
    return control.get('password')?.value != group.get('confirm')?.value
      ? { pasegaux: true }
      : null;
  }

  public static checkLogin(compteSrv: CompteService): AsyncValidatorFn {
    return (control: AbstractControl): Observable<ValidationErrors | null> => {
      return compteSrv.checkLoginExist(control.value).pipe(
        map((resultat: boolean) => {
          return resultat ? { loginexist: true } : null;
        })
      );
    };
  }
}
