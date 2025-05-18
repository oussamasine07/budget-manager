import {Component, OnInit, inject } from '@angular/core';
import {Transaction} from '../../interfaces/transaction';
import {TransactionService} from '../../services/transaction/transaction.service';
import {CurrencyPipe, DatePipe, DecimalPipe, NgClass, NgFor} from '@angular/common';

@Component({
  selector: 'app-transctions-list',
  imports: [
    NgFor,
    CurrencyPipe,
    DecimalPipe,
    DatePipe,
    NgClass
  ],
  templateUrl: './transctions-list.component.html',
  styleUrl: './transctions-list.component.css'
})
export class TransctionsListComponent implements OnInit {

  transactionService = inject(TransactionService);

  transactions: Transaction[] | null | undefined = [];

  ngOnInit() {
    this.transactionService.getTransactions("http://localhost:8080/transaction").subscribe({
      next: (res: Transaction[]) => {
        this.transactions = res
        console.log(this.transactions)
      }
    })
  }

}
