package linear;

public class LinkedListStackMain {

	public static void main(String[] args) {
		LinkedListStack checkStack = new LinkedListStack();
		
		String expression1 = "(A+B)*C";
		boolean flag = false;
		int i = 0;
		for(i=0; i<expression1.length(); i++) {
			char ch = expression1.charAt(i);
			if(ch == '(' || ch == '{' || ch == '[') {
				checkStack.push(ch);
			}else if(ch == ')' || ch == '}' || ch == ']') {
				char temp = checkStack.pop();
				if(temp == 0) {
					System.out.println("1. 여는 괄호가 부족합니다.");
					flag = true;
				}else if(ch==')' && temp != '(' || ch=='}' && temp != '{' || ch==']' && temp != '[') {
					System.out.println("1. 괄호의 순서가 잘못되었습니다.");
					flag = true;
					break;
				}
			}
		}
		if(flag == false && checkStack.size() != 0) {
			System.out.println("1. 닫는 괄호가 부족합니다.");
		}
		else if(flag == false && i == expression1.length()) {
			System.out.println("1. 수식이 정상입니다.");
		}
		
		flag = false;
		checkStack.clear();
		String expression2 = "{(A+B)*C}*D";
		for(i=0; i<expression2.length(); i++) {
			char ch = expression2.charAt(i);
			if(ch == '(' || ch == '{' || ch == '[') {
				checkStack.push(ch);
			}else if(ch == ')' || ch == '}' || ch == ']') {
				char temp = checkStack.pop();
				if(temp == 0) {
					System.out.println("2. 여는 괄호가 부족합니다.");
					flag = true;
				}else if(ch==')' && temp != '(' || ch=='}' && temp != '{' || ch==']' && temp != '[') {
					System.out.println("2. 괄호의 순서가 잘못되었습니다.");
					flag = true;
					break;
				}
			}
		}
		if(flag == false && checkStack.size() != 0) {
			System.out.println("2. 닫는 괄호가 부족합니다.");
		}
		else if(flag == false && i == expression2.length()) {
			System.out.println("2. 수식이 정상입니다.");
		}
		
		checkStack.clear();
		flag = false;
		String expression3 = "(A+B)*C)";
		for(i=0; i<expression3.length(); i++) {
			char ch = expression3.charAt(i);
			if(ch == '(' || ch == '{' || ch == '[') {
				checkStack.push(ch);
			}else if(ch == ')' || ch == '}' || ch == ']') {
				char temp = checkStack.pop();
				if(temp == 0) {
					System.out.println("3. 여는 괄호가 부족합니다.");
					flag = true;
				}else if(ch==')' && temp != '(' || ch=='}' && temp != '{' || ch==']' && temp != '[') {
					System.out.println("3. 괄호의 순서가 잘못되었습니다.");
					flag = true;
					break;
				}
			}
		}
		if(flag == false && checkStack.size() != 0) {
			System.out.println("3. 닫는 괄호가 부족합니다.");
		}
		else if(flag == false && i == expression3.length()) {
			System.out.println("3. 수식이 정상입니다.");
		}
		
		checkStack.clear();
		flag = false;
		String expression4 = "{(A+B)*C";
		for(i=0; i<expression4.length(); i++) {
			char ch = expression4.charAt(i);
			if(ch == '(' || ch == '{' || ch == '[') {
				checkStack.push(ch);
			}else if(ch == ')' || ch == '}' || ch == ']') {
				char temp = checkStack.pop();
				if(temp == 0) {
					System.out.println("4. 여는 괄호가 부족합니다.");
					flag = true;
				}else if(ch==')' && temp != '(' || ch=='}' && temp != '{' || ch==']' && temp != '[') {
					System.out.println("4. 괄호의 순서가 잘못되었습니다.");
					flag = true;
					break;
				}
			}
		}
		if(flag == false && checkStack.size() != 0) {
			System.out.println("4. 닫는 괄호가 부족합니다.");
		}
		else if(flag == false && i == expression4.length()) {
			System.out.println("4. 수식이 정상입니다.");
		}
		
		checkStack.clear();
		flag = false;
		String expression5 = "{(A+B}*C)";
		for(i=0; i<expression5.length(); i++) {
			char ch = expression5.charAt(i);
			if(ch == '(' || ch == '{' || ch == '[') {
				checkStack.push(ch);
			}else if(ch == ')' || ch == '}' || ch == ']') {
				char temp = checkStack.pop();
				if(temp == 0) {
					System.out.println("5. 여는 괄호가 부족합니다.");
					flag = true;
				}else if(ch==')' && temp != '(' || ch=='}' && temp != '{' || ch==']' && temp != '[') {
					System.out.println("5. 괄호의 순서가 잘못되었습니다.");
					flag = true;
					break;
				}
			}
		}
		if(flag == false && checkStack.size() != 0) {
			System.out.println("5. 닫는 괄호가 부족합니다.");
		}
		else if(flag == false && i == expression5.length()) {
			System.out.println("5. 수식이 정상입니다.");
		}
	}
}
