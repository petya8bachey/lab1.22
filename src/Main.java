public class Main {
    // Осуществить циклический сдвиг элементов двусвязного списка на k позиций вправо
    public static void main(String[] args) {
        System.out.println("Hello world!");
        int k = 3;
        DoubleLinkedList<Integer> doubleLinkedList = new DoubleLinkedList<>();
        for (int i = 0; i < 10; i++) {
            doubleLinkedList.add(i);
        }
        System.out.println(doubleLinkedList);

        Element<Integer> nTail = doubleLinkedList.get(k - 1);
        Element<Integer> nHead = nTail.next;
        doubleLinkedList.tail.next = doubleLinkedList.head;
        nTail.next = null;
        nHead.prev = null;
        doubleLinkedList.head = nHead;
        doubleLinkedList.tail = nTail;

        System.out.println(doubleLinkedList);
    }
}