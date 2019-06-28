import { Component, OnInit, ViewChild } from '@angular/core';
import { Project } from '../domain/project';
import { FormGroup } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { ProjectService } from './project.service';

@Component({
  selector: 'app-updateproject',
  templateUrl: './updateproject.component.html',
  styleUrls: ['./updateproject.component.css']
})
export class UpdateprojectComponent implements OnInit {

  @ViewChild('f') formValue;
  project:Project;
  projectForm: FormGroup;
  isadduser:boolean=false;
  projectid:number=0;
  constructor(private router:Router,private route: ActivatedRoute,private projectServivce:ProjectService) {
    this.projectid=+this.route.snapshot.paramMap.get("projectid");
    console.log(this.project);
    this.projectServivce.getProjectById(this.projectid)
    .subscribe(prj=>this.project=prj,error=>console.log(error));
    console.log(this.project);
   }
  
  ngOnInit() {
  }

}
