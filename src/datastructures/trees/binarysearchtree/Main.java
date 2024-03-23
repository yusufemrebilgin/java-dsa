package datastructures.trees.binarysearchtree;

import common.model.Employee;
import common.util.DataSupplier;

import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        int numOfEmployees = 10;

        List<Employee> employees = DataSupplier.generateRandomEmployees(numOfEmployees);
        BinarySearchTree<Employee> tree = new BinarySearchTree<>();

        for (Employee e : employees) {
            System.out.println("Adding employee with ID: " + e.getId());
            tree.insert(e);
        }

        System.out.println("\nInorder traversal:");
        tree.inorder(System.out::println);

        Random random = new Random();
        Employee employee = employees.get(random.nextInt(numOfEmployees));
        tree.delete(employee);

        System.out.println("\nPreorder traversal after deleting employee with ID: " + employee.getId());
        tree.preorder(System.out::println);

        System.out.println();
        System.out.println("Contains employee with id " + employee.getId() + "? : " + tree.contains(employee));
        employee = employees.get(random.nextInt(numOfEmployees));
        System.out.println("Contains employee with id " + employee.getId() + "? : " + tree.contains(employee));

        System.out.println("\nMinimum element: " + tree.findMin());
        System.out.println("Max element: " + tree.findMax());

        System.out.println("\nSize of BST is " + tree.size());
        System.out.println("Height of BST is " + tree.height());

        tree.clear();
        System.out.println("Is BST empty after clearing? : " + tree.isEmpty());
    }
}
