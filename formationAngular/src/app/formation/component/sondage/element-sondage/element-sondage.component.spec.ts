import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ElementSondageComponent } from './element-sondage.component';

describe('ElementSondageComponent', () => {
  let component: ElementSondageComponent;
  let fixture: ComponentFixture<ElementSondageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ElementSondageComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ElementSondageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
