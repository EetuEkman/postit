import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { NotesComponent } from './notes/notes.component';
import { NoteComponent } from './note/note.component';
import { ViewNotesComponent } from './pages/view-notes/view-notes/view-notes.component';
import { CreateNoteComponent } from './create-note/create-note.component';

@NgModule({
  declarations: [
    AppComponent,
    NotesComponent,
    NoteComponent,
    ViewNotesComponent,
    CreateNoteComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
