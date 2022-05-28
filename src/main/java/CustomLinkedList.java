

public class CustomLinkedList<T> {

    private int size;
    private Node<T> first;
    private Node<T> last;

    public CustomLinkedList(){
        this.size = 0;
        first = null;
        last = null;
    }

    public void add(T data){
        Node<T> newNode = new Node<>(data);
        newNode.next = null;

        if(size == 0){
            first = newNode;
            last = newNode;
            size++;
            return;
        }

        last.next = newNode;
        last = newNode;
        size++;
    }


    public T get(int index){
        if(index < 0 || index >= size) throw new IndexOutOfBoundsException();

        Node<T> current = first;

        for(int i = 0; i < index; i++){
            current = current.next;
        }


        return current.item;
    }

    /** Lab Instructions:
     *      Implement the remove() method such the first instance
     *      of the provided object is removed from the list. You
     *      do not need to remove duplicates of the object.
     *      After the object is removed, the list should still
     *      be linked from start to end.
     *      If the object is found and removed, return true.
     *      If the object is not found, return false.
     *      Be sure to properly reassign the first and last
     *      pointers if needed.
     * @param o
     */
    public boolean remove(Object o){
        Node<T> current = first;
        Node<T> previous = null;
        
        for (int i = 0; i < size; i++) {
            // Found item - remove & return true
            if (current.item.equals(o)) {
                if (previous == null) {
                    first = current.next;
                } else {
                    previous.next = current.next;
                }
                size--;
                return true;
            }
            previous = current;
            current = current.next;
        }

        // No item found - return false
        return false;
    }


    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return this.size;
    }

    private class Node<T>{
        T item;
        Node<T> next;
        Node(T item){
            this.item = item;
        }
    }
}
