import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { PostitsComponent } from './postits/postits.component';
import { PostitComponent } from './postit/postit.component';
import { NotesComponent } from './notes/notes.component';
import { NoteComponent } from './note/note.component';

@NgModule({
  declarations: [
    AppComponent,
    PostitsComponent,
    PostitComponent,
    NotesComponent,
    NoteComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
