package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Application {

    public static void main(String[] args) {
        List<Employee> employeeListOne = new ArrayList<>(Arrays.asList(
                new Employee("Vasja", 2500),
                new Employee("Petja", 1500),
                new Employee("Maria", 4800),
                new Employee("Max", 2800)));
        List<Employee> employeeListTwo = new ArrayList<>(Arrays.asList(
                new Employee("Katja", 1500),
                new Employee("Max", 2000),
                new Employee("Alex", 3000),
                new Employee("Vovan", 1700)));
        Department dep100a = new Department("Sototschka", "100_a", employeeListOne);
        Department dep111b = new Department("Sototschka", "111_b", employeeListTwo);
        Department dep121b = new Department("Sototschka", "121_b", employeeListTwo);

        long limit = 2000;
        String depSort = "111";

        Stream<Department> streams = Stream.of(dep100a, dep111b,dep121b);

        long res = streams.filter(dep -> dep.getCode().split("_")[0].equals(depSort))
                .flatMap(department -> department.getEmployees().stream())
                .filter(employee -> employee.getSalary() >= limit)
                .count();

        System.out.println(res);
    }
}
