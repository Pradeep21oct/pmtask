import { Injectable } from '@angular/core';
import { Project } from '../domain/project';
import { HttpHeaders, HttpErrorResponse, HttpClient } from '@angular/common/http';
import { catchError, tap, map } from 'rxjs/operators';
import { throwError, Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProjectService {

  serverUrls:string='http://localhost:8080/projects/'
  serverUrl:string='http://localhost:8080/projects/add/'
  allserverUrls:string='http://localhost:8080/allprojects/'
  
  constructor(private http:HttpClient) { }
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type':  'application/json',
     'Cache-Control': 'no-cache',
     'Access-Control-Allow-Origin': '*',
     'credentials': 'include'
      })
  };
  addProject(project:Project):Observable<Project[]>{
   // console.log("service   ************"+JSON.stringify(project));
    
   this.http.post<string>(this.serverUrl,project,this.httpOptions)
   .pipe(catchError(this.handleError));
   return this.http.post<Project[]>(this.serverUrl,project,this.httpOptions).pipe(
    tap(data => console.log('All: ' + JSON.stringify(data))), catchError(this.handleError)
  );
}

getProjectDeatils():Observable<Project[]>{
  return this.http.get<Project[]>(this.serverUrls).pipe(
    tap(data => console.log('All: ' + JSON.stringify(data))), catchError(this.handleError)
  );

}
  
getProjects():Observable<string[]>{
  return this.http.get<string[]>(this.allserverUrls).pipe(
    tap(data => console.log('All: ' + JSON.stringify(data))), catchError(this.handleError)
  );

}


getProjectById(id:number):Observable<Project>{
  return this.http.get<Project>(this.serverUrls+id).pipe(
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
