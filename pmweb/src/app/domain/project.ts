export class Project{
    constructor(
        public startDate:Date=new Date(),
        public endDate:Date=new Date(),
        public priority:number=0,
        public noOfTask:number=0,
        public projectId:string='',
        public projectName:string='',
        public projectManager:string='',
        public status:string=''
       ){}
       
}