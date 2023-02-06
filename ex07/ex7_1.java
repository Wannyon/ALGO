package ex07;

interface Stack{	// 인터페이스 메서드를 오버라이드 해야함.
	boolean isEmpty();
	void push(char item);
	char pop();
	void delete();
	char peek();
}

class ArrayStack implements Stack{
	private int top;
	private int stackSize;
	private char itemArray[];
	
	public ArrayStack(int stackSize){
		top = -1;
		this.stackSize = stackSize;
		itemArray = new char[this.stackSize];
	}
	
	public boolean isEmpty(){	// 빈 스택인지 체크.
		
	}
	
	public boolean isFull(){	// 가득찬 스택인지 체크.
		
	}
	
	public void push(char item){	// 데이터 삽입.
		
	}
	
	public char pop(){	// 데이터 삭제(데이터 반환 후).
		
	}
	
	public void delete(){	// 데이터만 삭제 (반환값 없음).
		
	}
	
	public char peek(){	// 스택 포인터(top) 위치 데이터 값만 반환.
		
	}
	
	public void printStack(){	// 스택의 데이터 출력.
		
	}
}

public class ex7_1 {
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