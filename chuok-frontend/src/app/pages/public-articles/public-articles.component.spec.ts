import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PublicArticlesComponent } from './public-articles.component';

describe('PublicArticlesComponent', () => {
  let component: PublicArticlesComponent;
  let fixture: ComponentFixture<PublicArticlesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [PublicArticlesComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PublicArticlesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
