package ex07;

interface Stack{	// 인터페이스 메서드를 오버라이드 해야함.
	boolean isEmpty();
	void push(char item);
	char pop();
	void delete();
	char peek();
}

public class ex7_ArrayStack {
	public static void main(String args[]){
		int stackSize = 5;
		char deletedItem;
		ArrayStack S = new ArrayStack(stackSize);
		
		S.push('A');
		S.printStack();
		
		S.push('B');
		S.printStack();
		
		S.push('C');
		S.printStack();
		
		deletedItem = S.pop();
		if(deletedItem != 0)
			System.out.println("deleted Item : " + deletedItem);
		S.printStack();		
	}
}

class ArrayStack implements Stack{
	private int top;
	private int stackSize;
	private char[] itemArray;
	private int i;
	
	public ArrayStack(int stackSize){
		top = -1;	// 인덱스가 0부터 시작하기 때문에 데이터가 없는 값은 -1.
		this.stackSize = stackSize;
		this.itemArray = new char[this.stackSize];
	}
	
	@Override
	public boolean isEmpty(){	// 빈 스택인지 체크.
		if (top == -1) {
			System.out.println("비어있는 스택입니다.");
			return true;
		}
		
		return false;
	}
	
	public boolean isFull(){	// 가득찬 스택인지 체크.
		if (top >= stackSize) {
			System.out.println("가득찬 스택입니다.");
			return true;
		}
		return false;
	}
	
	@Override
	public void push(char item){	// 데이터 삽입.
		this.top = top + 1;			// this.top++;
		if (isFull()) {
			System.out.println("스택이 가득찬 상태입니다.");
		}
		else {
			this.itemArray[this.top] = item;
			System.out.println("Inserted Item : " + item);
		}
	}
	
	@Override
	public char pop(){	// 데이터 삭제(데이터 반환 후).
		if (top == -1) {
			System.out.println("삭제할 데이터가 없습니다.");
			return '\u0000';		//'\u0000' char의 디폴트값
		}
		char temp = this.itemArray[this.top];	// 삭제전 반환값 temp에 전달.
		this.itemArray[this.top] = '\u0000';	// 디폴트값으로 초기화.
		this.top = top - 1;	// this.top--;		// 초기화 하지않고 top을 감소시키면 오버플로우?
		return temp;
	}
	
	@Override
	public void delete(){	// 데이터만 삭제 (반환값 없음).
		if (top == -1) {
			System.out.println("삭제할 데이터가 없습니다.");
		}
		else {
			this.itemArray[this.top] = '\u0000';	// 디폴트값으로 초기화.
			this.top = top - 1;	// this.top--;
		}
	}
	
	@Override
	public char peek(){	// 스택 포인터(top) 위치 데이터 값만 반환.
		return this.itemArray[this.top];
		
	}
	
	public void printStack(){	// 스택의 데이터 출력.
		this.i = 0;
		if (isEmpty()) {
			System.out.println("비어있는 스택입니다.");
			return;
		}
		
		while (this.top >= i) {
			System.out.print(itemArray[i]);
			this.i++;
		}
		System.out.println();
	}
}

