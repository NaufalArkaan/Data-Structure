// Main.java
public class Main {

    public static void main(String[] args) {

        EmployeeBST bst =
                new EmployeeBST();

        System.out.println("\n====================================");
        System.out.println("   RAILWAY EMPLOYEE MANAGEMENT BST");
        System.out.println("====================================");

        bst.insert(new Employee(
                100,
                "Naufal",
                "IT"));

        bst.insert(new Employee(
                50,
                "Budi",
                "Finance"));

        bst.insert(new Employee(
                150,
                "Siti",
                "HR"));

        bst.insert(new Employee(
                25,
                "Andi",
                "Security"));

        bst.insert(new Employee(
                75,
                "Rina",
                "Marketing"));

        bst.insert(new Employee(
                125,
                "Dewi",
                "Operations"));

        bst.insert(new Employee(
                175,
                "Fajar",
                "Engineering"));

        bst.displayTree();

        bst.inorderTraversal();

        bst.preorderTraversal();

        bst.postorderTraversal();

        System.out.println("\n====================================");
        System.out.println("SEARCH EMPLOYEE");
        System.out.println("====================================");

        Employee found =
                bst.search(75);

        if (found != null) {

            System.out.println(
                    "Employee Found:"
            );

            System.out.println(found);

        } else {

            System.out.println(
                    "Employee not found!"
            );
        }

        System.out.println("\n====================================");
        System.out.println("MINIMUM EMPLOYEE ID");
        System.out.println("====================================");

        System.out.println(
                bst.findMin()
        );

        System.out.println("\n====================================");
        System.out.println("MAXIMUM EMPLOYEE ID");
        System.out.println("====================================");

        System.out.println(
                bst.findMax()
        );

        System.out.println("\n====================================");
        System.out.println("DELETE EMPLOYEE");
        System.out.println("====================================");

        bst.delete(50);

        System.out.println(
                "\nBST AFTER DELETION:\n"
        );

        bst.displayTree();
    }
}