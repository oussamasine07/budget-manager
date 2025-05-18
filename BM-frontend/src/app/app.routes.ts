import { Routes } from '@angular/router';
import {TransctionsListComponent} from './components/transctions-list/transctions-list.component';
import {CreateTransactionComponent} from './components/create-transaction/create-transaction.component';

export const routes: Routes = [
  {
    path: "",
    component: TransctionsListComponent
  },
  {
    path: "create-transaction",
    component: CreateTransactionComponent
  }
];
