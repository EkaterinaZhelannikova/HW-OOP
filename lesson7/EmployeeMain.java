package lesson7;

public class EmployeeMain {
    public static void main(String[] args) {
        Employee o1 = new Employee("Иван Иванов", "Инженер", 50000);
        Employee o2 = new Employee("Иван Иванов", "Слесарь", 35000);
        Employee o3 = new Employee("Семен Иванов", "Директор", 80000);
        Employee o4 = new Employee("Семен Петров", "Токарь", 40000);

        System.out.println(o1 + ", " + o2 + ": " + o1.equals(o2));
        System.out.println(o2 + ", " + o3 + ": " + o2.equals(o3));
        System.out.println(o3 + ", " + o4 + ": " + o3.equals(o4));


        System.out.println(o1.hashCode() == o2.hashCode());
        System.out.println(o2.hashCode() == o3.hashCode());
        System.out.println(o3.hashCode() == o4.hashCode());

    }
}
