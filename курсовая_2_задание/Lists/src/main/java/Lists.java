import java.util.*;

public class Lists<T>{
    private Node<T> head;
    private int size;

    public void add(T value){
        if (head == null){
            this.head = new Node<>(value);
        } else{
            Node<T> temp = head;
            while (temp.getNext() != null){
                temp = temp.getNext();
            }
            temp.setNext(new Node<>(value));
            temp.getNext().setBack(temp);
        }
        size++;
    }
    public T getIndx(int index) throws IllegalAccessException {
        int i = 0;
        Node<T> temp = head;
        while (temp != null) {
            if (i == index)
                return temp.getValue();
            temp = temp.getNext();
            i++;
        }
        throw new IllegalAccessException();
    }
    public void remove(int index){
        int i = -1;
        Node<T> temp = head;
        Node<T> temp1;
        while (temp != null){
            if (++i == index){
                temp1 = temp.getBack();
                if (temp1 == null){
                    temp = temp.getNext();
                    this.head = temp;
                    if (temp != null)
                        temp.setBack(null);
                    this.size--;
                    return ;
                }
                temp = temp.getNext();
                temp1.setNext(temp);
                if (temp != null)
                    temp.setBack(temp1);
                this.size--;
                return;
            }
            temp = temp.getNext();
        }
    }
    public void remove(){
        remove(0);
    }

    private boolean isAvaliable(Object[] o, int pos) throws IllegalAccessException {
        for (int i = 0; i < o.length; i++)
            if (this.getIndx(pos).equals(o[i]))
                return true;
        return false;
    }
    public void removeAll(Collection<?> collection) throws IllegalAccessException {
        Object o;
        for (Object value : collection) {
            o = value;
            for (int i = 0; i < size; i++) {
                if (o.equals(this.getIndx(i)))
                    remove(i);
            }
        }
    }
    public void retainAll(Collection<?> collection) throws IllegalAccessException {
        int i = 0;
        Object[] o = new Object[collection.size()];
        for (Object value : collection)
            o[i++] = value;
        for (int j = 0; j < size; j++){
            if (!isAvaliable(o, j))
                remove(j--);
        }
    }

    @Override
    public String toString() {
        Node<T> i = head;
        StringBuilder str = new StringBuilder();
        while (i != null){
            str.append(i);
            str.append(" ");
            i = i.next;
        }
        str.append("\n");
        return str.toString();
    }
    private static class Node<T> {
        private T value;
        private Node<T> next;
        private Node<T> back;

        public Node<T> getBack() {
            return back;
        }

        public void setBack(Node<T> back) {
            this.back = back;
        }

        public Node(T value){
            this.value = value;
        }
        public T getValue(){
            return value;
        }
        public void setValue(T value){
            this.value = value;
        }
        public Node<T> getNext(){
            return next;
        }
        public void setNext(Node<T> list){
            this.next = list;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node<?> node = (Node<?>) o;
            return Objects.equals(value, node.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(value);
        }

        @Override
        public String toString() {
            return value.toString() + '\n';
        }
    }
}
