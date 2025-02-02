// This class was created by Intro to Computer Science staff 2022 - 2023 at Reichman University
// was used for finals moed B 2022-2023
// was given as API to be used in the exam (no need to implement it)
// Implementation wasn't shown in the exam
// implemented by: Tal Danai, position: Recitation TA
public class LinkedList<E>{
    private Node<E> first;
    private Node<E> last;
    private int size;

    /**
     * Constructs a new empty linked list.
     */
    public LinkedList() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    /**
     * adds a new node with the given data to the end of the list
     * @param data - the data of the new node
     */
    public void add(E element) {
        Node<E> newNode = new Node<E>(element);
        if (this.size == 0) {
            this.first = newNode;
        } else {
            this.last.next = newNode;
        }
        this.last = newNode;
        this.size++;
    }

    /**
     * adds a new node with the given data to the beginning of the list
     * @param data - the data of the new node
     */
    private void addFirst(E element) {
        Node<E> newNode = new Node<E>(element);
        newNode.next = this.first;
        this.first = newNode;
        if (this.size == 0) {
            this.last = newNode;
        }
        this.size++;
        
    }

    /**
     * adds a new node with the given data to the end of the list
     * @param data - the data of the new node
     * @param index - the index of the node to add
    
     */
    public void add(E element, int index) {
        if (index < 0 || index > this.size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == this.size) {
            this.add(element);
            return;
        }
        if (index == 0) {
            this.addFirst(element);
            return;
        }
        Node<E> current = this.first;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        Node<E> newNode = new Node<E>(element);
        newNode.next = current.next;
        current.next = newNode;
        this.size++;
    }

    /**
     * removes the node at the given index
     * @param index - the index of the node to remove
     * @return the data of the removed node
     */
    public E remove(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            return this.removeFirst();
        }
        Node<E> prev = null;
        Node<E> current = this.first;
        for (int i = 0; i < index; i++) {
            prev = current;
            current = current.next;
        }
        prev.next = current.next;
        if (index == this.size - 1) {
            this.last = current;
        }
        this.size--;
        return current.data;
    }

    /**
     * returns the data of the node at the given index
     * @param index - the index of the node to get
     * @return the data of the node at the given index
     */
    public E get(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> current = this.first.next;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    /**
     * removes the first node in the list
     * @return the data of the removed node
     */
    private E removeFirst(){
        if (this.size == 0) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> res = this.first;
        this.first = this.first.next;
        this.size--;
        if (this.size == 0) {
            this.last = null;
        }
        return res.data;
    }

    /**
     * Returns the number of elements in this linked list.
     * @return the number of elements in this linked list
     */
    public int size() {
        return this.size;
    }

    /**
     * Returns a string representation of this linked list.
     * @return a string representation of this linked list
     */
    @Override
    public String toString() {
        if (this.size == 0) {
            return "[]";
        }
        String res = "[";
        Node<E> current = this.first;
        while (current.next != null) {
            res += current.data + ", ";
            current = current.next;
        }
        res += current.data + "]";
        return res;
    }

    /**
     * Returns the index of the first node with the given data.
     * @param data - the data to search for
     * @return the index of the first node with the given data
     */
    public int indexOf(E data) {
        Node<E> current = this.first;
        int index = 0;
        while (current != null) {
            if (current.data.equals(data)) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }
    
    /**
     * Returns true if this linked list contains the given data.
     * @param data - the data to search for
     * @return true if this linked list contains the given data
     */
    public boolean contains(E data) {
        return this.indexOf(data) != -1;
    }
    /**
     * Returns an iterator for this linked list.
     * @return an iterator for this linked list
     */
    public ListIterator<E> iterator() {
        return new ListIterator<E>(this.first);
    }
}
