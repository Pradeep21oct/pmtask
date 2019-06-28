import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {RouterModule} from '@angular/router';
import { AppComponent } from './app.component';
import { Ng5SliderModule } from 'ng5-slider';
import { appRoutes } from './routerConfig';

import {FormsModule,ReactiveFormsModule}  from '@angular/forms';
import { from } from 'rxjs';
import { HttpClientModule } from '@angular/common/http';
import { AddprojectComponent } from './project/addproject.component';
import { AdduserComponent } from './user/adduser.component';
import { AddtaskComponent } from './task/addtask.component';
import { ViewtaskComponent } from './viewtask/viewtask.component';
import { UpdateuserComponent } from './user/updateuser.component';
import { UpdateprojectComponent } from './project/updateproject.component';
@NgModule({
  declarations: [
    AppComponent,
    AddprojectComponent,
    AdduserComponent,
    AddtaskComponent,

    ViewtaskComponent,

    UpdateuserComponent,

    UpdateprojectComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    Ng5SliderModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
