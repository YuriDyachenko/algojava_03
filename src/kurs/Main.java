package kurs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class Main {

    public static final String FOR_ADD = "abrakadabra";
    public static final int INDEX_FOR_GET_REMOVE = 333;

    public static void main(String[] args) {
        //там генерируется начальный массив, который будет потом использоваться в разных заданиях
        ArraysMethods am = new ArraysMethods();
        //объект для фиксации и вывода прошедшего времени
        Duration duration = new Duration();
        //задание 3.1
        simpleListAndCollection(am, duration);
        //задание 3.2
        addDelGetFromLists(am, duration);
        //задание 3.3
        testSinglyLinkedList(am, duration);
        //задание 3.4
        testLinkedList(am);
        //задание 3.5
        testIteratorForLinkedList(am, duration);
    }

    private static void testIteratorForLinkedList(ArraysMethods am, Duration duration) {
        System.out.println("- - - - - Задание 3.5 - - - - -");
        //получаем исходный массив
        String[] arr = am.getCopyOfBaseArray();
        //создаем LinkedList
        LinkedList<String> linkedList = new LinkedList<>(Arrays.asList(arr));
        System.out.println(" основные методы интератора для linkedList");
        //этот элемент будем удалять интератором
        String tempString = linkedList.get(INDEX_FOR_GET_REMOVE);
        //создаем Iterator
        Iterator<String> iterator = linkedList.listIterator();
        duration.fix();
        while (iterator.hasNext()) {
            String temp = iterator.next();
            if (tempString.equals(temp)) {
                iterator.remove();
            }
        }
        duration.outAndFix("  перебор вперед с удалением одного элемента = " + tempString);
        //этот элемент будем удалять интератором
        String tempString2 = linkedList.get(INDEX_FOR_GET_REMOVE);
        //создаем Iterator обратный
        Iterator<String> descendingIterator = linkedList.descendingIterator();
        duration.fix();
        while (descendingIterator.hasNext()) {
            String temp = descendingIterator.next();
            if (tempString2.equals(temp)) {
                descendingIterator.remove();
            }
        }
        duration.outAndFix("  перебор назад с удалением одного элемента = " + tempString2);
    }

    private static void testLinkedList(ArraysMethods am) {
        System.out.println("- - - - - Задание 3.4 - - - - -");
        //получаем исходный массив
        String[] arr = am.getCopyOfBaseArray();
        //создаем LinkedList
        LinkedList<String> linkedList = new LinkedList<>(Arrays.asList(arr));
        System.out.println(" основные методы с linkedList");
        linkedList.add(FOR_ADD);
        String tempString = linkedList.get(INDEX_FOR_GET_REMOVE);
        linkedList.remove(tempString);
        //из задания 1.3
        Person[] people = {new Person("Иван", 33),
                new Person("Николай", 45),
                new Person("Сергей", 55),
                new Person("Иван", 33)};
        //создаем LinkedList
        LinkedList<Person> personList = new LinkedList<>(Arrays.asList(people));
        System.out.println(" personList = " + personList);
    }

    private static void testSinglyLinkedList(ArraysMethods am, Duration duration) {
        System.out.println("- - - - - Задание 3.3 - - - - -");
        //получаем исходный массив
        String[] arr = am.getCopyOfBaseArray();
        //создаем свой односвязный список
        duration.fix();
        SinglyLinkedStringList list = new SinglyLinkedStringList();
        list.addAll(Arrays.asList(arr));
        duration.outAndFix(" создание и заполнение 400 элементами (очень долго)");
        System.out.println(" основные методы с SinglyLinkedStringList");
        duration.fix();
        list.add(FOR_ADD);
        duration.outAndFix("  add(\"" + FOR_ADD + "\")");
        String tempString = list.get(INDEX_FOR_GET_REMOVE);
        duration.outAndFix("  String tempString = get("+ INDEX_FOR_GET_REMOVE + ") = " + tempString);
        list.remove(tempString);
        duration.outAndFix("  remove(" + tempString + ")");
        String tempStringAt0 = list.get(0);
        duration.outAndFix("  String tempStringAt0 = get(0) = " + tempStringAt0);
        list.remove(tempStringAt0);
        duration.outAndFix("  remove(" + tempStringAt0 + ")");
    }

    private static void addDelGetFromLists(ArraysMethods am, Duration duration) {
        System.out.println("- - - - - Задание 3.2 - - - - -");
        //получаем исходный массив
        String[] arr = am.getCopyOfBaseArray();
        //ArrayList
        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(arr));
        System.out.println(" основные методы с ArrayList");
        duration.fix();
        arrayList.add(FOR_ADD);
        duration.outAndFix("  add(\"" + FOR_ADD + "\")");
        String tempString = arrayList.get(INDEX_FOR_GET_REMOVE);
        duration.outAndFix("  String tempString = get(" + INDEX_FOR_GET_REMOVE + ") = " + tempString);
        arrayList.remove(tempString);
        duration.outAndFix("  remove(" + tempString + ")");
        //LinkedList
        LinkedList<String> linkedList = new LinkedList<>(Arrays.asList(arr));
        System.out.println(" основные методы с linkedList");
        duration.fix();
        linkedList.add(FOR_ADD);
        duration.outAndFix("  add(\"" + FOR_ADD + "\")");
        String tempString2 = linkedList.get(INDEX_FOR_GET_REMOVE);
        duration.outAndFix("  String tempString2 = get(" + INDEX_FOR_GET_REMOVE + ") = " + tempString2);
        linkedList.remove(tempString2);
        duration.outAndFix("  remove(" + tempString2 + ")");
    }

    private static void simpleListAndCollection(ArraysMethods am, Duration duration) {
        System.out.println("- - - - - Задание 3.1 - - - - -");
        //получаем исходный массив
        String[] arr = am.getCopyOfBaseArray();
        //создаем ArrayList, "смотрим время"
        duration.fix();
        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(arr));
        duration.outAndFix(" new ArrayList<>(Arrays.asList(arr))");
        //создаем LinkedList, "смотрим время"
        LinkedList<String> linkedList = new LinkedList<>(Arrays.asList(arr));
        duration.outAndFix(" new LinkedList<>(Arrays.asList(arr))");
    }
}
