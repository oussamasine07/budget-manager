import { Injectable, inject } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Category} from '../../interfaces/category';

@Injectable({
  providedIn: 'root'
})
export class CategoryService {

  httpClient = inject(HttpClient);

  constructor() { }

  getCategories (url: string) {
    return this.httpClient.get<Category[]>(url);
  }

}
