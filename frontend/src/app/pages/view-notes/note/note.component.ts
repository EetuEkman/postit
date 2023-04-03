import { Component, Input } from '@angular/core';
import Note from '../../../models/Note';

@Component({
  selector: 'app-note',
  templateUrl: './note.component.html',
  styleUrls: ['./note.component.css']
})
export class NoteComponent {
  @Input() public note!: Note;

  onPointerdown() {
    console.log("Redirect to edit page with id " + this.note.id.toString())
  }
};
