import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError, retry } from 'rxjs/operators';
import Note from '../models/Note';

@Injectable()
export class NoteService {
    url = "http://localhost:8080/api/note";

    constructor(private http: HttpClient) {

    }

    getNotes(): Observable<Note[]> {
        return this.http.get<Note[]>(this.url)
            .pipe(
                retry(1),
                catchError(this.handleError)
            );
    }

    getNote(id: number): Observable<Note> {
        return this.http.get<Note>(this.url + "/" + id.toString())
            .pipe(
                retry(1),
                catchError(this.handleError)
            );
    }

    createNote(note: Note): Observable<Note> {
        return this.http.post<Note>(this.url, note)
            .pipe(
                retry(1),
                catchError(this.handleError)
            );
    }

    updateNote(note: Note): Observable<Note> {
        return this.http.put<Note>(this.url, note)
            .pipe(
                retry(1),
                catchError(this.handleError)
            );
    }

    deleteNote(id: number): Observable<Object> {
        return this.http.delete(this.url + "/" + id.toString())
            .pipe(
                retry(1),
                catchError(this.handleError)
            );
    }

    private handleError(error: HttpErrorResponse) {
        if (error.status === 0) {
            console.error("An error occurred. " + error.error);
        }
        else {
            console.error("An error occurred. " + error.error);
        }

        return throwError(() => new Error("Something went wrong."));
    }
}