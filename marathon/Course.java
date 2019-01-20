package marathon;

public class Course {

    Obstacle[] obstacles = {
            new Road(8),
            new Wall(2),
            new Water(1),
            new Wall(2)
    };

    public void doIt(Team team) {
        System.out.println("Команда " + team.getName() + " проходит полосу препятствий:");
        for (Competitor competitor: team.members){
            for (Obstacle obstacle: obstacles){
                obstacle.doIt(competitor);
                if (!competitor.onDistance()) break;
            }
        }
    }
}
