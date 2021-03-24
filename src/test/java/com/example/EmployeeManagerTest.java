package com.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.*;

class EmployeeManagerTest {

    @Test
    @DisplayName("Paying Employee")
    void payingEmployee() {
        BankServiceTest bankService = new BankServiceTest();
        EmployeeRepositoryTest employeeRepository = new EmployeeRepositoryTest();
        EmployeeManager employeeManager = new EmployeeManager(employeeRepository, bankService);

        var actual = employeeManager.payEmployees();

        assertThat(actual).isEqualTo(1);
        assertThat(employeeRepository.employee.isPaid()).isTrue();
    }

    @Test
    @DisplayName("Not paying Employee")
    void notPayingEmployee() {
        Employee employee = Mockito.spy(new Employee("01", 2000));
        BankService bankService = mock(BankService.class);
        EmployeeRepository employeeRepository = mock(EmployeeRepository.class);
        EmployeeManager employeeManager = new EmployeeManager(employeeRepository, bankService);

        when(employeeRepository.findAll()).thenReturn(List.of(employee));

        doThrow(new RuntimeException()).when(bankService).pay("01", 2000);

        assertEquals(0, employeeManager.payEmployees());
        assertFalse(employee.isPaid());
    }


}