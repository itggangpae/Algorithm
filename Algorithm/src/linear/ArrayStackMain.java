package linear;

public class ArrayStackMain {
	public static void main(String args[]) {
        int stackSize = 5;
        ArrayStack arrStack = new ArrayStack(stackSize);
        
        arrStack.push('A');
        arrStack.printStack();
        
        arrStack.push('B');
        arrStack.printStack();
        
        arrStack.push('C');
        arrStack.printStack();
        
        arrStack.pop();
        arrStack.printStack();
        
        arrStack.pop();
        arrStack.printStack();
        
        arrStack.peek();
        arrStack.printStack();
        
        arrStack.clear();
        arrStack.printStack();
    }
}
