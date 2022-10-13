import { homeAddress_id } from "./homeAddress_id";
import { job_info } from "./job_info";
import { work_Address } from "./work_Address";

export interface employee{
    id:string;
    name:string; 
    surname:string;
    nationality:string;
    id_number:string;
    email:string;
    dob:string;
    homeAddress_id:homeAddress_id;
    work_Address:work_Address;
    job_info:job_info;
}