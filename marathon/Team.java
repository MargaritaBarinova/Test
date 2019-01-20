package marathon;


public class Team {
    private String name;

    public Team(String name) {
        this.name = name;
    }

    Competitor[] members = {
            new Dog("Jack", "black", 10, 1, 2),
            new Cat("Mag", "white", 10, 0, 3),
            new Turtle("Turtle", "green", 100, 10, 0),
            new Human("Rick", 8, 10, 2)
    };

    public void showResults() {
            System.out.println("");
        for (Competitor member : members) {
            if (member.onDistance()) {
                member.info();
            }
        }
    }

    public void showTeamInfo() {
        System.out.println("В состав команды " + name + " входят:");
        for (Competitor member : members) {
            System.out.println((member instanceof Animal ? ((Animal) member).getName() + " цвета " + ((Animal) member).getColor()
                    : ((Human) member).getName()));
        }
    }

    public String getName() {
        return name;
    }
}
