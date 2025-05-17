import {Component, inject, OnInit} from '@angular/core';
import {BudgetServiceService} from '../../services/budget-service/budget-service.service';
import { Budget } from '../../interfaces/budget';
import {Budgets} from '../../interfaces/budgets';
import {NgClass, NgFor} from '@angular/common';

@Component({
  selector: 'app-budget-header',
  imports: [
    NgFor, NgClass
  ],
  templateUrl: './budget-header.component.html',
  styleUrl: './budget-header.component.css'
})
export class BudgetHeaderComponent implements OnInit {
  budgetService = inject(BudgetServiceService)
  budgets: Budget[] | null | undefined = [];

  ngOnInit() {
    this.budgetService.getBudjets("http://localhost:8080/budget").subscribe({
      next: (res: Budget[]) => {
        this.budgets = res;
        console.log(this.budgets);
      }
    })
  }
}
