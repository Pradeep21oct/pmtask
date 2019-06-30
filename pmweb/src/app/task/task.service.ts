import { Injectable } from '@angular/core';

import { HttpHeaders, HttpErrorResponse, HttpClient } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError, tap } from 'rxjs/operators';
import { Task } from '../domain/task';

@Injectable({
  providedIn: 'root'
})
export class TaskService {
  serverUrls:string='http://localhost:8080/tasks/'
  serverUrl:string='http://localhost:8080/tasks/add/'
  allserverUrls:string='http://localhost:8080/alltask/'
  searchserverUrls:string='http://localhost:8080/tasks/search/'
  endserverUrls:string='http://localhost:8080/tasks/endtask/'
  constructor(private http:HttpClient) { }
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type':  'application/json',
     'Cache-Control': 'no-cache',
     'Access-Control-Allow-Origin': '*',
     'credentials': 'include'
      })
  };
  
  addTask(task:Task):Observable<Task[]>{
    // console.log("service   ************"+JSON.stringify(project));
     
    this.http.post<string>(this.serverUrl,task,this.httpOptions)
    .pipe(catchError(this.handleError));
    return this.http.post<Task[]>(this.serverUrl,task,this.httpOptions).pipe(
     tap(data => console.log('All: ' + JSON.stringify(data))), catchError(this.handleError)
   );
 }
 getTasks():Observable<Task[]>{
  return this.http.get<Task[]>(this.serverUrls).pipe(
    tap(data => console.log('All: ' + JSON.stringify(data))), catchError(this.handleError)
  );

}

search(project:string):Observable<Task[]>{
  return this.http.get<Task[]>(this.searchserverUrls+project).pipe(
    tap(data => console.log('All: ' + JSON.stringify(data))), catchError(this.handleError)
  );

}
getParents():Observable<string[]>{
  return this.http.get<string[]>(this.allserverUrls).pipe(
    tap(data => console.log('All: ' + JSON.stringify(data))), catchError(this.handleError)
  );

}
endTask(taskId:string):Observable<Task[]>{
  return this.http.get<Task[]>(this.endserverUrls+taskId).pipe(
    tap(data => console.log('All: ' + JSON.stringify(data))), catchError(this.handleError)
  );

}
private handleError(err: HttpErrorResponse) {
    
  let errorMessage = '';
  if (err.error instanceof ErrorEvent) {
    errorMessage = `An error occurred: ${err.error.message}`;
  } else {
   
    errorMessage = `Server returned code: ${err.status}, error message is: ${err.message}`;
  }
  console.error(errorMessage);
  return throwError(errorMessage);
}
}
