package main;

import main.configuration.SpringConfig;
import main.domain.Employee;
import main.services.EmployeeService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

        EmployeeService employeeService = context.getBean("employeeService", EmployeeService.class);

//        employeeService.delete(21);

        employeeService.getAll()
                .forEach(System.out::println);

//        System.out.println(employeeService.get(18));
//
//        Employee employee = new Employee();
//        employee.setId(21);
//        employee.setSalary(4000);
//        employee.setName("Vitya");
//        employee.setSurname("Leonov");
//        employee.setDepartment("HR");
//
//        employeeService.save(employee);

        context.close();
    }
}
