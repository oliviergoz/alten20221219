import { Directive, ElementRef, Input, OnInit, Renderer2 } from '@angular/core';

@Directive({
  selector: '[appCouleur]',
})
export class CouleurDirective implements OnInit {
  @Input()
  couleur = 'Red';

  constructor(private element: ElementRef, private renderer: Renderer2) {}

  ngOnInit(): void {
    this.renderer.setStyle(this.element.nativeElement, 'color', this.couleur);
  }
}
