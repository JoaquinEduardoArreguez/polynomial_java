public interface List {
    void add(MyLinkedList2.Nodo x);

    boolean contains(MyLinkedList2.Nodo x);

    MyLinkedList2.Nodo get(int index);

    boolean isEmpty();

    int size();

    Iterator iterator();
}
