import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GovSchemeComponent } from './gov-scheme.component';

describe('GovSchemeComponent', () => {
  let component: GovSchemeComponent;
  let fixture: ComponentFixture<GovSchemeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GovSchemeComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GovSchemeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
