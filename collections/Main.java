package collections;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> listOfWords = new ArrayList<>();
        listOfWords.add("класс");
        listOfWords.add("объект");
        listOfWords.add("строка");
        listOfWords.add("интерфейс");
        listOfWords.add("число");
        listOfWords.add("символ");
        listOfWords.add("переменная");
        listOfWords.add("класс");
        listOfWords.add("константа");
        listOfWords.add("наследник");
        listOfWords.add("число");
        listOfWords.add("объект");
        listOfWords.add("класс");
        listOfWords.add("родитель");
        listOfWords.add("элемент");
        listOfWords.add("массив");
        listOfWords.add("коллекция");
        listOfWords.add("символ");

        Map<String, Integer> resultMap = new HashMap<>();

        for (String word : listOfWords) {
            if (!resultMap.containsKey(word)) {
                resultMap.put(word, 1);
            } else {
                resultMap.replace(word, resultMap.get(word) + 1);
            }
        }

        System.out.println(resultMap.toString());

        PhoneBook myPhoneBook = new PhoneBook();
        myPhoneBook.add("Зайцев", "8889903");
        myPhoneBook.add("Караваев", "8880911");
        myPhoneBook.add("Зайцев", "9167395");
        myPhoneBook.add("Николаев", "7891818");
        myPhoneBook.add("Зайцев", "6276267");
        myPhoneBook.add("Караваев", "3131444");

        System.out.println("Зайцев " + myPhoneBook.get("Зайцев"));
        System.out.println("Николаев " + myPhoneBook.get("Николаев"));
        System.out.println("Караваев " + myPhoneBook.get("Караваев"));
        System.out.println("Иванов " + myPhoneBook.get("Иванов"));
    }
}
