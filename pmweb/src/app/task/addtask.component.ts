import { Component, OnInit, ViewChild } from '@angular/core';
import { Options } from 'ng5-slider';
import { Task } from '../domain/task';
import { Router, ActivatedRoute } from '@angular/router';
import { ProjectService } from '../project/project.service';
import { UserService } from '../user/user.service';
import { TaskService } from './task.service';
import { NgForm, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-addtask',
  templateUrl: './addtask.component.html',
  styleUrls: ['./addtask.component.css']
})
export class AddtaskComponent implements OnInit {

  @ViewChild('f') formValue;
  tasks:Task[];
  model=new Task();
  projects:string[];
  users:string[];
  taskNames:string[];
  taskForm: FormGroup;
  ngOnInit() {
  }
  
  value: number = 0;
  options: Options = {
    floor: 0,
    ceil: 30
  };
  constructor(private router:Router,private route: ActivatedRoute,private taskService:TaskService,private projectServivce:ProjectService,private userService:UserService) {

    this.projectServivce.getProjects().subscribe(prj=>this.projects=prj,error=>console.log(error));
    this.userService.getUsers().subscribe(usr=>this.users=usr,error=>console.log(error));
    this.taskService.getParents().subscribe(t=>this.taskNames=t,error=>console.log(error));
    console.log(this.projects);
   }

   addTask(taskForm:NgForm){
    // console.log(projectForm.form);
     //this.project=projectForm.form.value;
     console.log(JSON.stringify(taskForm.value));
     this.taskService.addTask((taskForm.value))
     .subscribe(t=>{
       this.tasks=t;
       this.formValue.resetForm();
         
     
     },error=>console.log(error));
     
   }
}



