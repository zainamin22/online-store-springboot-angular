import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Product } from '../model/product';
import { CartService } from '../service/cart.service';

@Component({
  selector: 'app-app-cart',
  templateUrl: './app-cart.component.html',
  styleUrls: ['./app-cart.component.scss'],
})
export class AppCartComponent implements OnInit {
  dataList: Product[] = [];
  total: number = 0;
  constructor(
    private cartService: CartService,
    private snackBar: MatSnackBar
  ) {}

  removeFromCart(product: Product) {
    this.cartService.removeFromCart(product.id).subscribe((response) => {
      this.snackBar.open('Removed from Cart', 'Dismiss', {
        duration: 2000,
      });

      this.dataList = this.dataList.filter((item) => item.id !== product.id);
      this.total -= product.price;
    });
  }

  ngOnInit(): void {
    this.cartService.getCartProducts().subscribe((data: Product[]) => {
      this.dataList = data;
      data.forEach((item) => (this.total += item.price));
    });
  }
}
