package kurs;

import java.util.List;

public class SinglyLinkedStringList {
    private Element first;

    public SinglyLinkedStringList() {
        this.first = null;
    }

    public void add(String word) {
        Element element = new Element(word);
        if (first == null) {
            first = element;
        } else {
            Element last = getLast();
            last.setNext(element);
        }
    }

    public void addAll(List<String> list) {
        for (String word: list) {
            add(word);
        }
    }

    public String get(int index) {
        if (first == null) {
            //нет такого индекса
            throw new IndexOutOfBoundsException();
        }
        int counter = 0;
        Element current = first;
        do {
            if (counter == index) {
                return current.getData();
            }
            counter++;
            current = current.getNext();
        } while (current != null);
        //если сюда попали, то нет такого индекса
        throw new IndexOutOfBoundsException();
    }

    public void remove(String word) {
        if (first == null) return;
        Element current = first;
        Element previous = null;
        do {
            if (word.equals(current.getData())) {
                if (previous != null) {
                    previous.setNext(current.getNext());
                    return;
                } else {
                    first = first.getNext();
                    return;
                }
            }
            previous = current;
            current = previous.getNext();
        } while (current != null);
    }

    @Override
    public String toString() {
        int counter = 0;
        StringBuilder sb = new StringBuilder();
        if (first != null) {
            Element current = first;
            do {
                if (sb.length() != 0) {
                    sb.append(", ");
                }
                sb.append(current.toString());
                counter++;
                if (counter % 5 == 0) {
                    sb.append("\n   ");
                }
                if (counter > 30) {
                    sb.append(" ...");
                    break;
                }
                current = current.getNext();
            } while (current != null);
        }
        return "SinglyLinkedStringList[" + sb.toString() + "]";
    }

    private Element getLast() {
        if (first == null) return null;
        Element res = first;
        while (res.getNext() != null) {
            res = res.getNext();
        }
        return res;
    }

    static class Element {
        private Element next;
        private final String data;

        public Element(String data) {
            this.next = null;
            this.data = data;
        }

        public void setNext(Element next) {
            this.next = next;
        }

        public Element getNext() {
            return next;
        }

        public String getData() {
            return data;
        }

        @Override
        public String toString() {
            return data;
        }
    }



}
