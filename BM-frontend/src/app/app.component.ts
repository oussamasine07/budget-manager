import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import {BudgetHeaderComponent} from './components/budget-header/budget-header.component';
import {TransctionsListComponent} from './components/transctions-list/transctions-list.component';

@Component({
  selector: 'app-root',
  imports: [
    RouterOutlet,
    BudgetHeaderComponent, TransctionsListComponent
  ],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'BM-frontend';
}
