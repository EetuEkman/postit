import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError, retry } from 'rxjs/operators';
import Note from '../models/Note';

@Injectable()
export class NoteService {
    url = "http://localhost:5001/api/note";

    constructor(private http: HttpClient) {}

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
                retry(1)
            );
    }

    createNote(text: string): Observable<Note> {
        return this.http.post<Note>(this.url, { text: text })
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

    deleteNote(id: number) {
        return this.http.delete(this.url + "/" + id.toString(), { responseType: "text" })
            .pipe(
                retry(1),
                catchError(this.handleError)
            );
    }

    private handleError(error: HttpErrorResponse) {
        console.log("noteService: handleError: HttpErrorResponse: " + JSON.stringify(error, null, 2));

        switch (error.status) {
            case 0:
                console.error("An error occurred. " + JSON.stringify(error.error));
                break;
            case 404:
                console.error("Error 404 Not found." + JSON.stringify(error.error));

                return throwError(() => new Error("Error 404 Not found."));
            default:
                console.error("An error occurred. " + JSON.stringify(error.error));
                break;
        }

        return throwError(() => new Error("Something went wrong."));
    }
}