public class DoubleLinkedList<T> {
    Element<T> head = null;
    Element<T> tail = null;
    Boolean isEmpty = true;

    DoubleLinkedList() {
        head = tail = new Element<>();
    }

    boolean isEmpty() {
        return isEmpty;
    }

    void add(T data) {
        if (isEmpty) {
            head = tail = new Element<>(data);
            isEmpty = false;
        } else {
            Element<T> element = new Element<>(data);
            tail.next = element;
            element.prev = tail;
            tail = element;
        }
    }

    void delete(Integer position) {
        delete(get(position));
    }
    void delete(Element<T> element) {
        if (element == head) {
            head = element.next;
            head.prev = null;
        }
        else if (element == tail) {
            tail = element.prev;
            tail.next = null;
        }
        else if (element != null){
            element.prev.next = element.next;
            element.next.prev = element.prev;
        }
    }

    Element<T> get(Integer position) {
        Element<T> current;
        if (position >= 0) {
            current = head;
            for (int i = 0; i < position; i++) {
                current = current.next;
                if (current == null) {
                    return null;
                }
            }
        } else {
            current = tail;
            for (int i = -1; i > position; i--) {
                current = current.prev;
                if (current == null) {
                    return null;
                }
            }
        }
        return current;
    }

    @Override
    public String toString() {
        if (isEmpty) {
            return null;
        } else {
            StringBuilder result = new StringBuilder();
            Element<T> element = head;
            result.append("[");
            while (element.next != null) {
                result.append(element.data);
                element = element.next;
                result.append(", ");
            }
            result.append(tail.data);
            result.append("]");
            return result.toString();
        }
    }

}
