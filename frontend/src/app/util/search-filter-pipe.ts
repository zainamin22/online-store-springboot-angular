import { Pipe, PipeTransform } from '@angular/core';
import { Product } from '../model/product';

@Pipe({
  name: 'productSearchFilter'
})

export class SearchFilterPipe implements PipeTransform {

  transform(dataList: Product[], args?: string): Product[] {
      if(!dataList) return [];
      if(!args)return dataList;

      return dataList.filter(function(data: Product) {
          return data.name.toLowerCase().includes(args.toLowerCase());
      });
  }

}
