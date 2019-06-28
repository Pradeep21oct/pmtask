import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'lmp-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Project Manager';
constructor(private router:Router){};
 

  getUser():string{
    
    return '';
  }
  logOut(): void {
    
  }

  addProject(){
    this.router.navigateByUrl('/projects')
   }

   addUser(){
    this.router.navigateByUrl('/users')
   }

   
  addTask(){
    this.router.navigateByUrl('/tasks')
   }

   

   
   viewTask(){
    this.router.navigateByUrl('/viewtask')
   }
}
