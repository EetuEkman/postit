import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from "@angular/forms"

import { AppRoutingModule } from './app-routing.module';

import { AppComponent } from './app.component';
import { NotesComponent } from './pages/view-notes/notes/notes.component';
import { NoteComponent } from './pages/view-notes/note/note.component';
import { ViewNotesComponent } from './pages/view-notes/view-notes/view-notes.component';
import { CreateNoteComponent } from './pages/create-note/create-note/create-note.component';
import { UpdateNoteComponent } from './pages/update-note/update-note/update-note.component';


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
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
