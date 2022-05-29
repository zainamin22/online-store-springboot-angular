import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Product } from '../model/product';
import { CartService } from '../service/cart.service';
import { ProductService } from '../service/product.service';

@Component({
  selector: 'app-app-dashboard',
  templateUrl: './app-dashboard.component.html',
  styleUrls: ['./app-dashboard.component.scss'],
})
export class AppDashboardComponent implements OnInit {
  searchText: string = '';
  dataList: Product[] = [];

  constructor(
    private productService: ProductService,
    private cartService: CartService,
    private snackBar: MatSnackBar
  ) {}

  ngOnInit(): void {
    this.productService.getProducts().subscribe((data: Product[]) => {
      this.dataList = data;
    });
  }

  addToCart(productId: number) {
    this.cartService.addToCart(productId).subscribe((response) => {
      this.snackBar.open('Added to Cart', 'Dismiss', {
        duration: 2000,
      });
    });
  }
}
