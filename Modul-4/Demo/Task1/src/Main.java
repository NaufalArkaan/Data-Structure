public class Main {

    public static void main(String[] args) {

        StationHierarchy railway = new StationHierarchy();

        railway.setRoot(
                "ST001",
                "Indonesia Central Station",
                "National HQ"
        );

        railway.addStation(
                "ST001",
                "ST002",
                "Jakarta Station",
                "Jakarta"
        );

        railway.addStation(
                "ST001",
                "ST003",
                "Surabaya Station",
                "East Java"
        );

        railway.addStation(
                "ST001",
                "ST004",
                "Bandung Station",
                "West Java"
        );

        railway.addStation(
                "ST002",
                "ST005",
                "Gambir Station",
                "Central Jakarta"
        );

        railway.addStation(
                "ST002",
                "ST006",
                "Pasar Senen Station",
                "Central Jakarta"
        );

        railway.addStation(
                "ST003",
                "ST007",
                "Gubeng Station",
                "Surabaya"
        );

        railway.addStation(
                "ST003",
                "ST008",
                "Pasar Turi Station",
                "Surabaya"
        );

        railway.displayVisualTree();
        railway.displayTree();
        railway.preOrderTraversal();
        railway.postOrderTraversal();
        railway.levelOrderTraversal();

        System.out.println("\n====================================");
        System.out.println("SEARCH STATION");
        System.out.println("====================================");

        StationNode found = railway.findStation("ST007");

        if (found != null) {
            System.out.println("Station Found:");
            System.out.println(found);
        } else {
            System.out.println("Station not found!");
        }

        System.out.println("\n====================================");
        System.out.println("TREE STATISTICS");
        System.out.println("====================================");
        System.out.println("Total Stations : " + railway.totalStations());
        System.out.println("Tree Height    : " + railway.treeHeight());
        System.out.println("\n====================================");
        System.out.println("REMOVE STATION");
        System.out.println("====================================");
        railway.removeStation("ST003");
        railway.displayTree();
        System.out.println("\n====================================");
        System.out.println("UPDATED TREE STATISTICS");
        System.out.println("====================================");
        System.out.println("Total Stations : " + railway.totalStations());
        System.out.println("Tree Height    : " + railway.treeHeight());
    }
}