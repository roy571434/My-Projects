// import { Injectable } from '@angular/core';
// import { Observable } from 'rxjs';
// import { Employee } from './employee';
// import { HttpClient } from '@angular/common/http';

// @Injectable({
//   providedIn: 'root'
// })
// export class EmployeeService {
//   // createEmployee(employee: Employee):Observable<object>
//   // {
//   //   return this.httpClient.post(`${this.baseUrl}`,employee)
//   // }

//   private baseUrl = "http://localhost:9090//api/v1/employees/";

//   constructor(private httpClient:HttpClient) { }
   
//   getEmployeeList():Observable<Employee[]>
//   {
//     return this.httpClient.get<Employee[]>(`${this.baseUrl}`);
//   }
//   createEmployee(employee: Employee): Observable<Object>
//   {
//     return this.httpClient.post(`${this.baseUrl}`, employee);
//   }
// }



import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Employee } from './employee';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {
  private baseUrl = 'http://localhost:9090/api/v1/employees';

  constructor(private http: HttpClient) { }

  getEmployees(): Observable<Employee[]> {
    return this.http.get<Employee[]>(this.baseUrl);
  }

  createEmployee(employee: Employee): Observable<Object> {
    return this.http.post(this.baseUrl, employee);
  }

  getEmployeeById(id: number): Observable<Employee> {
    return this.http.get<Employee>(`${this.baseUrl}/${id}`);
  }

  updateEmployee(id: number, employee: Employee): Observable<Object> {
    return this.http.put(`${this.baseUrl}/${id}`, employee);
  }

  deleteEmployee(id: number):Observable<object>{
    return this.http.delete(`${this.baseUrl}/${id}`);
  }

}
