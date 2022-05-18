

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class CustomLinkedListTest {
    private CustomLinkedList<String> list;

    @BeforeEach
    public void setup() {
        list = new CustomLinkedList<>();
        list.add("0");
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
    }

    @Test
    public void whenAnyElementIsRemovedSizeIsDecremented(){
        assertEquals(5, list.size());
        list.remove("0");
        assertEquals(4, list.size());
    }

    @Test
    public void whenFirstElementIsRemovedNodesAreStillLinked(){
        assertEquals("4", list.get(list.size() - 1));
        list.remove("0");
        assertEquals("4", list.get(list.size() - 1));
    }

    @Test
    public void whenLastElementIsRemovedNodesAreStillLinked(){
        assertEquals("3", list.get(list.size() - 2));
        list.remove("4");
        assertEquals("3", list.get(list.size() - 1));
    }

    @Test
    public void whenMidpointElementIsRemovedNodesAreStillLinked(){
        assertEquals("3", list.get(3));
        list.remove("2");
        assertEquals("3", list.get(2));
    }

    @Test
    public void whenAnyElementIsRemovedReturnsTrue(){
        assertTrue(list.remove("0"));
    }

    @Test
    public void whenElementIsNotFoundReturnsFalse(){
        assertFalse(list.remove("5"));
    }


}
