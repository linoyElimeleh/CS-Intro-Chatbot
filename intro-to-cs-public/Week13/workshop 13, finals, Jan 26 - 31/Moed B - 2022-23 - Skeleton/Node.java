// This class was created by Intro to Computer Science staff 2022 - 2023 at Reichman University
// was used for finals moed B 2022-2023
// wasn't given as API to be used in the exam but there are some classes in the API that uses it (no need to implement it)
// the students weren't allowed to use it, the API handles it. 
// Implementation wasn't shown in the exam,
// Every Usage of this class in a given question caused disqualification of the question.
// implemented by: Tal Danai, position: Recitation TA
public class Node <E> {
    E data;
    Node <E> next;

    /**
     * Constructs a new node with the given data and next node.
     * @param data the data of the node
     * @param next the next node
     */
    public Node(E data, Node <E> next) {
        this.data = data;
        this.next = next;
    }

    public Node(E data) {
        this(data, null);
    }

    @Override
    public String toString() {
        return this.data.toString();
    }
}
