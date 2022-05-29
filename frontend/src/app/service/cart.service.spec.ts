import { HttpClient } from '@angular/common/http';
import { TestBed } from '@angular/core/testing';
import { of } from 'rxjs';
import { Product } from '../model/product';

import { CartService } from './cart.service';

describe('CartService', () => {
  let service: CartService;
  const TEST_PRODUCT_ID: number = 1;
  const httpClientSpy = jasmine.createSpyObj('HttpClient', [
    'post',
    'get',
    'delete',
  ]);

  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [{ provide: HttpClient, useValue: httpClientSpy }],
    });
    service = TestBed.inject(CartService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  it('addToCart should call POST', () => {
    httpClientSpy.post.and.returnValue(
      of({ status: 201, data: { productId: TEST_PRODUCT_ID } })
    );
    service.addToCart(TEST_PRODUCT_ID).subscribe((response) => {
      expect(response.status).toBe(201);
      expect(response.data.productId).toBe(TEST_PRODUCT_ID);
    });
  });

  it('removeFromCart should call DELETE', () => {
    httpClientSpy.delete.and.returnValue(of({ status: 204, data: {} }));
    service.removeFromCart(TEST_PRODUCT_ID).subscribe((response) => {
      expect(response.status).toBe(204);
    });
  });

  it('getCartProducts should call GET', () => {
    httpClientSpy.get.and.returnValue(
      of([new Product(TEST_PRODUCT_ID, 'testProduct', 500)])
    );
    service.getCartProducts().subscribe((response) => {
      expect(response[0].id).toBe(TEST_PRODUCT_ID);
    });
  });
});
