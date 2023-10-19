package org.example;
import java.util.*;

public class PhoneBook {
    public static void main(String[] args) {

        HashMap<String, HashSet<String>> phoneBook = new HashMap<>();

        addNumber(phoneBook, "Aghamov", "051-731-19-20");
        addNumber(phoneBook, "Korshunov", "050-800-19-20");
        addNumber(phoneBook, "Aliyev", "051-731-19-71");
        addNumber(phoneBook, "Korshunov", "055-427-50-00");
        addNumber(phoneBook, "Aghamov", "051-250-97-97");

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
            System.out.println("Name: " + entry.getKey() + ", Phone: " + entry.getValue());
        }
    }
}