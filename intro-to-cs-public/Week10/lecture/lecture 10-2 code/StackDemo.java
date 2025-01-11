public class StackDemo {
	/** Tests some of the Stack methods. */
	public static void main(String args[]) {
		Stack stack = new Stack();
		stack.push(10); stack.push(20); stack.push(30); stack.push(40); stack.push(50);
		System.out.println("Pushing 10, 20, 30, 40, 50...");
		System.out.println("Stack:     " + stack);
		int x = stack.pop();
		System.out.println("After pop: " + stack);
		x = stack.pop();
		System.out.println("After pop: " + stack);
		stack.add();
		System.out.println("After add: " + stack);
	}
}
