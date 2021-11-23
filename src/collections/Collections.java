package collections;

import java.util.*;
import java.util.HashMap;

public class Collections {
    private final List<Person> PersonArrayList = new ArrayList<>();
    private final List<BetterPerson> BetterPersonArrayList = new ArrayList<>();
    private final List<Person> PersonLinkedList = new LinkedList<>();
    private final List<BetterPerson> BetterPersonLinkedList = new LinkedList<>();

    private final Set<Person> PersonHashSet = new HashSet<>();
    private final Set<BetterPerson> BetterPersonHashSet = new HashSet<>();
    private final Set<Person> PersonTreeSet = new TreeSet<>(new Tree_SetComparator());
    private final Set<BetterPerson> BetterPersonTreeSet = new TreeSet<>(new Tree_SetComparator());

    private final Map<Integer, Person> PersonHashMap = new HashMap();
    private final Map<Integer, BetterPerson> BetterPersonHashMap = new HashMap();
    private final Map<Integer, Person> PersonTreeMap = new TreeMap<>();
    private final Map<Integer, BetterPerson> BetterPersonTreeMap = new TreeMap<>();

    private static final String MENU =
            "    M E N U   G Ł Ó W N E  \n" +
                    "1 - Wybierz akcję z funkcjami hashCode/equals \n" +
                    "2 - Wybierz akcję bez funkcji hashCode/equals \n" +
                    "0 - Zakończ program  \n";

    private static final String COLLECTIONS_MENU =
            "   K O L E K C J A   \n" +
                    "1 - ArrayList   \n" +
                    "2 - LinkedList  \n" +
                    "3 - HashSet     \n" +
                    "4 - TreeSet     \n" +
                    "5 - HashMap     \n" +
                    "6 - TreeMap     \n" +
                    "0 - Powrót do menu akcji\n";

    private static final String ACTIONS_MENU =
            "   A K C J A   \n" +
                    "1 - Dodaj osoby        \n" +
                    "2 - Usuń osobę         \n" +
                    "3 - Wyświetl kolekcję  \n" +
                    "0 - Powrót do menu głównego\n";


    private static final UserDialog UI = new UserDialog();


    void mainLoop() {

        while (true) {
            UI.clearConsole();
            switch (UI.enterInt(MENU + "==>> ")) {
                case 1 -> chooseActionWithHash();
                case 2 -> chooseActionWithoutHash();
                case 0 -> {
                    UI.printInfoMessage("\nProgram zakończył działanie!");
                    System.exit(0);
                }
            }
        }
    }
    public void chooseActionWithoutHash() {

        while (true) {
            UI.clearConsole();
            switch (UI.enterInt(ACTIONS_MENU + "==>> ")) {
                case 1:
                    addPeopleWithoutHash();
                    break;
                case 2:
                    removeOneWithoutHash();
                    break;
                case 3:
                    displayCollectionWithoutHash();
                    break;
                case 0: return;
            }
        }
    }

    public void chooseActionWithHash() {

        while (true) {
            UI.clearConsole();
            switch (UI.enterInt(ACTIONS_MENU + "==>> ")) {
                case 1:
                    addPeopleWithHash();
                    break;
                case 2:
                    removeOneWithHash();
                    break;
                case 3:
                    displayCollectionWithHash();
                    break;
                case 0: return;
            }
        }
    }

    private void addPeopleWithHash() {
        BetterPerson firstBetterPerson = new BetterPerson("Chuck", "Norris", 81, "Aktor");
        BetterPerson secondBetterPerson = new BetterPerson("Dwayne", "Johnson", 49, "Wrestler");
        BetterPerson thirdBetterPerson = new BetterPerson("Arnold", "Schwarzenegger", 74, "Kulturysta");
        BetterPerson fourthBetterPerson = new BetterPerson("Michael", "Jordan", 58, "Koszykarz");
        BetterPerson fifthBetterPerson = new BetterPerson("Robert", "Makłowicz", 58, "Kucharz");

        while (true) {
            UI.clearConsole();
            switch (UI.enterInt(COLLECTIONS_MENU + "==>> ")) {
                case 1:
                    BetterPersonArrayList.add(firstBetterPerson);
                    BetterPersonArrayList.add(secondBetterPerson);
                    BetterPersonArrayList.add(thirdBetterPerson);
                    BetterPersonArrayList.add(fourthBetterPerson);
                    BetterPersonArrayList.add(fifthBetterPerson);
                    BetterPersonArrayList.add(fifthBetterPerson);
                    break;
                case 2:
                    BetterPersonLinkedList.add(firstBetterPerson);
                    BetterPersonLinkedList.add(secondBetterPerson);
                    BetterPersonLinkedList.add(thirdBetterPerson);
                    BetterPersonLinkedList.add(fourthBetterPerson);
                    BetterPersonLinkedList.add(fifthBetterPerson);
                    BetterPersonLinkedList.add(fifthBetterPerson);
                    break;
                case 3:
                    BetterPersonHashSet.add(firstBetterPerson);
                    BetterPersonHashSet.add(secondBetterPerson);
                    BetterPersonHashSet.add(thirdBetterPerson);
                    BetterPersonHashSet.add(fourthBetterPerson);
                    BetterPersonHashSet.add(fifthBetterPerson);
                    BetterPersonHashSet.add(fifthBetterPerson);
                    break;
                case 4:
                    BetterPersonTreeSet.add(firstBetterPerson);
                    BetterPersonTreeSet.add(secondBetterPerson);
                    BetterPersonTreeSet.add(thirdBetterPerson);
                    BetterPersonTreeSet.add(fourthBetterPerson);
                    BetterPersonTreeSet.add(fifthBetterPerson);
                    BetterPersonTreeSet.add(fifthBetterPerson);
                    break;
                case 5:
                    BetterPersonHashMap.put(1, firstBetterPerson);
                    BetterPersonHashMap.put(2, secondBetterPerson);
                    BetterPersonHashMap.put(3, thirdBetterPerson);
                    BetterPersonHashMap.put(4, fourthBetterPerson);
                    BetterPersonHashMap.put(5, fifthBetterPerson);
                    BetterPersonHashMap.put(6, fifthBetterPerson);
                    break;
                case 6:
                    BetterPersonTreeMap.put(1, firstBetterPerson);
                    BetterPersonTreeMap.put(2, secondBetterPerson);
                    BetterPersonTreeMap.put(3, thirdBetterPerson);
                    BetterPersonTreeMap.put(4, fourthBetterPerson);
                    BetterPersonTreeMap.put(5, fifthBetterPerson);
                    BetterPersonTreeMap.put(6, fifthBetterPerson);
                    break;
                case 0: return;
            }
        }
    }

    private void removeOneWithHash() {
        Random rand = new Random();
        int random;

        while (true) {
            UI.clearConsole();
            switch (UI.enterInt(COLLECTIONS_MENU + "==>> ")) {
                case 1:
                    if (BetterPersonArrayList.size() > 0) {
                        random = rand.nextInt(BetterPersonArrayList.size());
                        BetterPersonArrayList.remove(random);
                    } else
                        PrintLines(2);
                    break;
                case 2:
                    if (BetterPersonLinkedList.size() > 0) {
                        random = rand.nextInt(BetterPersonLinkedList.size());
                        BetterPersonLinkedList.remove(random);
                    } else
                        PrintLines(2);
                    break;
                case 3:
                    if (BetterPersonHashSet.size() > 0) {
                        random = rand.nextInt(BetterPersonHashSet.size());
                        Iterator<BetterPerson> iterHashSet = BetterPersonHashSet.iterator();
                        for (int i = 0; i < BetterPersonHashSet.size(); ) {
                            while (iterHashSet.hasNext()) {
                                BetterPerson next = iterHashSet.next();
                                if (i == random) {
                                    iterHashSet.remove();
                                }
                                i++;
                            }
                        }
                    } else
                        PrintLines(2);
                    break;
                case 4:
                    if (BetterPersonTreeSet.size() > 0) {
                        random = rand.nextInt(BetterPersonTreeSet.size());
                        Iterator<BetterPerson> iterTreeSet = BetterPersonTreeSet.iterator();
                        for (int i = 0; i < BetterPersonTreeSet.size(); ) {
                            while (iterTreeSet.hasNext()) {
                                BetterPerson next = iterTreeSet.next();
                                if (i == random) {
                                    iterTreeSet.remove();
                                }
                                i++;
                            }
                        }
                    } else
                        PrintLines(2);
                    break;
                case 5:
                    if (BetterPersonHashMap.size() > 0) {
                        random = rand.nextInt(BetterPersonHashMap.size());
                        BetterPersonHashMap.remove(random);
                    } else
                        PrintLines(2);
                    break;
                case 6:
                    if (BetterPersonTreeMap.size() > 0) {
                        random = rand.nextInt(BetterPersonTreeMap.size());
                        BetterPersonTreeMap.remove(random);
                    } else
                        PrintLines(2);
                    break;
                case 0: return;
            }
        }
    }

    private void displayCollectionWithHash() {

        while (true) {
            UI.clearConsole();
            switch (UI.enterInt(COLLECTIONS_MENU + "==>> ")) {
                case 1 -> {
                    PrintLines(1);
                    for (var betterPerson : BetterPersonArrayList) {
                        String output = String.format("%10s%17s%13s%5s", betterPerson.getFirstName(), betterPerson.getLastName(), betterPerson.getJob(), betterPerson.getAge());
                        System.out.println(output);
                        PrintLines(0);
                    }
                }
                case 2 -> {
                    PrintLines(1);
                    for (var betterPerson : BetterPersonLinkedList) {
                        String output = String.format("%10s%17s%13s%5s", betterPerson.getFirstName(), betterPerson.getLastName(), betterPerson.getJob(), betterPerson.getAge());
                        System.out.println(output);
                        PrintLines(0);
                    }
                }
                case 3 -> {
                    PrintLines(1);
                    for (var betterPperson : BetterPersonHashSet) {
                        String output = String.format("%10s%17s%13s%5s", betterPperson.getFirstName(), betterPperson.getLastName(), betterPperson.getJob(), betterPperson.getAge());
                        System.out.println(output);
                        PrintLines(0);
                    }
                }
                case 4 -> {
                    PrintLines(1);
                    for (var betterPerson : BetterPersonTreeSet) {
                        String output = String.format("%10s%17s%13s%5s", betterPerson.getFirstName(), betterPerson.getLastName(), betterPerson.getJob(), betterPerson.getAge());
                        System.out.println(output);
                        PrintLines(0);
                    }
                }
                case 5 -> {
                    PrintLines(1);
                    for(Map.Entry<Integer, BetterPerson> entry : BetterPersonHashMap.entrySet()) {
                        Integer key = entry.getKey();
                        String output = String.format("%10s%17s%13s%5s", BetterPersonHashMap.get(key).getFirstName(), BetterPersonHashMap.get(key).getLastName(), BetterPersonHashMap.get(key).getJob(), BetterPersonHashMap.get(key).getAge());
                        System.out.println(output);
                        PrintLines(0);
                    }
                }
                case 6 -> {
                    PrintLines(1);
                    for(Map.Entry<Integer, BetterPerson> entry : BetterPersonTreeMap.entrySet()) {
                        Integer key = entry.getKey();
                        String output = String.format("%10s%17s%13s%5s", BetterPersonTreeMap.get(key).getFirstName(), BetterPersonTreeMap.get(key).getLastName(), BetterPersonTreeMap.get(key).getJob(), BetterPersonTreeMap.get(key).getAge());
                        System.out.println(output);
                        PrintLines(0);
                    }
                }
                case 0 -> {return;}
            }
        }
    }

    private void addPeopleWithoutHash() {
        Person firstPerson = new Person("Chuck", "Norris", 81, "Aktor");
        Person secondPerson = new Person("Dwayne", "Johnson", 49, "Wrestler");
        Person thirdPerson = new Person("Arnold", "Schwarzenegger", 74, "Kulturysta");
        Person fourthPerson = new Person("Michael", "Jordan", 58, "Koszykarz");
        Person fifthPerson = new Person("Robert", "Makłowicz", 58, "Kucharz");

        while (true) {
            UI.clearConsole();
            switch (UI.enterInt(COLLECTIONS_MENU + "==>> ")) {
                case 1:
                    PersonArrayList.add(firstPerson);
                    PersonArrayList.add(secondPerson);
                    PersonArrayList.add(thirdPerson);
                    PersonArrayList.add(fourthPerson);
                    PersonArrayList.add(fifthPerson);
                    PersonArrayList.add(fifthPerson);
                    break;
                case 2:
                    PersonLinkedList.add(firstPerson);
                    PersonLinkedList.add(secondPerson);
                    PersonLinkedList.add(thirdPerson);
                    PersonLinkedList.add(fourthPerson);
                    PersonLinkedList.add(fifthPerson);
                    PersonLinkedList.add(fifthPerson);
                    break;
                case 3:
                    PersonHashSet.add(firstPerson);
                    PersonHashSet.add(secondPerson);
                    PersonHashSet.add(thirdPerson);
                    PersonHashSet.add(fourthPerson);
                    PersonHashSet.add(fifthPerson);
                    PersonHashSet.add(fifthPerson);
                    break;
                case 4:
                    PersonTreeSet.add(firstPerson);
                    PersonTreeSet.add(secondPerson);
                    PersonTreeSet.add(thirdPerson);
                    PersonTreeSet.add(fourthPerson);
                    PersonTreeSet.add(fifthPerson);
                    PersonTreeSet.add(fifthPerson);
                    break;
                case 5:
                    PersonHashMap.put(1, firstPerson);
                    PersonHashMap.put(2, secondPerson);
                    PersonHashMap.put(3, thirdPerson);
                    PersonHashMap.put(4, fourthPerson);
                    PersonHashMap.put(5, fifthPerson);
                    PersonHashMap.put(6, fifthPerson);
                    break;
                case 6:
                    PersonTreeMap.put(1, firstPerson);
                    PersonTreeMap.put(2, secondPerson);
                    PersonTreeMap.put(3, thirdPerson);
                    PersonTreeMap.put(4, fourthPerson);
                    PersonTreeMap.put(5, fifthPerson);
                    PersonTreeMap.put(6, fifthPerson);
                    break;
                case 0: return;
            }
        }
    }

    private void removeOneWithoutHash() {
        Random rand = new Random();
        int random;

        while (true) {
            UI.clearConsole();
            switch (UI.enterInt(COLLECTIONS_MENU + "==>> ")) {
                case 1:
                    if (PersonArrayList.size() > 0) {
                        random = rand.nextInt(PersonArrayList.size());
                        PersonArrayList.remove(random);
                    } else
                        PrintLines(2);
                    break;
                case 2:
                    if (PersonLinkedList.size() > 0) {
                        random = rand.nextInt(PersonLinkedList.size());
                        PersonLinkedList.remove(random);
                    } else
                        PrintLines(2);
                    break;
                case 3:
                    if (PersonHashSet.size() > 0) {
                        random = rand.nextInt(PersonHashSet.size());
                        Iterator<Person> iterHashSet = PersonHashSet.iterator();
                        for (int i = 0; i < PersonHashSet.size(); ) {
                            while (iterHashSet.hasNext()) {
                                Person next = iterHashSet.next();
                                if (i == random) {
                                    iterHashSet.remove();
                                }
                                i++;
                            }
                        }
                    } else
                        PrintLines(2);
                    break;
                case 4:
                    if (PersonTreeSet.size() > 0) {
                        random = rand.nextInt(PersonTreeSet.size());
                        Iterator<Person> iterTreeSet = PersonTreeSet.iterator();
                        for (int i = 0; i < PersonTreeSet.size(); ) {
                            while (iterTreeSet.hasNext()) {
                                Person next = iterTreeSet.next();
                                if (i == random) {
                                    iterTreeSet.remove();
                                }
                                i++;
                            }
                        }
                    } else
                        PrintLines(2);
                    break;
                case 5:
                    if (PersonHashMap.size() > 0) {
                        random = rand.nextInt(PersonHashMap.size());
                        PersonHashMap.remove(random);
                    } else
                        PrintLines(2);
                    break;
                case 6:
                    if (PersonTreeMap.size() > 0) {
                        random = rand.nextInt(PersonTreeMap.size());
                        PersonTreeMap.remove(random);
                    } else
                        PrintLines(2);
                    break;
                case 0: return;
            }
        }
    }

    private void displayCollectionWithoutHash() {

        while (true) {
            UI.clearConsole();
            switch (UI.enterInt(COLLECTIONS_MENU + "==>> ")) {
                case 1 -> {
                    PrintLines(1);
                    for (var person : PersonArrayList) {
                        String output = String.format("%10s%17s%13s%5s", person.getFirstName(), person.getLastName(), person.getJob(), person.getAge());
                        System.out.println(output);
                        PrintLines(0);
                    }
                }
                case 2 -> {
                    PrintLines(1);
                    for (var person : PersonLinkedList) {
                        String output = String.format("%10s%17s%13s%5s", person.getFirstName(), person.getLastName(), person.getJob(), person.getAge());
                        System.out.println(output);
                        PrintLines(0);
                    }
                }
                case 3 -> {
                    PrintLines(1);
                    for (var person : PersonHashSet) {
                        String output = String.format("%10s%17s%13s%5s", person.getFirstName(), person.getLastName(), person.getJob(), person.getAge());
                        System.out.println(output);
                        PrintLines(0);
                    }
                }
                case 4 -> {
                    PrintLines(1);
                    for (var person : PersonTreeSet) {
                        String output = String.format("%10s%17s%13s%5s", person.getFirstName(), person.getLastName(), person.getJob(), person.getAge());
                        System.out.println(output);
                        PrintLines(0);
                    }
                }
                case 5 -> {
                    PrintLines(1);
                    for(Map.Entry<Integer, Person> entry : PersonHashMap.entrySet()) {
                        Integer key = entry.getKey();
                        String output = String.format("%10s%17s%13s%5s", PersonHashMap.get(key).getFirstName(), PersonHashMap.get(key).getLastName(), PersonHashMap.get(key).getJob(), PersonHashMap.get(key).getAge());
                        System.out.println(output);
                        PrintLines(0);
                    }
                }
                case 6 -> {
                    PrintLines(1);
                    for(Map.Entry<Integer, Person> entry : PersonTreeMap.entrySet()) {
                        Integer key = entry.getKey();
                        String output = String.format("%10s%17s%13s%5s", PersonTreeMap.get(key).getFirstName(), PersonTreeMap.get(key).getLastName(), PersonTreeMap.get(key).getJob(), PersonTreeMap.get(key).getAge());
                        System.out.println(output);
                        PrintLines(0);
                    }
                }
                case 0 -> {return;}
            }
        }
    }

    private static void PrintLines(int x){
        String Line = String.format("%10s%17s%13s%5s", "First Name", "Last Name", "Job", "Age");
        String Break = "----------------------------------------------";
        String Empty = "Cannot remove object from empty collection";
        if(x == 0){
            System.out.println(Break);
        }
        else if(x == 1){
            System.out.println(Line);
            System.out.println(Break);
        }
        else if(x == 2){
            System.out.println(Empty);
        }
    }

    private static class Tree_SetComparator implements Comparator<Person> {
        @Override
        public int compare(Person p1, Person p2) {
            return p1.getFirstName().compareTo(p2.getFirstName());
        }
    }
}









