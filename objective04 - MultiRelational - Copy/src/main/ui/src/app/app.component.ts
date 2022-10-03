
import { Component } from '@angular/core';
import { EmployeeAPIService } from './employee-api.service';
const headers = { 'Content-Type': 'application/json' };
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'ui';
  postData={
    "name":"Martin2",
    "email":"535@gmail.com"
  }
  
  constructor(private employeeAPI: EmployeeAPIService){

  }

  getEmployeeData(data:any){
    this.employeeAPI.saveEmployee(data);
  }
}
