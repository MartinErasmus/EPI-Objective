import { Component, Inject, OnInit } from '@angular/core';
import { MatDialog, MAT_DIALOG_DATA } from '@angular/material/dialog'
import { employee } from '../entities/employee';
import { EmployeeFunctionsService } from '../services/employee-functions.service';



@Component({
  selector: 'app-pop-up',
  templateUrl: './pop-up.component.html',
  styleUrls: ['./pop-up.component.css']
})
export class PopUpComponent implements OnInit {

  actionName;
  Employees: employee[];
  id: string;
  empForm:any;
  constructor(@Inject(MAT_DIALOG_DATA) public data, private employeeFunction: EmployeeFunctionsService,private dailogRef:MatDialog) {
    this.actionName = data.name;
    this.Employees = data.Employees,
      this.id = data.id
      this.empForm=data.formData;
    }


  async executeAction (){
    if (this.actionName=="Delete"){
      this.employeeFunction.getRemoveEmployee(this.Employees, this.id)
      window.location.reload();
    }

    if (this.actionName=="Update"){
     // this.employeeFunction.getRemoveEmployee(this.Employees, this.id)
     console.log(this.empForm)
     this.employeeFunction.getUpdateEmployee(this.Employees,this.empForm)
     window.location.reload();
    }

    if (this.actionName=="Add"){
      console.log(this.empForm.valid)
      this.employeeFunction.getEmployeeData(this.empForm)
     }

 

  }

  closeAction(){
    this.dailogRef.closeAll();
  }

  ngOnInit(): void {
  }

}
