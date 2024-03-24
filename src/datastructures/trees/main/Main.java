package datastructures.trees.main;

import common.model.Employee;
import common.util.DataSupplier;
import datastructures.trees.BinaryTree;
import datastructures.trees.TraversalOrder;
import datastructures.trees.avl.AVLTree;
import datastructures.trees.binarysearchtree.BinarySearchTree;

import java.util.List;
import java.util.Random;

public class Main {

    public enum TreeStructure { BINARY_SEARCH_TREE, AVL_TREE }

    public static void main(String[] args) {
        testTree(TreeStructure.BINARY_SEARCH_TREE);
        System.out.println("\n" + "-".repeat(120) + "\n");
        testTree(TreeStructure.AVL_TREE);
    }

    public static void testTree(TreeStructure structure) {
        BinaryTree<Employee> tree = createTree(structure);
        List<Employee> employees = DataSupplier.generateRandomEmployees(10);

        for (Employee e : employees) {
            System.out.println("Adding employee with ID: " + e.getId());
            tree.insert(e);
        }

        System.out.println("\nInorder traversal:");
        tree.traverse(TraversalOrder.INORDER, System.out::println);

        System.out.println("\nSize of " + tree.getClass().getSimpleName() + " is " + tree.size());
        System.out.println("Height of " + tree.getClass().getSimpleName() + " is " + tree.height());

        Random random = new Random();
        Employee employee = employees.get(random.nextInt(employees.size()));
        tree.delete(employee);

        System.out.println("\nPreorder traversal after deleting employee with ID: " + employee.getId());
        tree.traverse(TraversalOrder.PREORDER, System.out::println);

        System.out.println();
        System.out.println("Is tree contains employee with id " + employee.getId() + "? : " + tree.contains(employee));
        employee = employees.get(random.nextInt(employees.size()));
        System.out.println("Is tree contains employee with id " + employee.getId() + "? : " + tree.contains(employee));

        System.out.println("\nMinimum element: " + tree.findMin());
        System.out.println("Maximum element: " + tree.findMax());

        System.out.println("\nSize of " + tree.getClass().getSimpleName() + " is " + tree.size());
        System.out.println("Height of " + tree.getClass().getSimpleName() + " is " + tree.height());

        tree.clear();
        System.out.println("\nIs " + tree.getClass().getSimpleName() + " empty after clearing? : " + tree.isEmpty());

    }

    private static BinaryTree<Employee> createTree(TreeStructure structure) {
        return switch (structure) {
            case BINARY_SEARCH_TREE -> new BinarySearchTree<>();
            case AVL_TREE -> new AVLTree<>();
        };
    }

}
