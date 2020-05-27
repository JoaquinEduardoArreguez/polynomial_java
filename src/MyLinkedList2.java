import java.util.NoSuchElementException;

public class MyLinkedList2 implements List{

    private Nodo root;
    private int size;

    @Override
    public void add(Nodo x) {
        Nodo n = x;
        if (root == null) {
            root = n;
        } else {
            Nodo p = root;
            while (p.next != null) {
                p = p.next;
            }
            p.next = n;
        }
        size ++;
    }

    @Override
    public boolean contains(Nodo x) {
        return false;
    }

    @Override
    public Nodo get(int index) {
        if (index < 0 || index >= size) {
            throw new NoSuchElementException();
        }
        Nodo p = root;
        for (int i = 0; i < index; i++) {
            p = p.next;
        }
        return p;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator iterator() {
        return new ListIterator(root);
    }

    private static class ListIterator implements Iterator {

        private Nodo actual;

        public ListIterator(Nodo actual) {
            this.actual = actual;
        }

        public boolean hasNext() {
            return actual != null;
        }

        public Nodo next() {
            Nodo NodoActual = actual;
            actual = actual.next;
            return NodoActual;
        }
    }


    public static class Nodo {
        int coefficient;
        int exponent;
        Nodo next;

        public Nodo() {
            this.coefficient=0;
            this.exponent=0;
        }

        public Nodo(int coefficient,int exponent) {
            this.coefficient=coefficient;
            this.exponent=exponent;
        }
    }

}
