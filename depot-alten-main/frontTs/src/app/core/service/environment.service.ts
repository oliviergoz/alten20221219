import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {environment as env} from '@owlink-env/environment';

export interface Environment {
  oweb1: string;
  oweb2: string;
  apiUrl: string;
  oauthUrl: string;
  owlinkweb1Url: string;
  owlinkweb2Url: string;
}

@Injectable({
  providedIn: 'root'
})
export class EnvironmentService {

  private environment: Environment;

  constructor(private http: HttpClient) {}

  load() {
    return this.http.get('environment.json')
      .toPromise()
      .then((environment: Environment) => {
        this.environment = environment;
      }).catch((e) => {
        console.error('Une erreur est survenue lors du chargement du fichier de variables d\'environnements !', env.production ? '' : e);

        if (!env.production) {
          console.warn(
              'Si le fichier src/environments/environment.json n\'est pas présent exécutez la commande suivante :',
              'cp src/environments/environment.example.json src/environments/environment.json'
          );
        }

        return Promise.reject();
      });
  }

  get<T extends keyof Environment>(attribute?: T): Readonly<Environment[T] | Environment> {
    if (attribute) {
      return this.environment[attribute];
    }

    return this.environment;
  }
}
