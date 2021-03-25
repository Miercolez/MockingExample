package uppgift3;

import com.example.Employee;
import com.example.EmployeeRepository;

import java.util.ArrayList;
import java.util.List;

public class InMemoryVersionOfEmployeeRepository implements EmployeeRepository {

    ArrayList<Employee> employees = new ArrayList<>();


    @Override
    public List<Employee> findAll() {
        return employees;
    }

    @Override
    public Employee save(Employee e) {

        if (e.getId().equals("0")) {
            e.setId(String.valueOf(employees.size() + 1));
        }

        for (Employee employee : employees)
            if (e.getId().equals(employee.getId())) {
                employee.setSalary(e.getSalary());
                return e;
            }


        employees.add(e);
        return e;
    }
}
