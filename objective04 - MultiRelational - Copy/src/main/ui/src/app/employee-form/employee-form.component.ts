import { DatePipe } from '@angular/common';
import { HttpErrorResponse } from '@angular/common/http';
import { Component, Input, NgModule, OnInit } from '@angular/core';
import { FormControl, FormGroup,Validator, Validators } from '@angular/forms';
import { MAT_DATE_FORMATS } from '@angular/material/core';
import { Observable } from 'rxjs/internal/Observable';
import { CountryListComponent } from '../country-list/country-list.component';
import { EmployeeAPIService } from '../employee-api.service';
import { employee } from '../entities/employee';
import {EmployeeFunctionsService} from '../services/employee-functions.service'
import { MatDialog } from '@angular/material/dialog';
import { PopUpComponent } from '../pop-up/pop-up.component';

@Component({
  selector: 'employee-form',
  templateUrl: './employee-form.component.html',
  styleUrls: ['./employee-form.component.css'],

})

export class EmployeeFormComponent implements OnInit {
  [x: string]: any;
  reactiveForm: FormGroup;
  searchForm:FormGroup;
  public Employees: employee[]=[];
  datepipe: DatePipe = new DatePipe('en-US');
  currentDate:any;




  getDate():string{
    console.log(this.currentDate)
    return this.currentDate;
  }

  updatedCountry:string;
  getupdateCountry():string{
    return this.updatedCountry;
  }
  updateCountry(address:string){
    this.updatedCountry=address;
  }

  updatedWorkCountry:string;
  getupdateWorkCountry():string{
    return this.updatedWorkCountry;
  }
 updateWorkCountry(address:string){
    this.updatedWorkCountry=address;
  }

  updatedCurrency:string;
  getupdatedCurrency():string{
    return this.updatedCurrency;
  }
  updateCurrency(currency:string){
    this.updatedCurrency=currency;
  }



  keyPressNumbers(event) {
    var charCode = (event.which) ? event.which : event.keyCode;
    // Only Numbers 0-9
    if ((charCode < 48 || charCode > 57)) {
      event.preventDefault();
      return false;
    } else {
      return true;
    }
  }

  keyPressLetter(event) {
    var charCode = (event.which) ? event.which : event.keyCode;
    // Only Numbers 0-9
    if ((charCode > 48 || charCode < 57) ) {
      event.preventDefault();
      return false;
    } else {
      return true;
    }
  }
  constructor(private employeeAPI: EmployeeAPIService, private dailogRef:MatDialog,private employeeFunction:EmployeeFunctionsService) { }

  openDialog(actionName:string,id:string){
    this.dailogRef.open(PopUpComponent,{
      data:{
        name:actionName,
        Employees: this.Employees,
        id:id
      }
    })
  }

  openUpdateDialog(actionName:string,formData:any){
    this.dailogRef.open(PopUpComponent,{
      data:{
        name:actionName,
        Employees: this.Employees,
        formData: formData,
      }
    })
  }

    openAddDialog(actionName:string,formData:any){
    this.dailogRef.open(PopUpComponent,{
      data:{
        name:actionName,
        Employees: this.Employees,
        formData: formData,
      }
    })
  }

  getSearchEmployee(){
      this.Employees.forEach(employee => {
        if (employee.id_number==this.searchForm.get('id_num')?.value) {
          this.updateCountry(employee.homeAddress_id.country);
          this.updateWorkCountry(employee.work_Address.country);
          this.updateCurrency(employee.job_info.currency);
          let formattedDate = this.datepipe.transform(employee.dob, 'YYYY-MM-dd')

          this.reactiveForm.patchValue({
            name: employee.name,
            surname: employee.surname,
            email: employee.email,
            dob:formattedDate,
            nationality: employee.nationality,
            id_number: employee.id_number,
            position:employee.job_info.position,
            salary: employee.job_info.salary,
            currency: employee.job_info.currency,
            dwellingType: employee.homeAddress_id.dwellingType,
     
            country:employee.homeAddress_id.country,
            city:employee.homeAddress_id.city,
            province:employee.homeAddress_id.province,
            address:employee.homeAddress_id.address,
            poBox: employee.homeAddress_id.poBox,
            locationType: employee.work_Address.locationType,
            work_country: employee.work_Address.country,
            work_province: employee.work_Address.province,
            work_city: employee.work_Address.city,
            work_address: employee.work_Address.address,
            work_poBox: employee.work_Address.poBox,
          })
          
   
          }
      });
      
  }

  public getEmployees(): void{
    this.employeeAPI.getEmployee().subscribe({
      next: (response: employee[]) => {
        this.Employees = response;
        console.log(response);
      },
      error: (error: HttpErrorResponse) => alert(error.message),
      //complete: () => alert("Employees successfuly loaded")
      //   next: (v) => console.log(v),
      //   error: (e) => console.error(e),
      // complete: () => console.info('complete')
    }
     
    )
  };


  
  today:Date;
  ngOnInit(): void { 
   
    this.today=new Date();
    this.today.setFullYear(this.today.getFullYear()-16);
    this.currentDate=this.datepipe.transform(this.today, 'YYYY-MM-dd');
    this.getDate();
    this.getEmployees();
    this.searchForm= new FormGroup({
      id_num: new FormControl(null)
    });

    this.reactiveForm=new FormGroup({
      name: new FormControl(null,[Validators.required,Validators.pattern("[a-zA-Z ]*")]),
      surname: new FormControl(null,[Validators.required,Validators.pattern("[a-zA-Z ]*")]),
      email: new FormControl(null,[Validators.email,Validators.required]),
      dob:new FormControl(null,[Validators.required]),
      nationality: new FormControl(null,[Validators.required,Validators.pattern("[a-zA-Z ]*")]),
      id_number: new FormControl(null,[Validators.required]),
      position: new FormControl(null,Validators.required),
      salary: new FormControl(null,Validators.required),
      currency: new FormControl(null,Validators.required),
      dwellingType: new FormControl("dwellingType",Validators.required),
      country : new FormControl("Select country ...",Validators.required),
      province: new FormControl(null,Validators.required),
      city: new FormControl(null,Validators.required),
      address: new FormControl(null,Validators.required),
      poBox: new FormControl(null,Validators.required),
      locationType: new FormControl("Location Type",Validators.required),
      work_country: new FormControl(null,Validators.required),
      work_province: new FormControl(null,Validators.required),
      work_city: new FormControl(null,Validators.required),
      work_address: new FormControl(null,Validators.required),
      work_poBox: new FormControl(null,Validators.required),
    });
    //this.reactiveForm.controls['locationType'].setValue("Select Location Type");


   }

}
