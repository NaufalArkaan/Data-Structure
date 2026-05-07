import java.util.ArrayList;
import java.util.List;

public class StationNode {
    String stationCode;
    String stationName;
    String region;
    StationNode parent;
    List<StationNode> children;

    public StationNode(String stationCode, String stationName, String region) {
        this.stationCode = stationCode;
        this.stationName = stationName;
        this.region = region;
        this.parent = null;
        this.children = new ArrayList<>();
    }

    public void addChild(StationNode child) {
        child.parent = this;
        children.add(child);
    }

    public void removeChild(StationNode child) {
        children.remove(child);
        child.parent = null;
    }

    public boolean isLeaf() {
        return children.isEmpty();
    }

    @Override
    public String toString() {
        return stationName + " [" + stationCode + "]" + " - " + region;
    }
}