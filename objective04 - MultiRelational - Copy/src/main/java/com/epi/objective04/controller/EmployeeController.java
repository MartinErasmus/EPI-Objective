package com.epi.objective04.controller;

import com.epi.objective04.entity.Employee;
import com.epi.objective04.entity.tempData;
import com.epi.objective04.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "createEmployee",method = RequestMethod.POST)
    public String createEmployee(@RequestBody tempData tempdata){
        return employeeService.createEmployee(tempdata);
    }

    @RequestMapping(value = "readEmployee",method = RequestMethod.GET)
    public List<Employee> readEmployee(){
        return employeeService.readEmployees();
    }

    @RequestMapping(value = "updateEmployee",method = RequestMethod.PUT)
    public String updateEmployee(@RequestBody Employee employee){
        return employeeService.updateEmployee(employee);
    }

    @RequestMapping(value = "deleteEmployee",method = RequestMethod.DELETE)
    public String deleteEmployee(@RequestBody Long id){

        return employeeService.deleteEmployee(id);
    }
}
