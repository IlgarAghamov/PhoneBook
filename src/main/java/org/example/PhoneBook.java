package org.example;
import java.util.*;

public class PhoneBook {
    public static void main(String[] args) {

        HashMap<String, HashSet<String>> phoneBook = new HashMap<>();

        addNumber(phoneBook, "Иванов", "111-111-111");
        addNumber(phoneBook, "Петров", "222-222-222");
        addNumber(phoneBook, "Сидоров", "333-333-333");
        addNumber(phoneBook, "Иванов", "444-444-444");
        addNumber(phoneBook, "Сидоров", "555-555-555");

        printPhoneBook(phoneBook);
    }

    public static void addNumber(HashMap<String, HashSet<String>> phoneBook, String name, String number) {
        HashSet<String> numbers = phoneBook.get(name);
        if (numbers == null) {
            numbers = new HashSet<>();
            phoneBook.put(name, numbers);
        }
        numbers.add(number);
    }

    public static void printPhoneBook(HashMap<String, HashSet<String>> phoneBook) {
        List<Map.Entry<String, HashSet<String>>> list = new LinkedList<>(phoneBook.entrySet());
        list.sort((o1, o2) -> o2.getValue().size() - o1.getValue().size());

        for (Map.Entry<String, HashSet<String>> entry : list) {
            System.out.println("Имя: " + entry.getKey() + ", Телефоны: " + entry.getValue());
        }
    }
}