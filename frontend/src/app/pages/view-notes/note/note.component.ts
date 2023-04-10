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

  random: number;

  // Randomly rotate note slightly

  setStyle() {
    let style = {
      "transform": "rotate(" + this.random.toFixed(3) + "deg)"
    }

    return style;
  }

  constructor(private router: Router) {
    // Random number between -0.25 0.25

    this.random = ((Math.random() - 0.5) / 2);
  }

  onPointerdown() {
    this.router.navigate(["/update", this.note.id])
  }
};
