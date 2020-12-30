package com.example.myPackage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {
        Employee john = new Employee("John Doe", 30);
        Employee tim = new Employee("Tim buch", 21);
        Employee jack = new Employee("Jack Hill", 40);
        Employee snow = new Employee("Snow White", 21);
        Employee red = new Employee("Red Ridinood", 35);
        Employee charming = new Employee("Prince Charm", 35);

        List<Employee> employees = new ArrayList<>();
        employees.add(john);
        employees.add(tim);
        employees.add(jack);
        employees.add(snow);
        employees.add(red);
        employees.add(charming);

        Function<Employee, String> getLastName = (employee) -> {
            return employee.getName().substring(employee.getName().indexOf(' ') + 1);
        };

        Function<Employee, String> getFirstName = (employee) -> {
            return employee.getName().substring(0, employee.getName().indexOf(' '));
        };

        

        String lastName = getLastName.apply(employees.get(1));
        System.out.println(lastName);

//        printEmployeesByAge(employees,"Employees over 30", employee -> employee.getAge() > 30);
//        printEmployeesByAge(employees,"Employees 30 and under", employee -> employee.getAge() <= 30);
//
//        printEmployeesByAge(employees, "Employees younger than 25", new Predicate<Employee>() {
//            @Override
//            public boolean test(final Employee employee) {
//                return employee.getAge() < 25;
//            }
//        });
//
//        IntPredicate greaterThan15 = i -> i > 15;
//        IntPredicate lessThan100 = i -> i < 100;
//
//
//        System.out.println(greaterThan15.test(10));
//        int a = 20;
//        System.out.println(greaterThan15.test(a + 5));
//        System.out.println(greaterThan15.and(lessThan100).test(50));
//        System.out.println(greaterThan15.and(lessThan100).test(15));
//
//        Random random = new Random();
//        Supplier<Integer> randomSupplier = () -> random.nextInt(1000);
//        for (int i = 0; i < 10; i++){
//            System.out.println(randomSupplier.get());
//        }
//
//        employees.forEach(employee -> {
//            String lastName = employee.getName().substring(employee.getName().indexOf(' ') + 1);
//            System.out.println("Last Name is: " + lastName);
//        });

    }

    private static void printEmployeesByAge(List<Employee> employees, String ageText,
                                        Predicate<Employee> ageCondition){
        System.out.println(ageText);
        System.out.println("+++++++++++++++");
        for (Employee employee: employees){
            if (ageCondition.test(employee)){
                System.out.println(employee.getName());
            }
        }
    }
}
