import {Component, OnInit, inject, Input, Output, EventEmitter} from '@angular/core';
import { FormsModule } from '@angular/forms';
import {BudgetServiceService} from '../../services/budget-service/budget-service.service';
import {Budget} from '../../interfaces/budget';
import {NgFor} from '@angular/common';
import {CategoryService} from '../../services/category/category.service';
import {Category} from '../../interfaces/category';
import {TransactionService} from '../../services/transaction/transaction.service';
import {Router, RouterLink} from '@angular/router';
import {Transaction} from '../../interfaces/transaction';

@Component({
  selector: 'app-create-transaction',
  imports: [
    FormsModule, NgFor, RouterLink
  ],
  templateUrl: './create-transaction.component.html',
  styleUrl: './create-transaction.component.css',
  standalone: true
})
export class CreateTransactionComponent implements OnInit {

  router = inject(Router);

  budgetService = inject(BudgetServiceService)
  categoryService = inject(CategoryService);
  transactionService = inject(TransactionService);

  @Output() transactionEventEmitter = new EventEmitter();

  budgets: Budget[] | null | undefined = [];
  categories: Category[] | null | undefined = [];

  ngOnInit() {
    this.budgetService.getBudjets("http://localhost:8080/budget").subscribe({
      next: (res: Budget[]) => {
        this.budgets = res;
        console.log(this.budgets)
      }
    })

    this.categoryService.getCategories("http://localhost:8080/category").subscribe({
      next: (res: Category[]) => {
        this.categories = res
      }
    })
  }

  transactionsObj = {
    budget_id: "",
    type: "",
    category_id: "",
    amount: 0,
    date: ""
  }

  onMakeTransactionSubmit (form: FormsModule) {

    this.transactionService
          .makeTransaction("http://localhost:8080/transaction", this.transactionsObj)
          .subscribe({
            next: (transaction: Transaction) => {
              this.transactionService.addTransaction(transaction);
            }
          })

    this.transactionsObj = {
      budget_id: "",
      type: "",
      category_id: "",
      amount: 0,
      date: ""
    }

    this.router.navigate(["/"]);

  }
}












