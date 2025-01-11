/** Represents a stack of integers, with stack arithmetic.
 *  The stack has an unlimited capacity. */
public class Stack {
	
	// Initial  capacity of this stack
	private final static int MAX_SIZE = 100;

	// The elements of this stack
	private int[] elements = new int[MAX_SIZE];

	// The location in this stack just following the stack's top element
	private int top; 

	/** Constructs an empty stack. */
	public Stack() {
		top = 0;
	}
	
	/** Pushes the given element onto the stack's top. */
	public void push(int e) {
		if (top == MAX_SIZE - 1) {
			resize();
		}
		elements[top++] = e;
	}

	// Doubles the stack's capacity.
	private void resize() {
		int[] newElements = new int[elements.length * 2];
		// Creates a new array. Copies elements.size elements from
		// location 0 in elements to the new array, starting at location 0.
		// Sets the elements array of this stack to the new array.
        System.arraycopy(elements, 0, newElements, 0, elements.length);
        elements = newElements;
    }

	/** Removes and returns the stack's top element */
	public int pop() {
		return elements[--top];
	}

	/** Checks if this stack is empty. */
	public boolean isEmpty() {
		return top == 0;
	}

	/** Addition: Pops the two top elements,
	 *   adds them up, and pushes the result onto the stack */
	public void add() {
		push(pop() + pop());
	}

	/** Subtraction: Pops the two top elements,
	 *  Subtracts the next to top from the top, and pushes the result onto the stack */
	public void sub() {
		push(pop() - pop());
	}

	/** Multiplication: Pops the two top elements,
	 *  Multiplies them, and pushes the result onto the stack */
	public void mult() {
		push(pop() * pop());
	}

	/** Negation: Pops the two top elements,
	 *  negates it, and pushes the result onto the stack */
	public void neg() {
		push(-1 * pop());
	}
	
	/** Returns a string representing this stack, in the form of [e1, e2, e3, ...],
	 *  where the e's are the stack elements. */
	public String toString() {		
		// Uses a StringBuilder to build the string, which is less wasteful
		// then using s = s + elements[i] 
		StringBuilder s = new StringBuilder("[");
		for (int i = 0; i < (top - 1); i++) {
			s.append(elements[i] + ", ");
		}
		return s.append(elements[top - 1] + "]").toString();
	}
}
