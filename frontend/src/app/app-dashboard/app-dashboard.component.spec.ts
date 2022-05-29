import { ComponentFixture, TestBed } from '@angular/core/testing';
import { FormsModule } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MatCardModule } from '@angular/material/card';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatIconModule } from '@angular/material/icon';
import { MatInputModule } from '@angular/material/input';
import { MatSnackBar, MatSnackBarModule } from '@angular/material/snack-bar';
import { NoopAnimationsModule } from '@angular/platform-browser/animations';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { of } from 'rxjs';
import { CartService } from '../service/cart.service';
import { ProductService } from '../service/product.service';
import { SearchFilterPipe } from '../util/search-filter-pipe';

import { AppDashboardComponent } from './app-dashboard.component';

describe('AppDashboardComponent', () => {
  let component: AppDashboardComponent;
  let fixture: ComponentFixture<AppDashboardComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [AppDashboardComponent, SearchFilterPipe],
      imports: [
        NgbModule,
        MatIconModule,
        MatCardModule,
        MatFormFieldModule,
        MatInputModule,
        FormsModule,
        MatSnackBarModule,
        MatButtonModule,
        NoopAnimationsModule,
      ],
      providers: [
        { provide: ProductService, useValue: { getProducts: () => of([]) } },
        { provide: CartService, useValue: { addToCart: () => of([]) } },
        { provide: MatSnackBar, useValue: { open: () => null } },
      ],
    }).compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AppDashboardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
