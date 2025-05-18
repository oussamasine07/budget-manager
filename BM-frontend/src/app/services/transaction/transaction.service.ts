import { Injectable, inject } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Transaction} from '../../interfaces/transaction';

@Injectable({
  providedIn: 'root'
})
export class TransactionService {

  httpClient = inject(HttpClient);

  constructor() { }

  getTransactions (url: string) {
    return this.httpClient.get<Transaction[]>(url);
  }
}
