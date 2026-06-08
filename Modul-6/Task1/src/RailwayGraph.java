import java.util.*;

public class RailwayGraph {
    // Menyimpan data station
    private HashMap<String, Station> stations;

    // Adjacency List
    private HashMap<String, ArrayList<Route>> adjacencyList;

    public RailwayGraph() {
        stations = new HashMap<>();
        adjacencyList = new HashMap<>();
    }

    // Add Station
    public void addStation(String code, String name, String city) {
        Station station = new Station(code, name, city);

        stations.put(code, station);
        adjacencyList.putIfAbsent(code, new ArrayList<>());
    }

    // Add Route (Undirected Graph)
    public void addRoute(String source, String destination, int distance, int travelTime, double fare) {
        adjacencyList.get(source)
                .add(new Route(
                        destination,
                        distance,
                        travelTime,
                        fare));

        adjacencyList.get(destination)
                .add(new Route(
                        source,
                        distance,
                        travelTime,
                        fare));
    }

    // Get Connections
    public void getConnections(String stationCode) {
        System.out.println("\nConnections from " + stationCode);

        for (Route route : adjacencyList.get(stationCode)) {
            System.out.println(route);
        }
    }

    // Remove Route
    public void removeRoute(String source, String destination) {
        adjacencyList.get(source)
                .removeIf(route -> route.destination.equals(destination));

        adjacencyList.get(destination)
                .removeIf(route -> route.destination.equals(source));
    }

    // Remove Station
    public void removeStation(String stationCode) {
        adjacencyList.remove(stationCode);

        for (ArrayList<Route> routes : adjacencyList.values()) {
            routes.removeIf(route -> route.destination.equals(stationCode));
        }

        stations.remove(stationCode);
    }

    // Print Graph
    public void printGraph() {
        for (String stationCode : adjacencyList.keySet()) {
            System.out.println("\n" + stations.get(stationCode));

            for (Route route : adjacencyList.get(stationCode)) {
                System.out.println("   -> " + route);
            }
        }
    }

    public void bfsTraversal(String startCode) {
        System.out.println("\n=== BFS Traversal ===");

        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        visited.add(startCode);
        queue.add(startCode);

        while (!queue.isEmpty()) {

            String current = queue.poll();

            System.out.print(current + " -> ");

            for (Route route : adjacencyList.get(current)) {

                String neighbor = route.destination;

                if (!visited.contains(neighbor)) {

                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }

        System.out.println("END");
    }

    public void dfsTraversal(String startCode) {
        System.out.println("\n=== DFS Traversal ===");

        Set<String> visited = new HashSet<>();

        dfsRecursive(startCode, visited);

        System.out.println("END");
    }

    private void dfsRecursive(String stationCode, Set<String> visited) {
        visited.add(stationCode);

        System.out.print(stationCode + " -> ");

        for (Route route : adjacencyList.get(stationCode)) {
            String neighbor = route.destination;
            if (!visited.contains(neighbor)) {
                dfsRecursive(neighbor, visited);
            }
        }
    }

    public void findPathBFS(String start, String end) {
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        HashMap<String, String> parent = new HashMap<>();

        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            String current = queue.poll();

            if (current.equals(end)) {
                break;
            }

            for (Route route : adjacencyList.get(current)) {
                String neighbor = route.destination;

                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    parent.put(neighbor, current);
                    queue.add(neighbor);
                }
            }
        }

        if (!visited.contains(end)) {
            System.out.println("\nTidak ada jalur ditemukan.");
            return;
        }

        ArrayList<String> path = new ArrayList<>();
        String current = end;

        while (current != null) {
            path.add(0, current);
            current = parent.get(current);
        }

        System.out.println("\nShortest Path BFS:");

        for (String station : path) {
            System.out.print(station);

            if (!station.equals(end)) {
                System.out.print(" -> ");
            }
        }

        System.out.println();
    }
}