import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import Note from 'src/app/models/Note';
import { NoteService } from 'src/app/services/note.service';

@Component({
  selector: 'app-view-notes',
  templateUrl: './view-notes.component.html',
  styleUrls: ['./view-notes.component.css'],
  providers: [NoteService]
})
export class ViewNotesComponent implements OnInit {
  notes: Note[] = [];

  constructor(
    private service: NoteService,
    private router: Router
  ) {

  }

  toCreate() {
    this.router.navigate(["/create"]);
  }

  getNotes() {
    const observable = this.service.getNotes();

    observable.subscribe(fetchedNotes => {
      this.notes = fetchedNotes;
    });
  }

  ngOnInit(): void {
    this.getNotes();
  }
}
