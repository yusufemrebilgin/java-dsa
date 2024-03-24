package common.util;

import common.model.Employee;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class DataSupplier {

    // hard coded values for generating random instances
    private static final String[] FIRST_NAMES = {
            "Emily", "Alexander", "Sophia", "Benjamin", "Isabella", "William",
            "Olivia", "Noah", "Emma", "Liam"
    };

    private static final String[] LAST_NAMES = {
            "Smith", "Johnson", "Brown", "Lee", "Garcia", "Martinez", "Taylor",
            "Wilson", "Anderson", "Thomas"
    };

    private DataSupplier() {}

    public static List<Employee> generateRandomEmployees(int numOfEmployees) {

        if (numOfEmployees <= 0) {
            throw new IllegalArgumentException("Number of employees cannot be zero or negative");
        }

        List<Employee> employees = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < numOfEmployees; i++) {
            int id = random.nextInt(numOfEmployees * 10);
            String firstName = FIRST_NAMES[random.nextInt(FIRST_NAMES.length)];
            String lastName = LAST_NAMES[random.nextInt(LAST_NAMES.length)];
            String email = firstName.toLowerCase() + lastName.toLowerCase() + "@example.com";
            employees.add(new Employee(id, firstName, lastName, email));
        }
        return employees;
    }

    public static Comparator<Employee> getEmployeeComparatorBy(final String compareBy) {

        return switch (compareBy.toLowerCase()) {
            case "id" -> Comparator.comparing(Employee::getId);
            case "firstname" -> Comparator.comparing(Employee::getFirstName);
            case "lastname" -> Comparator.comparing(Employee::getLastName);
            case "all" -> Comparator.comparing(Employee::getId)
                    .thenComparing(Employee::getFirstName)
                    .thenComparing(Employee::getLastName);
            default -> throw new IllegalArgumentException("Invalid field for comparison: " + compareBy);
        };

    }

}
