import { Component, OnInit } from '@angular/core';
import { Options } from 'ng5-slider';
import { Task } from '../domain/task';
import { Router, ActivatedRoute } from '@angular/router';
import { ProjectService } from '../project/project.service';
import { UserService } from '../user/user.service';
@Component({
  selector: 'app-addtask',
  templateUrl: './addtask.component.html',
  styleUrls: ['./addtask.component.css']
})
export class AddtaskComponent implements OnInit {

  
  tasks:Task[];
  model=new Task();
  projects:string[];
  users:string[];
  ngOnInit() {
  }
  
  value: number = 0;
  options: Options = {
    floor: 0,
    ceil: 30
  };
  constructor(private router:Router,private route: ActivatedRoute,private projectServivce:ProjectService,private userService:UserService) {

    this.projectServivce.getProjects().subscribe(prj=>this.projects=prj,error=>console.log(error));
    this.userService.getUsers().subscribe(usr=>this.users=usr,error=>console.log(error));
    console.log(this.projects);
   }
}
