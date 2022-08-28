
class arrStack<T extends Comparable<T>> {

	T stackList[];
	int top;

	// constructor
	arrStack(int size) {
		stackList = (T[]) new Comparable[size];
		top = -1;
	}

	arrStack() {
		stackList = (T[]) new Comparable[10];
		top = -1;
	}

	// methods
	public void PUSH(T c) {
		if (!isFull()) {
			top++;
			stackList[top] = c;
		} else {
			System.out.println("Stack is full");

		}
	}

	public T POP() {
		if (!isEmpty()) {
			top--;
			return stackList[top + 1];
		} else {
			System.out.println("The stack is empty");
			return null;
		}
	}

	public Boolean isEmpty() {
		return (top == -1);
	}

	public Boolean isFull() {
		return (top == stackList.length - 1);
	}

	public static Boolean validity(String test) {
		arrStack stk = new arrStack<Character>(test.length());
		int i = 0;
		char symbol;
		while (i < test.length()) {
			symbol = test.charAt(i);
			if (symbol == '(' || symbol == '[' || symbol == '{') {
				stk.PUSH(symbol);
			} else if (symbol == ')' || symbol == ']' || symbol == '}') {
				if (stk.isEmpty())
					return false;
				else {
					char item = (Character) stk.POP();
					if (!(item == '(' && symbol == ')' || item == '[' && item == ']' || item == '{' && item == '}')) {
						return false;
					}
				}
			}
			i++;
		}
		if (!stk.isEmpty()) {
			return false;
		} else
			return true;
	}
}

public class ArrayStack {

	public static void main(String[] args) {

	}

}
