// BSTNode.java
public class BSTNode {

    Employee data;

    BSTNode left;
    BSTNode right;

    public BSTNode(Employee data) {
        this.data = data;
    }

    public boolean isLeaf() {
        return left == null && right == null;
    }
}