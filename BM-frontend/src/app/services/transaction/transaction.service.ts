import { Injectable, inject } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Transaction} from '../../interfaces/transaction';
import {Observable, Subject} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TransactionService {

  httpClient = inject(HttpClient);

  constructor() { }

  transaction: Subject<Transaction> = new Subject<Transaction>();

  addTransaction (transaction: Transaction) {
    this.transaction.next(transaction);
  }

  getTransactions (url: string) {
    return this.httpClient.get<Transaction[]>(url);
  }

  makeTransaction (
    url: string,
    transactionBody: {
      budget_id: string,
      type: string,
      category_id: string,
      amount: number,
      date: string
    }
  ) {
    return this.httpClient.post<Transaction>(url, transactionBody);
  }
}
