package com.epi.objective04.controller;

import com.epi.objective04.entity.Employee;
import com.epi.objective04.entity.tempData;
import com.epi.objective04.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    @RequestMapping(value = "createEmployee",method = RequestMethod.POST)
    public String createEmployee(@RequestBody tempData tempdata){
        return employeeService.saveEmployee(tempdata,false);
    }

    @RequestMapping(value = "readEmployee",method = RequestMethod.GET)
    public List<Employee> readEmployee(){
        return employeeService.readEmployees();
    }

//    @RequestMapping(value = "readEmployeeById",method = RequestMethod.POST)
//    public Employee readEmployeeById(){
//        //return employeeService.readEmployeeById();
//    }


    @RequestMapping(value = "updateEmployee",method = RequestMethod.PUT)
    public String updateEmployee(@RequestBody tempData tempdata){
        return employeeService.saveEmployee(tempdata,true);

    }

    @RequestMapping(value="deleteEmployee/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id) {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

//    @RequestMapping(value = "deleteEmployee",method = RequestMethod.DELETE)
//    public String deleteEmployee(@RequestBody Long id){
//        return employeeService.deleteEmployee(id);
//    }
}
