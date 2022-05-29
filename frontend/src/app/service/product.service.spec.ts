import { HttpClient } from '@angular/common/http';
import { TestBed } from '@angular/core/testing';
import { of } from 'rxjs';
import { Product } from '../model/product';

import { ProductService } from './product.service';

describe('ProductService', () => {
  let service: ProductService;
  const httpClientSpy = jasmine.createSpyObj('HttpClient', ['get']);
  const TEST_PRODUCT_ID: number = 1;

  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [{ provide: HttpClient, useValue: httpClientSpy }],
    });
    service = TestBed.inject(ProductService);
  });

  it('ProductService is created', () => {
    expect(service).toBeTruthy();
  });

  it('All product retrieved', () => {
    httpClientSpy.get.and.returnValue(
      of([new Product(TEST_PRODUCT_ID, 'testProduct', 500)])
    );
    service.getProducts().subscribe((response) => {
      expect(response[0].id).toBe(TEST_PRODUCT_ID);
    });
  });
});
