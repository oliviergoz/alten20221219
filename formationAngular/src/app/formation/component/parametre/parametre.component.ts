import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-parametre',
  templateUrl: './parametre.component.html',
  styleUrls: ['./parametre.component.css'],
})
export class ParametreComponent implements OnInit {
  prenom = '';

  constructor(
    private activatedRouted: ActivatedRoute,
    private router: Router
  ) {}
  ngOnInit(): void {
    //this.prenom = this.activatedRouted.snapshot.params['prenom'];
    this.activatedRouted.params.subscribe((params) => {
      this.prenom = params['prenom'];
    });
    //si on utilise prenom ici=> pas de resultat garanti
  }

  methode() {
    //on fait un traitement en angular
    //si un probleme on reste ici avec un message
    this.router.navigateByUrl('/home');
  }
}
