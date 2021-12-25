package main.services;

import main.domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class EmployeeService {
    private static final String URL = "http://localhost:8080/rest/api/employees";

    private final RestTemplate restTemplate;

    @Autowired
    public EmployeeService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Employee> getAll() {
        ResponseEntity<List<Employee>> responseEntity = restTemplate.exchange(URL,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {
                });

        return responseEntity.getBody();
    }

    public void save(Employee employee) {
        if (employee.getId() == 0) {
            ResponseEntity<Employee> responseEntity = restTemplate.postForEntity(URL, employee, Employee.class);
            System.out.println(responseEntity.getBody());
            return;
        }

        restTemplate.put(URL, employee);
        System.out.println("Employee was updated!");
    }

    public Employee get(int id) {
        return restTemplate.getForObject(URL + "/" + id, Employee.class);
    }

    public void delete(int id) {
        restTemplate.delete(URL + "/" + id);
        String message = String.format("Employee with id %s was deleted", id);
        System.out.println(message);
    }
}
