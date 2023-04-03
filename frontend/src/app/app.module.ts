import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { NotesComponent } from './notes/notes.component';
import { NoteComponent } from './note/note.component';
import { ViewNotesComponent } from './pages/view-notes/view-notes/view-notes.component';
import { CreateNoteComponent } from './pages/create-note/create-note/create-note.component';
import { UpdateNoteComponent } from './pages/update-note/update-note/update-note.component';
import { AppRoutingModule } from './app-routing.module';

@NgModule({
  declarations: [
    AppComponent,
    NotesComponent,
    NoteComponent,
    ViewNotesComponent,
    CreateNoteComponent,
    UpdateNoteComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
