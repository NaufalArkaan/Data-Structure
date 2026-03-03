package CODDELAB;

public class LinkedListExercise {

    // ==================================================================================
    // 2. Linked List (ANIME EDITION: ONE PIECE LOG POSE)
    // ==================================================================================

    // 2.1 Definition
    // Imagine the Grand Line. You cannot fly straight to the end. You must travel
    // from
    // Island to Island. Use a Log Pose (Pointer) to find the next island.
    // Each Island (Node) contains adventure (Data) and points to the next
    // destination (Next).

    // 2.2 Basic Structure
    // 1) Node: An Island (e.g., Drum Kingdom, Alabasta).
    // 2) Data: The name of the Island or the Villain there.
    // 3) Next: The Log Pose needle pointing to the next island.
    // 6) Tail: The furthest island you have reached so far.

    // ==================================================================================
    // IMPLEMENTATION (MISSION: NAVIGATE THE GRAND LINE)
    // ==================================================================================
    // INSTRUCTIONS: Help Nami navigate! Replace '__________' with the correct code.

    // 1) Node Class (The Island)
    static class Island {
        String name; // Island Name
        Island next; // Log Pose to next island

        public Island(String name) {
            this.name = name;
            this.next = null; // Initially points to nothing (sea)
        }
    }

    // Pointers for the journey
    private Island startIsland; // Head (Reverse Mountain)
    private Island lastIsland; // Tail (Current Location)

    // 2.4 Important Operations

    // 1) Chart a new course (Add Island at the end)
    public void addIsland(String name) {
        Island newIsland = new Island(name);

        // If we haven't started key
        if (startIsland == null) {
            startIsland = newIsland;
            lastIsland = newIsland;
        } else {
            // Point the current last island to the new one
            lastIsland.next = newIsland;
            // Update the last island to be the new one
            lastIsland = newIsland;
        }
    }

    // 2) Buster Call (Delete an Island by name)
    // Destruction of an island breaks the chain! We must link the previous island
    // to the next one.
    public void busterCall(String keyName) {
        Island current = startIsland;
        Island prev = null;

        // Case 1: If the starting island is the target (Ohara?!)
        if (current != null && current.name.equals(keyName)) {
            startIsland = current.next; // Move start to the next one
            return;
        }

        // Case 2: Navigate to find the island
        while (current != null && !current.name.equals(keyName)) {
            prev = current;
            current = current.next;
        }

        // If the island doesn't exist on the map
        if (current == null)
            return;

        // Unlink the destroyed island
        prev.next = current.next;
    }

    // 3) View Logbook (Print all islands)
    public void printLogbook() {
        Island current = startIsland;
        System.out.print("Grand Line Route: ");
        while (current != null) {
            if (current.next == null) {
                System.out.print(current.name + " (End)");
            } else {
                System.out.print(current.name + " -> ");
            }
            current = current.next;
        }
        System.out.println();
    }

    // 4) Check Log Pose (Search for an island)
    public boolean isIslandOnRoute(String keyName) {
        Island current = startIsland;
        while (current != null) {
            if (current.name.equals(keyName)) {
                return true; // Island found!
            }
            current = current.next;
        }
        return false; // Lost at sea
    }

    // 6) Count Islands
    public int countIslands() {
        int count = 0;
        Island current = startIsland;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    // MAIN METHOD to test the journey
    public static void main(String[] args) {
        LinkedListExercise grandLine = new LinkedListExercise();

        // The Journey Begins
        grandLine.addIsland("Alabasta");
        grandLine.addIsland("Skypiea");
        grandLine.addIsland("Water 7");
        grandLine.addIsland("Enies Lobby");

        // Check the map
        grandLine.printLogbook();

        // Nami checks if we visited Fishman Island
        System.out.println("Visited Fishman Island? " + grandLine.isIslandOnRoute("Fishman Island"));

        // Buster Call on an island
        System.out.println("Buster Call initiated on Enies Lobby!");
        grandLine.busterCall("Enies Lobby");

        grandLine.printLogbook();

        // Count adventures
        System.out.println("Total Islands visited: " + grandLine.countIslands());
    }
}