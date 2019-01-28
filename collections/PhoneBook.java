package collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;

public class PhoneBook {
    private HashMap<String, ArrayList<String>> phoneBook = new HashMap<>();

    public void add(String lastName, String phone) {
        ArrayList<String> phoneList = (!phoneBook.containsKey(lastName)) ? new ArrayList<>() : phoneBook.get(lastName);
        phoneList.add(phone);
        phoneBook.put(lastName, phoneList);
    }

    public ArrayList<String> get(String lastName) {
        ArrayList<String> phoneList = phoneBook.getOrDefault(lastName, new ArrayList<>());
        if (phoneList.isEmpty()) {
            phoneList.add("в справочнике телефон не найден");
        }
        return phoneList;
    }
}
