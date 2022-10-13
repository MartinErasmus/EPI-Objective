
import { Component } from '@angular/core';
import { EmployeeAPIService } from './employee-api.service';
import { employee } from './entities/employee';
const headers = { 'Content-Type': 'application/json' };
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'EPI Employee Form';
 
  
  
  constructor(private employeeAPI: EmployeeAPIService){

  }

  getEmployeeData(data:any){
    this.employeeAPI.saveEmployee(data);
  }
}
