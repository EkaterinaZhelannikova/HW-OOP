package lesson7;

import java.util.Objects;

//Создать класс Сотрудник (Employee) с полями:
//Имя, Фамилия (String)
//Название отдела (String)
//Зарплата (double)
//Реализовать equals и hashCode, который работает только с именем и фамилией


public class Employee {

    String name;
    String office;
    double salary;

    public Employee(String name, String office, double salary) {
        this.name = name;
        this.office = office;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;
        return name == employee.name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

}