package com.mike.mike.Employee.commandHandler;

import com.mike.mike.Employee.Employee;

public class UpdateEmployeeParams {
    private Integer id;
    private Employee employee;

    public UpdateEmployeeParams() {
    }

    public UpdateEmployeeParams(Integer id, Employee employee) {
        this.id = id;
        this.employee = employee;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
