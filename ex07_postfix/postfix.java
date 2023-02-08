//[문제] 괄호가 있는 수식을 입력받아 괄호 짝이 맞는지 검사한 다음 짝이 맞으면 중위식을 후위식으로 변환한 다음 
//        스택을 이용해서 연산한 결과를 출력하는 프로그램을 작성하시오.
//
//OptExp 클래스의 메서드는 다음과 같다.
//1. testPair() : 괄호 짝이 맞는지 검사(스택)
//2. infixTopostfix() : 중위식을 후위식으로 변환(스택)
//3. evalPostfix() : 후위식을 이용해서 연산결과 출력(스택)

package ex07_postfix;

import java.util.Scanner;

interface Stack { // 인터페이스 메서드를 오버라이드 해야함.
	boolean isEmpty();

	void push(int item);

	int pop();

	void delete();

	int peek();
}


public class postfix {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		OptExp opt = new OptExp();
		String exp = null;
		String postfix = null;
		//(((100*2)+(100-99))-200), ((100*1)-90)

		System.out.print("수식 입력 [ex: ((3*5)-(6/2))] => ");
		exp = scan.next();
		System.out.println(exp);
		if (opt.testPair(exp)) {
			System.out.println("괄호 맞음!");
		} 
		else {
			System.out.println("괄호 틀림!");
			return;
		}
		
		System.out.printf("\n후위표기식 : ");
		postfix = opt.infixTopostfix(exp);
		System.out.println(postfix);
	}
}

class OptExp {
	private String exp;
	private int expSize;
	private char testCh, openPair;

	public boolean testPair(String exp) {	// 괄호 짝이 맞는지 검사(스택)
		this.exp = exp;
		LinkedStack S = new LinkedStack();
		expSize = this.exp.length();
		for (int i = 0; i < expSize; i++) {
			testCh = this.exp.charAt(i); // 한 문자씩 추출.
			switch (testCh) {
			case '(':
			case '{':
			case '[':
				S.push(testCh);
				break;
			case ')':
			case '}':
			case ']':
				if (S.isEmpty())
					return false;
				else {
					openPair = (char) S.pop();
					if ((openPair == '(' && testCh != ')') 
							|| (openPair == '{' && testCh != '}')
							|| (openPair == '[' && testCh != ']'))
						return false;
					else
						break;
				}
			}
		}
		if (S.isEmpty())
			return true;
		else
			return false;

//		StringTokenizer st = new StringTokenizer(exp, "[{()}]+-*/", true);
//		LinkedStack stack = new LinkedStack();
//		do {
//			
//		} while(true);		
	}
	
	public String infixTopostfix(String infix) {	// 중위식을 후위식으로 변환(스택)
		char testCh;
		StringBuilder postfix = new StringBuilder();
		LinkedStack S = new LinkedStack();
		for(int i=0; i<infix.length(); i++ ) {
			testCh = infix.charAt(i);
			switch (testCh) {
				case '0' :
				case '1' :
				case '2' :
				case '3' :
				case '4' :
				case '5' :
				case '6' :
				case '7' :
				case '8' :
				case '9' :
					postfix.append(testCh);
					break;
				
				case '+' :
				case '-' :
				case '*' :
				case '/' :
					postfix.append(' ');	// 각 오퍼랜드 값을 구분하기 위한 구분자로 사용.
					S.push(testCh);
					break;
				
				case ')' :
				case '}' :
				case ']' :
					postfix.append(' ');	// 각 오퍼랜드의 값을 구분하기 위한 구분자.
					postfix.append((char)S.pop());
					break;
					
				default :
				
			}
		}
		return postfix.toString();
	}
	
	
	public int evalPostfix(String postfix) {	// 후위식을 이용해서 연산 결과 출력(스택)
		LinkedStack S = new LinkedStack();
		StringBuilder val = new StringBuilder();
		exp = postfix;
		int opr1, opr2, value;
		char testCh;
		
		for(int i=0; i<postfix.length(); i++) {
			testCh = exp.charAt(i);
			if(testCh != '+' && testCh != '-' && testCh != '*' && testCh != '/') {	// 연산자가 아니면 실행.
				if(testCh >= '0' && testCh <= '9') {	// testCh의 값이 정수 범위일 때 48('0'), 57('9')
					val.append(testCh);	// 수치문자를 val에 저장.
					continue;
				}
				if(val.length() != 0) {
					value = Integer.parseInt(val.toString());	// 수치문자열을 숫자로 변환
					S.push(value);	// 수치문자열을 숫자로 변환한 값 스택에 저장.
					val.delete(0, val.length());	// val 문자열 객체를 초기화 시킴
				}
			}
			else {
				opr2 = S.pop();
				opr1 = S.pop();
				switch(testCh) {
				case '+' : S.push(opr1 + opr2); break;
				case '-' : S.push(opr1 - opr2); break;
				case '*' : S.push(opr1 * opr2); break;
				case '/' : S.push(opr1 / opr2); break;
				}
			}
		}
		return S.pop();
	}
}

class LinkedStack implements Stack {
	private StackNode top;

	public LinkedStack() {

	}

	@Override
	public boolean isEmpty() { // 빈 스택인지 체크.
		if (this.top == null) {
			System.out.println("비어있는 스택입니다.");
			return true;
		}
		return false;
	}

	@Override
	public void push(int item) { // 데이터 삽입.
		StackNode newNode = new StackNode();
		newNode.data = item;
		newNode.link = top;
		top = newNode;
//		System.out.println("Insertd Item : " + item);
	}

	@Override
	public int pop() { // 데이터 삭제(데이터 반환 후).
		if (isEmpty()) {
			System.out.println("삭제 실패...스택이 비어있습니다.");
			return 0;
		}
		int item = top.data;
		top = top.link;
		return item;
	}

	@Override
	public void delete() { // 데이터만 삭제 (반환값 없음).
		if (isEmpty()) {
			System.out.println("삭제 실패...스택이 비어있습니다.");
		}
		top = top.link;
	}

	@Override
	public int peek() { // 스택 포인터(top) 위치 데이터 값만 반환.
		if (isEmpty()) {
			System.out.println("Peek 실패..스택이 비어있습니다.");
			return 0;
		}
		return top.data;
	}

	public void printStack() { // 스택의 데이터 출력.
		if (isEmpty()) {
			System.out.println("비어있는 스택입니다.");
			return;
		}
		StackNode temp = top;
		System.out.println("Linked Stack>> ");
		while (temp != null) {
			System.out.printf("%c ", temp.data);
			temp = temp.link;

		}
		System.out.println();
	}
}


class StackNode {
	int data;
	StackNode link;
}