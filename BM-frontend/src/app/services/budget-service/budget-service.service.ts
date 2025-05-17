import { Injectable, inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {Budget} from '../../interfaces/budget';



@Injectable({
  providedIn: 'root'
})
export class BudgetServiceService {

  constructor() { }

  httpClient = inject(HttpClient);

  // get all budgets
  getBudjets (url: string) {
    return this.httpClient.get<Budget[]>(url);
  }

}
