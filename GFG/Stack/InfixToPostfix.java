package randomGFG;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class InfixToPostfix {

	public static void main(String[] args) {
			// code
			String infix = "a+b*c+d";
			System.out.println(infix2postfix(infix));
	}

public static String infix2postfix(String in_exp) {

	Stack<Character> stackOfOperators = new Stack<Character>();
	StringBuilder postfixExp = new StringBuilder();
	Set<Character> setOfOperators = new HashSet<Character>();

	setOfOperators.add('+');
	setOfOperators.add('-');
	setOfOperators.add('*');
	setOfOperators.add('/');

	for (int i = 0; i < in_exp.length(); i++) {

	    char ch = in_exp.charAt(i);
	    if (setOfOperators.contains(ch)) {
				// push the operator onto the stack after checking precedence
				if (!stackOfOperators.isEmpty()) {

						if ((ch == '+' || ch == '-')
			    			&& (stackOfOperators.peek() == '*' || stackOfOperators.peek() == '/')) {
								// pop from stack as + and - has lower precedence than *
								// and / and add to result
								while (!stackOfOperators.isEmpty()) {
			    						postfixExp.append(stackOfOperators.pop());
								}
						// push the current operator in the stack
						stackOfOperators.push(ch);
		    } else {
						stackOfOperators.push(ch);
		    }
			} else {
		    stackOfOperators.push(ch);
			}
	    } else {
					// character encountered is an operand and hence add to result
					postfixExp.append(ch);
	    }
	}

	while (!stackOfOperators.isEmpty()) {
	    postfixExp.append(stackOfOperators.pop());
	}

	return postfixExp.toString();
    }
}
