import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TarefaLayoutComponent } from './tarefa-layout.component';

describe('TarefaLayoutComponent', () => {
  let component: TarefaLayoutComponent;
  let fixture: ComponentFixture<TarefaLayoutComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [TarefaLayoutComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TarefaLayoutComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
