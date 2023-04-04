import { Component, Input, OnInit } from '@angular/core';
import Note from 'src/app/models/Note';
import { NoteService } from 'src/app/services/note.service';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';

@Component({
  selector: 'app-update-note',
  templateUrl: './update-note.component.html',
  styleUrls: ['./update-note.component.css'],
  providers: [NoteService],
})
export class UpdateNoteComponent implements OnInit {
  id: number = -1;

  note: Note = {
    id: -1,
    text: ""
  };

  message = "";

  constructor(
    private service: NoteService,
    private route: ActivatedRoute,
    private router: Router
  ) {

  }

  toIndex() {
    this.router.navigate(["/"]);
  }

  async updateNote() {
    if(this.note.text.length > 200) {
      this.message = "Text limit 200 characters."

      return;
    }

    const observable = this.service.updateNote(this.note);

    observable.subscribe(fetchedNote => {
      this.note = fetchedNote;
      this.router.navigate(["/"]);
    });
  }

  async deleteNote() {
    const observable = this.service.deleteNote(this.note.id);

    observable.subscribe(id => this.router.navigate(["/"], { replaceUrl: true }));
  }

  async getNote() {
    if (this.id === undefined || this.id === null) {
      return;
    }

    const observable = this.service.getNote(this.id);
    
    observable.subscribe({
      next: (fetchedNote) => {
        this.note = fetchedNote;
      },
      error: (error) => {
        switch(error.status) {
          case 0:
            this.message = "Network error.";
            break;
          case 404:
            this.message = "Not found."
            break;
          default:
            this.message = error.message;
            break;
        }
      }
    });
  }

  ngOnInit() {
    this.route.paramMap.subscribe(map => {
      const routeId = Number.parseInt(map.get("id")!);

      if (Number.isNaN(routeId)) {
        this.router.navigate(["/"], { replaceUrl: true });
      }

      this.id = routeId;
    })

    this.getNote();
  }
}
