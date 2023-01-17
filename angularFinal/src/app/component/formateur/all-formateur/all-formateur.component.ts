import { Formateur } from './../../../model/formateur';
import { FormateurService } from './../../../services/formateur.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-all-formateur',
  templateUrl: './all-formateur.component.html',
  styleUrls: ['./all-formateur.component.css'],
})
export class AllFormateurComponent implements OnInit {
  formateurs: Formateur[] = [];
  constructor(private formateurService: FormateurService) {}
  ngOnInit(): void {
    this.formateurService.getAll().subscribe((data: Formateur[]) => {
      this.formateurs = data;
    });
  }
}
