import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError, retry } from 'rxjs/operators';
import Note from '../models/Note';

@Injectable()
export class NoteService {
    url = "http://localhost:8080/api/note";

    constructor(private client: HttpClient) {

    }

    getNotes(): Observable<Note[]> {
        return this.client.get<Note[]>(this.url);
    }

    getNote(id: number): Observable<Note> {
        return this.client.get<Note>(this.url + "/" + id.toString())
    }

    createNote(note: Note): Observable<Note> {
        return this.client.post<Note>(this.url, note);
    }

    updateNote(note: Note): Observable<Note> {
        return this.client.put<Note>(this.url, note);
    }

    deleteNote(id: number): Observable<Object> {
        return this.client.delete(this.url + "/" + id.toString());
    }
}