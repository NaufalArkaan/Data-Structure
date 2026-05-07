// EmployeeBST.java
public class EmployeeBST {

    BSTNode root;

    public void insert(Employee employee) {

        root = insertRec(root, employee);

        System.out.println(
                "Employee added: "
                        + employee.name
        );
    }

    private BSTNode insertRec(BSTNode current,
                              Employee employee) {

        if (current == null) {
            return new BSTNode(employee);
        }

        if (employee.compareTo(current.data) < 0) {

            current.left =
                    insertRec(current.left,
                            employee);

        } else if (employee.compareTo(current.data) > 0) {

            current.right =
                    insertRec(current.right,
                            employee);
        }

        return current;
    }

    public Employee search(int employeeId) {

        BSTNode found =
                searchRec(root, employeeId);

        if (found == null) {
            return null;
        }

        return found.data;
    }

    private BSTNode searchRec(BSTNode current,
                              int employeeId) {

        if (current == null) {
            return null;
        }

        if (employeeId ==
                current.data.employeeId) {

            return current;
        }

        if (employeeId <
                current.data.employeeId) {

            return searchRec(
                    current.left,
                    employeeId
            );
        }

        return searchRec(
                current.right,
                employeeId
        );
    }

    public void delete(int employeeId) {

        root = deleteRec(root, employeeId);

        System.out.println(
                "Employee deleted: "
                        + employeeId
        );
    }

    private BSTNode deleteRec(BSTNode current,
                              int employeeId) {

        if (current == null) {
            return null;
        }

        if (employeeId <
                current.data.employeeId) {

            current.left =
                    deleteRec(
                            current.left,
                            employeeId
                    );

        } else if (employeeId >
                current.data.employeeId) {

            current.right =
                    deleteRec(
                            current.right,
                            employeeId
                    );

        } else {

            if (current.left == null
                    && current.right == null) {

                return null;
            }

            if (current.left == null) {
                return current.right;
            }

            if (current.right == null) {
                return current.left;
            }

            BSTNode successor =
                    findMinNode(current.right);

            current.data = successor.data;

            current.right =
                    deleteRec(
                            current.right,
                            successor.data.employeeId
                    );
        }

        return current;
    }

    private BSTNode findMinNode(BSTNode current) {

        while (current.left != null) {
            current = current.left;
        }

        return current;
    }

    public void displayTree() {

        System.out.println("\n========================================");
        System.out.println("      EMPLOYEE BST VISUAL TREE");
        System.out.println("========================================\n");

        if (root == null) {
            System.out.println("Tree is empty!");
            return;
        }

        printVisualTree(root);
    }

    private void printVisualTree(BSTNode root) {

        System.out.println(
                "                 "
                        + root.data.employeeId
                        + " - "
                        + root.data.name
        );

        System.out.println(
                "               /                 \\"
        );

        if (root.left != null && root.right != null) {

            System.out.printf(
                    "      %-20s %-20s\n",
                    root.left.data.employeeId
                            + " - "
                            + root.left.data.name,

                    root.right.data.employeeId
                            + " - "
                            + root.right.data.name
            );
        }

        System.out.println(
                "        /        \\           /        \\"
        );

        String leftLeft = "";
        String leftRight = "";
        String rightLeft = "";
        String rightRight = "";

        if (root.left != null) {

            if (root.left.left != null) {

                leftLeft =
                        root.left.left.data.employeeId
                                + " - "
                                + root.left.left.data.name;
            }

            if (root.left.right != null) {

                leftRight =
                        root.left.right.data.employeeId
                                + " - "
                                + root.left.right.data.name;
            }
        }

        if (root.right != null) {

            if (root.right.left != null) {

                rightLeft =
                        root.right.left.data.employeeId
                                + " - "
                                + root.right.left.data.name;
            }

            if (root.right.right != null) {

                rightRight =
                        root.right.right.data.employeeId
                                + " - "
                                + root.right.right.data.name;
            }
        }

        System.out.printf(
                "%-18s %-18s %-18s %-18s\n",
                leftLeft,
                leftRight,
                rightLeft,
                rightRight
        );
    }

    public void inorderTraversal() {

        System.out.println("\n====================================");
        System.out.println("INORDER TRAVERSAL");
        System.out.println("LEFT -> ROOT -> RIGHT");
        System.out.println("====================================");

        inorderRec(root);

        System.out.println();
    }

    private void inorderRec(BSTNode current) {

        if (current != null) {

            inorderRec(current.left);

            System.out.println(current.data);

            inorderRec(current.right);
        }
    }

    public void preorderTraversal() {

        System.out.println("\n====================================");
        System.out.println("PREORDER TRAVERSAL");
        System.out.println("ROOT -> LEFT -> RIGHT");
        System.out.println("====================================");

        preorderRec(root);

        System.out.println();
    }

    private void preorderRec(BSTNode current) {

        if (current != null) {

            System.out.println(current.data);

            preorderRec(current.left);

            preorderRec(current.right);
        }
    }

    public void postorderTraversal() {

        System.out.println("\n====================================");
        System.out.println("POSTORDER TRAVERSAL");
        System.out.println("LEFT -> RIGHT -> ROOT");
        System.out.println("====================================");

        postorderRec(root);

        System.out.println();
    }

    private void postorderRec(BSTNode current) {

        if (current != null) {

            postorderRec(current.left);

            postorderRec(current.right);

            System.out.println(current.data);
        }
    }

    public Employee findMin() {

        BSTNode current = root;

        while (current.left != null) {
            current = current.left;
        }

        return current.data;
    }

    public Employee findMax() {

        BSTNode current = root;

        while (current.right != null) {
            current = current.right;
        }

        return current.data;
    }
}