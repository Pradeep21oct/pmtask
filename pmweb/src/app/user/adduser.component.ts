import { Component, OnInit, ViewChild } from '@angular/core';
import { User } from '../domain/user';
import { FormGroup, NgForm } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { UserService } from './user.service';
import { Options } from 'ng5-slider/options';

@Component({
  selector: 'app-adduser',
  templateUrl: './adduser.component.html',
  styleUrls: ['./adduser.component.css']
})
export class AdduserComponent implements OnInit {

  @ViewChild('f') formValue;
  user:User[];
    userForm: FormGroup;
    userid:number;
  constructor(private router:Router,private route: ActivatedRoute,private userService:UserService) {
    this.userid = +this.route.snapshot.paramMap.get("userid")
    this.userService.getUserDeatils().subscribe(usr=>this.user=usr,error=>console.log(error));
    console.log(this.user);
   }
  model=new User();

  ngOnInit() {
    this.userService.getUserDeatils().subscribe(u=>this.user=u,error=>console.log(error));
    console.log(this.user);
  }


  value: number = 0;
  options: Options = {
    floor: 0,
    ceil: 30
  };

  addUser(userForm:NgForm){
 
  console.log(JSON.stringify(userForm.value));
  this.userService.addUser((userForm.value))
  .subscribe(usr=>{
    this.user=usr;
    this.formValue.resetForm();
      
  
  },error=>console.log(error));
  
}

updateUser(use:User){
    this.router.navigate(['/users',use.userid])
}


delete(useid:string){
 
  this.userService.deleteUser((useid))
  .subscribe(usr=>{
    this.user=usr;
   
  },error=>console.log(error));
  
  }


}
