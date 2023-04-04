import { Component, Input } from '@angular/core';
import Note from '../../../models/Note';
import { Router } from '@angular/router';

@Component({
  selector: 'app-note',
  templateUrl: './note.component.html',
  styleUrls: ['./note.component.css']
})
export class NoteComponent {
  @Input() public note!: Note;

  constructor(private router: Router) {

  }

  onPointerdown() {
    this.router.navigate(["/update", this.note.id])
  }
};
