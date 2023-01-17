import { FormateurService } from './../../../services/formateur.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-all-formateur',
  templateUrl: './all-formateur.component.html',
  styleUrls: ['./all-formateur.component.css'],
})
export class AllFormateurComponent implements OnInit {
  formateurs: any[] = [];
  constructor(private formateurService: FormateurService) {}
  ngOnInit(): void {
    this.formateurService.getAll().subscribe((data: any[]) => {
      this.formateurs = data;
    });
  }
}
