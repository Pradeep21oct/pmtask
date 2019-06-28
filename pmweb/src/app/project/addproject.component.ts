import { Component, OnInit,ViewChild } from '@angular/core';
import {FormBuilder,FormGroup,Validator, FormControl, NgForm} from '@angular/forms';
import { Project } from '../domain/project';
import { ProjectService } from './project.service';
import { Router, ActivatedRoute } from '@angular/router';
import { modelGroupProvider } from '@angular/forms/src/directives/ng_model_group';
import {Sort} from '@angular/material/sort';

import { Options } from 'ng5-slider';
@Component({
  selector: 'app-addproject',
  templateUrl: './addproject.component.html',
  styleUrls: ['./addproject.component.css']
})
export class AddprojectComponent implements OnInit {

 @ViewChild('f') formValue;
  project:Project[];
  projectForm: FormGroup;
  isadduser:boolean=false;
  sortedData: Project[];
  constructor(private router:Router,private route: ActivatedRoute,private projectServivce:ProjectService) {
   
    this.projectServivce.getProjectDeatils().subscribe(prj=>this.project=prj,error=>console.log(error));
   // this.sortedData = this.project.slice();
    console.log(this.project);
   }
  model=new Project();

  ngOnInit() {
    this.projectServivce.getProjectDeatils().subscribe(prj=>this.project=prj,error=>console.log(error));
    console.log(this.project);
    this.isadduser=true;
  }

  
  value: number = 0;
  options: Options = {
    floor: 0,
    ceil: 30
  };

  
onSubmit(projectForm:NgForm){
 // console.log(projectForm.form);
  //this.project=projectForm.form.value;
  console.log(JSON.stringify(projectForm.value));
  this.projectServivce.addProject((projectForm.value))
  .subscribe(proj=>{
    this.project=proj;
    this.formValue.resetForm();
      
  
  },error=>console.log(error));
  
}

update(proj:Project){
  console.log("Updates88888888888888888888    "+JSON.stringify(proj));

       this.router.navigate(['/projects',proj.projectId])
  
}
sortData(sort: Sort) {
  const data = this.project.slice();
  if (!sort.active || sort.direction === '') {
    this.sortedData = data;
    return;
  }

  this.sortedData = data.sort((a, b) => {
    const isAsc = sort.direction === 'asc';
    switch (sort.active) {
      case 'projectName': return compare(a.projectName, b.projectName, isAsc);
      case 'noOfTask': return compare(a.noOfTask, b.noOfTask, isAsc);
      case 'priority': return compare(a.priority, b.priority, isAsc);
      case 'status': return compare(a.status, b.status, isAsc);
      case 'projectManager': return compare(a.projectManager, b.projectManager, isAsc);
      default: return 0;
    }
  });
}
suspends(proj:Project){
  console.log("Suspends 777777777777777  "+JSON.stringify(proj));
}
reset(){
  
  this.formValue.resetForm();

 }
 
}
function compare(a: number | string, b: number | string, isAsc: boolean) {
  return (a < b ? -1 : 1) * (isAsc ? 1 : -1);
  
}