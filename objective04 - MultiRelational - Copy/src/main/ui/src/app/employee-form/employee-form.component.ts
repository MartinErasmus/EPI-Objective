import { Component, OnInit } from '@angular/core';
import { EmployeeAPIService } from '../employee-api.service';
const headers = { 'Content-Type': 'application/json' };

@Component({
  selector: 'employee-form',
  templateUrl: './employee-form.component.html',
  styleUrls: ['./employee-form.component.css']
})
export class EmployeeFormComponent implements OnInit {

  constructor(private employeeAPI: EmployeeAPIService) { }

  getEmployeeData(data:any){
    this.employeeAPI.saveEmployee(data);
  }

  ngOnInit(): void {
  }

}
