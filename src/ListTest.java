import org.junit.jupiter.api.Assertions;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class ListTest {
    private List lista;

    @org.junit.jupiter.api.BeforeEach
    public void setup() {
        lista = new MyLinkedList2();
    }

    @org.junit.jupiter.api.Test
    public void testEmptyListIsEmpty() {
        assertTrue(lista.isEmpty());
    }

    @org.junit.jupiter.api.Test
    public void testSizeIsZeroInitially() {
        assertEquals(0, lista.size());
    }

    @org.junit.jupiter.api.Test
    public void testSizeIsNotZeroWhenElementsAreAdded() {
        lista.add(new MyLinkedList2.Nodo());
        assertEquals(1, lista.size());
    }

    @org.junit.jupiter.api.Test
    public void testEmptyIsFalseWhenElementsAreAdded() {
        lista.add(new MyLinkedList2.Nodo());
        assertFalse(lista.isEmpty());
    }

    //@Test(expected = NoSuchElementException.class)
    @org.junit.jupiter.api.Test
    public void testGetNegativeNumbersFails() {
        Assertions.assertThrows(NoSuchElementException.class, () -> {
            lista.get(-1);
        });
    }

    //@Test(expected = NoSuchElementException.class)
    @org.junit.jupiter.api.Test
    public void testGetInvalidIndexFails() {
        Assertions.assertThrows(NoSuchElementException.class, () -> {
            lista.get(5);
        });
    }

    //@Test(expected = NoSuchElementException.class)
    @org.junit.jupiter.api.Test
    public void testGetInvalidIndexFails2() {
        Assertions.assertThrows(NoSuchElementException.class, () -> {
            lista.get(0);
        });

    }

    @org.junit.jupiter.api.Test
    public void testGet() {
        for (int i = 0; i < 10; i++) {
            lista.add(new MyLinkedList2.Nodo(i,i));
        }
        assertEquals(9, lista.get(9).exponent);
        assertEquals(4, lista.get(4).exponent);
        assertEquals(0, lista.get(0).coefficient);
    }
/*
    @org.junit.jupiter.api.Test
    public void testToStringEmptyList() {
        assertEquals("[]", lista.toString());
    }
    */

    /*
    @org.junit.jupiter.api.Test
    public void testToStringNotEmptyList() {
        lista.add(3);
        assertEquals("[3, ]", lista.toString());
    }
    */
/*
    @org.junit.jupiter.api.Test
    public void testToStringNotEmptyList2() {
        lista.add(5);
        lista.add(3);
        assertEquals("[5, 3, ]", lista.toString());
    }
    */
/*
    @org.junit.jupiter.api.Test
    public void testToStringNotEmptyListTwice() {
        lista.add(5);
        lista.add(3);
        assertEquals("[5, 3, ]", lista.toString());
        assertEquals("[5, 3, ]", lista.toString());
    }
    */

    @org.junit.jupiter.api.Test
    public void testIterate() {
        for (int i = 0; i < 10; i++) {
            lista.add(new MyLinkedList2.Nodo(i,i));
        }


        Iterator it = lista.iterator();
        int i=0;
        MyLinkedList2.Nodo expected = new MyLinkedList2.Nodo(i,i);
        while(it.hasNext()) {
            MyLinkedList2.Nodo x = (MyLinkedList2.Nodo) it.next();
            assertEquals(expected.exponent, x.coefficient);
            i++;
            expected=new MyLinkedList2.Nodo(i,i);
        }
        //assertEquals(10, expected);
    }

}