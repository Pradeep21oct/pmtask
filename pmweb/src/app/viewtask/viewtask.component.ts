import { Component, OnInit } from '@angular/core';
import { Task } from '../domain/task';
import { Router, ActivatedRoute } from '@angular/router';
import { TaskService } from '../task/task.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-viewtask',
  templateUrl: './viewtask.component.html',
  styleUrls: ['./viewtask.component.css']
})
export class ViewtaskComponent implements OnInit {

  constructor(private router:Router,private route: ActivatedRoute,private taskService:TaskService) {


    this.taskService.getTasks().subscribe(t=>this.tasks=t,error=>console.log(error));
  }
  tasks:Task[];
  project:string;
  model=new Task();
  ngOnInit() {
  }
  search(taskForm:NgForm){
    // console.log(projectForm.form);
     //this.project=projectForm.form.value;
     console.log(JSON.stringify(taskForm.value));
     this.taskService.search((taskForm.value))
     .subscribe(t=>{
       this.tasks=t;
      
         
     
     },error=>console.log(error));
     
   }


   endTask(taskId:string){
    // console.log(projectForm.form);
     //this.project=projectForm.form.value;
     console.log(JSON.stringify(taskId));
     this.taskService.endTask((taskId))
     .subscribe(t=>{
       this.tasks=t;
       },error=>console.log(error));
     
   }
}
