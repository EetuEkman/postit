import { Component } from '@angular/core';
import { Router } from '@angular/router';
import Note from 'src/app/models/Note';
import { NoteService } from 'src/app/services/note.service';

@Component({
  selector: 'app-create-note',
  templateUrl: './create-note.component.html',
  styleUrls: ['./create-note.component.css'],
  providers: [NoteService]
})
export class CreateNoteComponent {
  text = "";
  message = "";

  constructor(
    private router: Router,
    private service: NoteService
  ) {

  }

  toIndex() {
    this.router.navigate(["/"]);
  }

  async createNote() {
    if (this.text.length > 200) {
      this.message = "Text limit 200 characters."

      return;
    }

    const observable = this.service.createNote(this.text);

    observable.subscribe(createdNote => {
      this.router.navigate(["/"]);
    });
  }
}
