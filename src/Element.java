public class Element<T> {
    Element<T> next = null;
    Element<T> prev = null;
    T data;
    Element() {}
    Element(T data) {
         this.data = data;
    }
    public String toString() {
        return data.toString();
    }
}
