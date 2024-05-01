package common.util;

import common.model.Employee;

import java.util.*;

public class EmployeeUtil {

    // hard coded values for generating random instances
    private static final String[] FIRST_NAMES = {
            "Emily", "Alexander", "Sophia", "Benjamin", "Isabella", "William",
            "Olivia", "Noah", "Emma", "Liam"
    };

    private static final String[] LAST_NAMES = {
            "Smith", "Johnson", "Brown", "Lee", "Garcia", "Martinez", "Taylor",
            "Wilson", "Anderson", "Thomas"
    };

    private static final String EMAIL_SUFFIX = "@example.com";

    private EmployeeUtil() {}

    public static List<Employee> generateRandomEmployees(int numOfEmployees) {
        if (numOfEmployees <= 0) {
            throw new IllegalArgumentException("Number of employees cannot be zero or negative");
        }

        List<Employee> employees = new ArrayList<>();
        Set<String> emails = new HashSet<>();

        for (int i = 0; i < numOfEmployees; i++) {
            int id = RandomManager.nextInt(numOfEmployees * 10);
            String firstName = FIRST_NAMES[RandomManager.nextInt(FIRST_NAMES.length)];
            String lastName = LAST_NAMES[RandomManager.nextInt(LAST_NAMES.length)];
            String email = generateEmail(firstName, lastName);
            String uniqueEmail = emails.add(email) ? email : generateUniqueEmail(email, emails);
            employees.add(new Employee(id, firstName, lastName, uniqueEmail));
        }
        return employees;
    }

    private static String generateEmail(String firstName, String lastName) {
        return firstName.toLowerCase(Locale.ENGLISH) + lastName.toLowerCase(Locale.ENGLISH) + EMAIL_SUFFIX;
    }

    private static String generateUniqueEmail(String email, Set<String> existingEmails) {
        String emailPrefix = email.split("@")[0];
        int suffix = 1;
        while (existingEmails.contains(email)) {
            email = emailPrefix + suffix++ + EMAIL_SUFFIX;
        }
        existingEmails.add(email);
        return email;
    }

    public static Comparator<Employee> getEmployeeComparator(ComparisonField compareBy) {
        return switch (compareBy) {
            case ID -> Comparator.comparing(Employee::getId);
            case FIRST_NAME -> Comparator.comparing(Employee::getFirstName);
            case LAST_NAME -> Comparator.comparing(Employee::getLastName);
            case ALL -> Comparator.comparing(Employee::getId)
                    .thenComparing(Employee::getFirstName)
                    .thenComparing(Employee::getLastName);
        };

    }

    public enum ComparisonField {
        ID, FIRST_NAME, LAST_NAME, ALL
    }

}
