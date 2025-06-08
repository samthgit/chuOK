import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PhraseManagementComponent } from './phrase-management.component';

describe('PhraseManagementComponent', () => {
  let component: PhraseManagementComponent;
  let fixture: ComponentFixture<PhraseManagementComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [PhraseManagementComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PhraseManagementComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
