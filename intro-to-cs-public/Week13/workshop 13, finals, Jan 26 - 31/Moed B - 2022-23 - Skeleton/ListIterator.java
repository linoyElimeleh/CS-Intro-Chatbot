// This class was created by Intro to Computer Science staff 2022 - 2023 at Reichman University
// was used for finals moed B 2022-2023
// was given as API to be used in the exam (no need to implement it)
// Implementation wasn't shown in the exam
// implemented by: Tal Danai, position: Recitation TA
public class ListIterator<E> {
    private Node<E> current;

    public ListIterator(Node<E> first) {
        this.current = first;
    }

    public boolean hasNext() {
        return this.current != null;
    }

    public E next() {
        E data = this.current.data;
        this.current = this.current.next;
        return data;
    }
    
}
