import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { employee } from '../entities/employee';

@Injectable({
  providedIn: 'root'
})
export class EmployeeFunctionsService {

  constructor() { }
  employeeDefault:any;

  getSearchedEmployee(Employees: employee[],id_num:string): Observable<employee> {
    
    Employees.forEach(employee => {
      if (employee.id_number==id_num) {
         console.log(employee.homeAddress_id.country);
        //this.countryListComponent.updateCountry(employee.homeAddress_id.country)
          return employee;
        }
        else{
         return this.employeeDefault;
        }
    })
   return this.employeeDefault;
  }
}
