import { LeaveHistory } from './leaveHistory';

export interface UserDetails{
empId:number;
name:string;
joinDate:string;
email:string;
depName:string;
phone:string;
balanceLeave:number;
leaveHistory?:LeaveHistory[];
}