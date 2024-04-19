import { Routes } from '@angular/router';
import { PersonNewComponent } from './pages/person-new/person-new.component';
import { RootNewComponent } from './pages/root-new/root-new.component';
import { PersonUpdateComponent } from './pages/person-update/person-update.component';
import { RootUpdateComponent } from './pages/root-update/root-update.component';

export const routes: Routes = [

  { path: '', redirectTo: '/listar', pathMatch: 'full' },
  { path: 'listar', component: PersonNewComponent },
  { path: 'person-update', component: PersonUpdateComponent },
  { path: 'root', component: RootNewComponent },
  { path: 'root-update', component: RootUpdateComponent },
];
