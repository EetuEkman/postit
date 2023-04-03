import { Component } from '@angular/core';
import Note from 'src/app/models/Note';
import { NoteService } from 'src/app/services/note.service';

@Component({
  selector: 'app-view-notes',
  templateUrl: './view-notes.component.html',
  styleUrls: ['./view-notes.component.css'],
  providers: [NoteService]
})
export class ViewNotesComponent {
  notes: Note[] = [];

  constructor(private service: NoteService) {

  }

  getNotes() {
    this.service.getNotes()
      .subscribe((fetchedNotes: Note[]) => this.notes = fetchedNotes);
  }
}
