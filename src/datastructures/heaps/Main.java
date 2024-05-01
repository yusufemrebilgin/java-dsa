package datastructures.heaps;

import common.model.Employee;
import common.util.EmployeeUtil;
import common.util.RandomManager;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        int capacity = 10;
        List<Employee> employees = EmployeeUtil.generateRandomEmployees(capacity);

        Heap<Employee> minHeap = new Heap<>(capacity, HeapType.MIN_HEAP);
        for (Employee employee : employees) {
            minHeap.insert(employee);
        }

        System.out.println("Heap size: " + minHeap.size());
        System.out.println("Employee IDs in the heap: " + minHeap.stream().map(Employee::getId).toList() + "\n");

        Employee e = employees.get(RandomManager.nextInt(employees.size()));
        System.out.println("Does heap contain " + e.getFirstName() + " " + e.getLastName() + "? " + minHeap.contains(e));
        System.out.println();

        while (!minHeap.isEmpty()) {
            System.out.println("Min element -> " + minHeap.delete());
        }

        System.out.println();
        System.out.println("Is heap empty? " + minHeap.isEmpty());
    }

}
