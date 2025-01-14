// import { Component, OnInit } from '@angular/core';
// import { Employee } from '../employee';
// import { EmployeeService } from '../employee.service';

// @Component({
//   selector: 'app-employee-list',
//   templateUrl: './employee-list.component.html',
//   styleUrls: ['./employee-list.component.css']
// })
// export class EmployeeListComponent implements OnInit 
// {
//   employees!: Employee[];
//   constructor(private employeeService:EmployeeService ){ this.employees=[]}
//   ngOnInit(): void 
//   {
//     this.getEmployees();   
//   }

//   private getEmployees() {
//     this.employeeService.getEmployees().subscribe(data => {this.employees = data;});
//   }
// }
import { Component, OnInit } from '@angular/core';
import { EmployeeService } from '../employee.service';
import { Employee } from '../employee';
import { Router } from '@angular/router';

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css']
})
export class EmployeeListComponent implements OnInit {

  employees!: Employee[];

  constructor(private employeeService: EmployeeService, private router: Router) { }

  ngOnInit(): void {
    this.getEmployees();
  }

  private getEmployees() {
    this.employeeService.getEmployees().subscribe((data: Employee[]) => {
      this.employees = data;
    });
  }

  updateEmployee(id: number)
  {
    this.router.navigate(['update-employee',id]);
  }

  deleteEmployee(id: number) {
    this.employeeService.deleteEmployee(id).subscribe(data => {console.log(data);this.getEmployees();});
  }

  employeeDetails(id: number){
    this.router.navigate(['employee-details',id]);
  }

}
