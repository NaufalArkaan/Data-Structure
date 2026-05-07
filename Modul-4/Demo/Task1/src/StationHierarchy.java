import java.util.LinkedList;
import java.util.Queue;

public class StationHierarchy {
    private StationNode root;

    public void setRoot(String code, String name, String region) {
        root = new StationNode(code, name, region);
    }

    public StationNode getRoot() {
        return root;
    }

    public void addStation(String parentCode, String code, String name, String region) {
        StationNode parentNode = findStation(parentCode);

        if (parentNode == null) {
            System.out.println("Parent station not found!");
            return;
        }

        StationNode newStation = new StationNode(code, name, region);
        parentNode.addChild(newStation);

        System.out.println("Station added: " + newStation.stationName);
    }

    public StationNode findStation(String code) {
        return findStationRec(root, code);
    }

    private StationNode findStationRec(StationNode current, String code) {
        if (current == null) {
            return null;
        }

        if (current.stationCode.equals(code)) {
            return current;
        }

        for (StationNode child : current.children) {
            StationNode found = findStationRec(child, code);
            if (found != null) {
                return found;
            }
        }
        return null;
    }

    public void removeStation(String code) {
        if (root == null) {
            return;
        }

        if (root.stationCode.equals(code)) {
            System.out.println("Root station cannot be removed!");
            return;
        }

        StationNode target = findStation(code);

        if (target == null) {
            System.out.println("Station not found!");
            return;
        }

        StationNode parent = target.parent;

        for (StationNode child : target.children) {
            parent.addChild(child);
        }

        parent.removeChild(target);

        System.out.println("Station removed: " + target.stationName);
    }

    public void displayVisualTree() {
        System.out.println("\n========================================");
        System.out.println("      STATION HIERARCHY TREE");
        System.out.println("========================================\n");
        System.out.println(
                "                Indonesia Central Station"
        );
        System.out.println(
                "                 /        |        \\"
        );
        System.out.println(
                "                /         |         \\"
        );
        System.out.println(
                "               /          |          \\"
        );
        System.out.println(
                "      Jakarta Station  Surabaya Station  Bandung Station"
        );
        System.out.println(
                "          /      \\          /      \\"
        );
        System.out.println(
                "         /        \\        /        \\"
        );
        System.out.println(
                "Gambir Station  Pasar Senen  Gubeng Station  Pasar Turi"
        );
    }

    public void displayTree() {
        System.out.println("\n====================================");
        System.out.println("     RAILWAY STATION HIERARCHY");
        System.out.println("====================================");
        displayTreeRec(root, "", true);
    }

    private void displayTreeRec(StationNode node, String prefix, boolean isLast) {
        if (node == null) {
            return;
        }

        System.out.println(
                prefix
                        + (isLast ? "└── " : "├── ")
                        + node.stationName
                        + " [" + node.stationCode + "]"
                        + " - "
                        + node.region
        );

        for (int i = 0; i < node.children.size(); i++) {
            boolean lastChild =
                    (i == node.children.size() - 1);

            displayTreeRec(
                    node.children.get(i),
                    prefix + (isLast ? "    " : "│   "),
                    lastChild
            );
        }
    }

    public void preOrderTraversal() {
        System.out.println("\n====================================");
        System.out.println("PREORDER TRAVERSAL");
        System.out.println("ROOT -> CHILDREN");
        System.out.println("====================================");
        preOrderRec(root);
        System.out.println();
    }

    private void preOrderRec(StationNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.stationName + " -> ");
        for (StationNode child : node.children) {
            preOrderRec(child);
        }
    }

    public void postOrderTraversal() {
        System.out.println("\n====================================");
        System.out.println("POSTORDER TRAVERSAL");
        System.out.println("CHILDREN -> ROOT");
        System.out.println("====================================");
        postOrderRec(root);
        System.out.println();
    }

    private void postOrderRec(StationNode node) {
        if (node == null) {
            return;
        }
        for (StationNode child : node.children) {
            postOrderRec(child);
        }
        System.out.print(node.stationName + " -> ");
    }

    public void levelOrderTraversal() {
        System.out.println("\n====================================");
        System.out.println("LEVEL ORDER TRAVERSAL (BFS)");
        System.out.println("====================================");
        if (root == null) {
            return;
        }
        Queue<StationNode> queue = new LinkedList<>();
        queue.offer(root);

        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            System.out.print("Level "
                    + level
                    + ": ");
            for (int i = 0; i < size; i++) {
                StationNode current =
                        queue.poll();
                System.out.print(
                        current.stationName + " | "
                );
                for (StationNode child : current.children) {
                    queue.offer(child);
                }
            }
            System.out.println();
            level++;
        }
    }

    public int totalStations() {
        return countStations(root);
    }

    private int countStations(StationNode node) {
        if (node == null) {
            return 0;
        }

        int count = 1;
        for (StationNode child : node.children) {
            count += countStations(child);
        }
        return count;
    }

    public int treeHeight() {
        return calculateHeight(root);
    }

    private int calculateHeight(StationNode node) {
        if (node == null) {
            return 0;
        }

        int maxHeight = 0;
        for (StationNode child : node.children) {
            int childHeight =
                    calculateHeight(child);
            maxHeight =
                    Math.max(maxHeight, childHeight);
        }
        return maxHeight + 1;
    }
}