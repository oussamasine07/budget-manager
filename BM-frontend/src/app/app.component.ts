import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import {BudgetHeaderComponent} from './components/budget-header/budget-header.component';

@Component({
  selector: 'app-root',
  imports: [
    RouterOutlet,
    BudgetHeaderComponent
  ],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'BM-frontend';
}
