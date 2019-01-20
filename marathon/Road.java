package marathon;

public class Road extends Obstacle {
    private int dist;

    public Road(int dist) {
        this.dist = dist;
    }

    @Override
    void doIt(Competitor competitor) {
        competitor.run(dist);
    }
}
