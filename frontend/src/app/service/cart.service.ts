import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Cart } from '../model/cart';
import { Product } from '../model/product';

@Injectable({
  providedIn: 'root',
})
export class CartService {
  cartBasePath: string = environment.apiUrl + 'cart-service/';

  constructor(private httpClient: HttpClient) {}

  addToCart(productId: number): Observable<any> {
    return this.httpClient.post(
      this.cartBasePath + 'cart/products',
      new Cart(productId),
      { responseType: 'json' }
    );
  }

  removeFromCart(productId: number): Observable<any> {
    return this.httpClient.delete(
      this.cartBasePath + 'cart/products/' + productId
    );
  }

  getCartProducts(): Observable<Product[]> {
    return this.httpClient.get<Product[]>(this.cartBasePath + 'cart/products', {
      responseType: 'json',
    });
  }
}
