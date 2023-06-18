package jframe;

import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;

public class Lists<T> extends BankJFrame{
    private Lists.Node<T> head;
    private int size;

    public Lists() {
    }

    public void add(T value) {
        if (this.head == null) {
            this.head = new Lists.Node(value);
        } else {
            Lists.Node temp;
            for(temp = this.head; temp.getNext() != null; temp = temp.getNext()) {
            }

            temp.setNext(new Lists.Node(value));
            temp.getNext().setBack(temp);
        }

        ++this.size;
    }

    public T getIndx(int index) throws IllegalAccessException {
        int i = 0;

        for(Lists.Node temp = this.head; temp != null; ++i) {
            if (i == index) {
                return (T) temp.getValue();
            }

            temp = temp.getNext();
        }

        throw new IllegalAccessException();
    }

    public void remove(int index) {
        int i = -1;

        for(Lists.Node temp = this.head; temp != null; temp = temp.getNext()) {
            ++i;
            if (i == index) {
                Lists.Node<T> temp1 = temp.getBack();
                if (temp1 == null) {
                    temp = temp.getNext();
                    this.head = temp;
                    if (temp != null) {
                        temp.setBack((Lists.Node)null);
                    }

                    --this.size;
                    return;
                }

                temp = temp.getNext();
                temp1.setNext(temp);
                if (temp != null) {
                    temp.setBack(temp1);
                }

                --this.size;
                return;
            }
        }

    }

    public void remove() {
        this.remove(0);
    }

    private boolean isAvaliable(Object[] o, int pos) throws IllegalAccessException {
        for(int i = 0; i < o.length; ++i) {
            if (this.getIndx(pos).equals(o[i])) {
                return true;
            }
        }

        return false;
    }

    public void removeAll(Collection<?> collection) throws IllegalAccessException {
        Iterator var3 = collection.iterator();

        while(var3.hasNext()) {
            Object value = var3.next();
            Object o = value;

            for(int i = 0; i < this.size; ++i) {
                if (o.equals(this.getIndx(i))) {
                    this.remove(i);
                }
            }
        }

    }

    public void retainAll(Collection<?> collection) throws IllegalAccessException {
        int i = 0;
        Object[] o = new Object[collection.size()];

        Object value;
        for(Iterator var4 = collection.iterator(); var4.hasNext(); o[i++] = value) {
            value = var4.next();
        }

        for(int j = 0; j < this.size; ++j) {
            if (!this.isAvaliable(o, j)) {
                this.remove(j--);
            }
        }

    }

    public String toString() {
        Lists.Node<T> i = this.head;

        StringBuilder str;
        for(str = new StringBuilder(); i != null; i = i.next) {
            str.append(i);
            str.append(" ");
        }

        str.append("\n");
        return str.toString();
    }

    private static class Node<T> {
        private T value;
        private Lists.Node<T> next;
        private Lists.Node<T> back;

        public Lists.Node<T> getBack() {
            return this.back;
        }

        public void setBack(Lists.Node<T> back) {
            this.back = back;
        }

        public Node(T value) {
            this.value = value;
        }

        public T getValue() {
            return this.value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public Lists.Node<T> getNext() {
            return this.next;
        }

        public void setNext(Lists.Node<T> list) {
            this.next = list;
        }

        public boolean equals(Object o) {
            if (this == o) {
                return true;
            } else if (o != null && this.getClass() == o.getClass()) {
                Lists.Node<?> node = (Lists.Node)o;
                return Objects.equals(this.value, node.value);
            } else {
                return false;
            }
        }

        public int hashCode() {
            return Objects.hash(new Object[]{this.value});
        }

        public String toString() {
            return this.value.toString() + '\n';
        }
    }
}
