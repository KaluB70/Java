public class Edge {
    private final Point from;
    private final Point to;

    public Edge(Point from, Point to) {
        this.from = from;
        this.to = to;
    }

    public Point getFrom() {
        return from;
    }

    public Point getTo() {
        return to;
    }

    @Override
    public String toString() {
        return from + " -> " + to;
    }
}
