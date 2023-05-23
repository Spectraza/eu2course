import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TTTComponent } from './ttt.component';

describe('TTTComponent', () => {
  let component: TTTComponent;
  let fixture: ComponentFixture<TTTComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TTTComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TTTComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
