import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { EmployeeAPIService } from '../employee-api.service';
import { employee } from '../entities/employee';
import { MatDialog } from '@angular/material/dialog';
import {ErrorPopUpComponent} from '../error-pop-up/error-pop-up.component'

@Injectable({
  providedIn: 'root'
})
export class EmployeeFunctionsService {
  
  constructor(private employeeAPI: EmployeeAPIService) { }
  employeeDefault:any;

  getRemoveEmployee(Employees: employee[],id:string){
    Employees.forEach(employee => {
      if (employee.id_number==id) {
        this.employeeAPI.removeEmployee(parseInt(employee.id));
      }
    });
  }

  getUpdateEmployee(Employees: employee[],data:any){
    Employees.forEach(employee => {
      if (employee.id_number==data.id_number) {
        this.employeeAPI.updateEmployee(data);
      }
    });
  }

  getEmployeeData(empForm:any){
    if(empForm.valid==true){
       this.employeeAPI.saveEmployee(empForm.value);
    }

    
  }


}
