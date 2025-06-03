import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PublicGuidesComponent } from './public-guides.component';

describe('PublicGuidesComponent', () => {
  let component: PublicGuidesComponent;
  let fixture: ComponentFixture<PublicGuidesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [PublicGuidesComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PublicGuidesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
