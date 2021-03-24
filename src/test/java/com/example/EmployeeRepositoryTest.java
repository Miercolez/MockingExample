package com.example;

import java.util.List;

public class EmployeeRepositoryTest implements EmployeeRepository {

    Employee employee = new Employee("01", 2000);

    @Override
    public List<Employee> findAll() {
        return List.of(employee);
    }

    @Override
    public Employee save(Employee e) {
        return null;
    }
}
