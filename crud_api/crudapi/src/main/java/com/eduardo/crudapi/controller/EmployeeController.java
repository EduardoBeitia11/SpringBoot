package com.eduardo.crudapi.controller;

import com.eduardo.crudapi.ErrorHandling.ErrorHandlerException;
import com.eduardo.crudapi.entity.EmployeeEntity;
import com.eduardo.crudapi.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService theEmployeeService){
        employeeService=theEmployeeService;
    }

    @GetMapping("/employees")
    public List<EmployeeEntity> findAll(){
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public EmployeeEntity findEmployee(@PathVariable int employeeId){

        if (employeeId < 1){
            throw new ErrorHandlerException("employeeId tiene que ser mayor a 0");
        }

        EmployeeEntity theEmployee = employeeService.findById(employeeId);

        if (theEmployee == null){
            throw new ErrorHandlerException("Empleado no encontrado");
        }

        return theEmployee;
    }

    @PostMapping("/employees")
    public EmployeeEntity addEmployee(@RequestBody EmployeeEntity theEmployee){

        //id = 0 to force adding a new item instead of updating
        theEmployee.setId(0);

        EmployeeEntity dbEmploye = employeeService.save(theEmployee);

        return dbEmploye;
    }

    @PutMapping("/employees")
    public EmployeeEntity updateEmployee(@RequestBody EmployeeEntity theEmployee){

        EmployeeEntity dbEmployee = employeeService.save(theEmployee);

        return dbEmployee;
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){

        if (employeeId < 1){
            throw new ErrorHandlerException("Employee with id: " + employeeId + "not found");
        }

        EmployeeEntity tempEmployee = employeeService.findById(employeeId);

        if (tempEmployee==null){
            throw new ErrorHandlerException("Employee with id: " + employeeId + "not found");
        }

        employeeService.deleteById(employeeId);

        return "Employee with id: " + employeeId + "successfully deleted";
    }
}
