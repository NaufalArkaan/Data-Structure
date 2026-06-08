public class Main {
    public static void main(String[] args) {
        RailwayGraph graph = new RailwayGraph();

        // Add Stations
        graph.addStation(
                "SBY",
                "Stasiun Gubeng",
                "Surabaya");

        graph.addStation(
                "MLG",
                "Stasiun Malang",
                "Malang");

        graph.addStation(
                "JKT",
                "Stasiun Gambir",
                "Jakarta");

        graph.addStation(
                "BDG",
                "Stasiun Bandung",
                "Bandung");

        // Add Routes
        graph.addRoute(
                "SBY",
                "MLG",
                90,
                120,
                45000);

        graph.addRoute(
                "SBY",
                "JKT",
                780,
                600,
                350000);

        graph.addRoute(
                "JKT",
                "BDG",
                150,
                180,
                80000);

        // Print Graph
        graph.printGraph();

        // Get Connections
        graph.getConnections("SBY");

        // BFS dan DFS
        graph.bfsTraversal("SBY");

        graph.dfsTraversal("SBY");

        graph.findPathBFS("MLG", "BDG");
    }
}