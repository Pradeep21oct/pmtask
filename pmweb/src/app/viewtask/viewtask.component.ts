import { Component, OnInit } from '@angular/core';
import { Task } from '../domain/task';

@Component({
  selector: 'app-viewtask',
  templateUrl: './viewtask.component.html',
  styleUrls: ['./viewtask.component.css']
})
export class ViewtaskComponent implements OnInit {

  constructor() { }
  tasks:Task[];
  model=new Task();
  ngOnInit() {
  }

}
