export class Task{
    constructor(
        public startDate:Date=new Date(),
        public endDate:Date=new Date(),
        public priority:number=0,
        public status:string='',
        public taskId:string='',
        public taskName:string='',
        public parent:string='',
        public project:string=''
       ){}
       
}