import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { employee } from './entities/employee';
import { Observable } from 'rxjs';
const headers = { 'Content-Type': 'application/json' };

@Injectable({
  providedIn: 'root'
})
export class EmployeeAPIService {
  [x: string]: any;

  constructor(private http: HttpClient) { }

  removeEmployee(data:number){
    return this.http.delete(`http://localhost:8080/deleteEmployee/${data}`).subscribe({
      next: data => {
          console.log('Delete successful');
      },
      error: error => {
          console.log(error);
      }
  });
  }

  saveEmployee(data:employee){

    return this.http.post('http://localhost:8080/createEmployee',
    data
    ,{ headers: new HttpHeaders({ 'Content-Type': 'application/json' }), responseType: 'text' }).toPromise().then((data:any)=>{
      console.log(data)
      });
  }

  updateEmployee(data:any){

    return this.http.put('http://localhost:8080/updateEmployee',
    data
    ,{ headers: new HttpHeaders({ 'Content-Type': 'application/json' }), responseType: 'text' }).toPromise().then((data:any)=>{
      console.log(data)
      });
  }

  getEmployee(): Observable<employee[]>{
    return this.http.get<employee[]>('http://localhost:8080/readEmployee');
  }
}
