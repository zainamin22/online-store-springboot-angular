import { ComponentFixture, TestBed } from '@angular/core/testing';
import { MatIconModule } from '@angular/material/icon';
import { MatListModule } from '@angular/material/list';
import { MatSnackBar, MatSnackBarModule } from '@angular/material/snack-bar';
import { NoopAnimationsModule } from '@angular/platform-browser/animations';
import { EMPTY, of } from 'rxjs';
import { CartService } from '../service/cart.service';

import { AppCartComponent } from './app-cart.component';

describe('AppCartComponent', () => {
  let component: AppCartComponent;
  let fixture: ComponentFixture<AppCartComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [AppCartComponent],
      imports: [
        NoopAnimationsModule,
        MatIconModule,
        MatListModule,
        MatSnackBarModule,
      ],
      providers: [
        {
          provide: CartService,
          useValue: {
            removeFromCart: () => EMPTY,
            getCartProducts: () => of([]),
          },
        },
        { provide: MatSnackBar, useValue: { open: () => null } },
      ],
    }).compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AppCartComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('AppCartComponent is initialized', () => {
    expect(component).toBeTruthy();
  });
});
