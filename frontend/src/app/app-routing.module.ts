import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { ViewNotesComponent } from './pages/view-notes/view-notes/view-notes.component';
import { CreateNoteComponent } from './pages/create-note/create-note/create-note.component';
import { UpdateNoteComponent } from './pages/update-note/update-note/update-note.component';

const routes: Routes = [
    { path: '', component: ViewNotesComponent},
    { path: 'create', component: CreateNoteComponent },
    { path: 'update', component: UpdateNoteComponent }
]

@NgModule({
  declarations: [],
  imports: [
    CommonModule
  ]
})
export class AppRoutingModule { }
