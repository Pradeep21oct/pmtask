import { Injectable } from '@angular/core';
import { catchError, tap } from 'rxjs/operators';
import { HttpHeaders, HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { User } from '../domain/user';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  serverUrls:string='http://localhost:8080/users/'
  allusersUrls:string='http://localhost:8080/allusers/'
  updateUrls:string='http://localhost:8080/users/update/'
  constructor(private http:HttpClient) { }
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type':  'application/json',
     'Cache-Control': 'no-cache'
    
      })
  };
  addUser(user:User):Observable<User[]>{
   // console.log("service   ************"+JSON.stringify(project));
    
   this.http.post<string>(this.serverUrls+'add/',user,this.httpOptions)
   .pipe(catchError(this.handleError));
   return this.http.post<User[]>(this.serverUrls+'add/',user,this.httpOptions).pipe(
    tap(data => console.log('All: ' + JSON.stringify(data))), catchError(this.handleError)
  );
}
getUsers():Observable<string[]>{
  return this.http.get<string[]>(this.allusersUrls).pipe(
    tap(data => console.log('All: ' + JSON.stringify(data))), catchError(this.handleError)
  );

}
updateUser(user:User){
  
   return this.http.get<User[]>(this.updateUrls+user).pipe(
    tap(data => console.log('All: ' + JSON.stringify(data))), catchError(this.handleError)
  );
   
}


getUserDeatils():Observable<User[]>{
  return this.http.get<User[]>(this.serverUrls).pipe(
    tap(data => console.log('All: ' + JSON.stringify(data))), catchError(this.handleError)
  );

}

getUserById(userId:number):Observable<User>{
  return this.http.get<User>(this.serverUrls+userId+'/').pipe(
    tap(data => console.log('All: ' + JSON.stringify(data))), catchError(this.handleError)
  );

}

deleteUser(useid:string):Observable<User[]>{
  // console.log("service   ************"+JSON.stringify(project));
 return this.http.get<User[]>(this.serverUrls+'delete/'+useid).pipe(
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
