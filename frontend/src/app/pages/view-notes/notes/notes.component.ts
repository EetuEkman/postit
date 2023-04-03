import { Component, Input } from '@angular/core';
import Note from 'src/app/models/Note';

@Component({
  selector: 'app-notes',
  templateUrl: './notes.component.html',
  styleUrls: ['./notes.component.css']
})
export class NotesComponent {
  @Input() notes: Note[] = [];
}
