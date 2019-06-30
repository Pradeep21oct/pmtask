import { Component, OnInit, ViewChild } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { UserService } from './user.service';
import { User } from '../domain/user';
import { FormGroup, NgForm } from '@angular/forms';

@Component({
  selector: 'app-updateuser',
  templateUrl: './updateuser.component.html',
  styleUrls: ['./updateuser.component.css']
})
export class UpdateuserComponent implements OnInit {

  @ViewChild('f') formValue;
    user:User=new User();
    userForm: FormGroup;
    userid:number;
  constructor(private router:Router,private route: ActivatedRoute,private userService:UserService) {
    this.userid = +this.route.snapshot.paramMap.get("userid");
    this.userService.getUserById(this.userid).subscribe(usr=>this.user=usr,error=>console.log(error));
    console.log(this.user);
   }
    ngOnInit() {
  }

  update(user:User){
 
  
    console.log("Updating"+JSON.stringify(user));
   //// this.userService.updateUser(user);
    
   // this.userService.updateUser(user);
    this.userService.updateUser((user))
    .subscribe(()=>{
          this.router.navigateByUrl('/users');
        
        },error=>console.log(error));

    this.router.navigateByUrl('/users');
  }

  cancel(){
 
      this.router.navigateByUrl('/users');
  }
}


