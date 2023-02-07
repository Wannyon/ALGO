package ex07;

interface Stack2 { // 인터페이스 메서드를 오버라이드 해야함.
	boolean isEmpty();

	void push(char item);

	char pop();

	void delete();

	char peek();
}

public class ex7_LinkedStack {
	public static void main(String args[]) {
		char deletedItem;
		LinkedStack LS = new LinkedStack();

		LS.push('A');
		LS.printStack();

		LS.push('B');
		LS.printStack();

		LS.push('C');
		LS.printStack();

		deletedItem = LS.pop();
		if (deletedItem != 0)
			System.out.println("deleted Item : " + deletedItem);
		LS.printStack();

		System.out.println("peek : " + LS.peek());
	}
}

class LinkedStack implements Stack2 {
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
	public void push(char item) { // 데이터 삽입.
		StackNode newNode = new StackNode();
		newNode.data = item;
		newNode.link = top;
		top = newNode;
		System.out.println("Insertd Item : " + item);
	}

	@Override
	public char pop() { // 데이터 삭제(데이터 반환 후).
		if (isEmpty()) {
			System.out.println("삭제 실패...스택이 비어있습니다.");
			return 0;
		}
		char item = top.data;
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
	public char peek() { // 스택 포인터(top) 위치 데이터 값만 반환.
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
	char data;
	StackNode link;
}
