import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
const headers = { 'Content-Type': 'application/json' };

@Injectable({
  providedIn: 'root'
})
export class EmployeeAPIService {
  [x: string]: any;

  constructor(private http: HttpClient) { }

  saveEmployee(data:any){
    console.warn(data)
    return this.http.post('http://localhost:8080/createEmployee',
    data
    ,{headers}).toPromise().then((data:any)=>{
      console.log(data)
      });
  }
}
