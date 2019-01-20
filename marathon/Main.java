package marathon;

public class Main {
    public static void main(String[] args) {
        Team team = new Team("Человек и его хвостатые друзья"); // Создаем команду
        team.showTeamInfo(); // Выводим информацию о команде
        Course course = new Course(); // Создаем полосу препятствий
        course.doIt(team); // Просим команду пройти полосу
        team.showResults(); // Показываем результаты
    }
}
