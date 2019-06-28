import{ Routes} from '@angular/router';
import { AddprojectComponent } from './project/addproject.component';
import { AdduserComponent } from './user/adduser.component';
import { AddtaskComponent } from './task/addtask.component';
import { ViewtaskComponent } from './viewtask/viewtask.component';
import { UpdateuserComponent } from './user/updateuser.component';
import { UpdateprojectComponent } from './project/updateproject.component';
export  const appRoutes:Routes=[
   
    { path: 'projects', component: AddprojectComponent },
    { path: 'projects/:projectid', component: UpdateprojectComponent },
    { path: 'users', component: AdduserComponent },
    {path:'users/:userid',component:UpdateuserComponent},
    { path: 'tasks', component: AddtaskComponent },
    { path: 'viewtask', component: ViewtaskComponent },
    {path:'', redirectTo:'projects', pathMatch:'full'},
    {path:'**', redirectTo:'projects', pathMatch:'full'}    
    
];