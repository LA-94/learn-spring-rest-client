package main.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Employee {

    private int id;
    private String name;
    private String surname;
    private String department;
    private int salary;
}
