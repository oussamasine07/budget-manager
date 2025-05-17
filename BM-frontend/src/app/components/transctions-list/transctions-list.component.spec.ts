import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TransctionsListComponent } from './transctions-list.component';

describe('TransctionsListComponent', () => {
  let component: TransctionsListComponent;
  let fixture: ComponentFixture<TransctionsListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [TransctionsListComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TransctionsListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
