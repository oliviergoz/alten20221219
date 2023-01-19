import { AbstractControl, ValidationErrors, ValidatorFn } from '@angular/forms';

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
}
