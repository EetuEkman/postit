import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ViewNotesComponent } from './pages/view-notes/view-notes/view-notes.component';
import { CreateNoteComponent } from './pages/create-note/create-note/create-note.component';
import { UpdateNoteComponent } from './pages/update-note/update-note/update-note.component';

const routes: Routes = [
  { path: '', component: ViewNotesComponent },
  { path: 'create', component: CreateNoteComponent },
  { path: 'update/:id', component: UpdateNoteComponent }
]

@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [
    RouterModule
  ]
})
export class AppRoutingModule { }
