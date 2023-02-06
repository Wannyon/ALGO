package master;

import java.util.Scanner;

public class Ex5_ArrayList {
	static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		ArrayList arr = new ArrayList();
		Sungjuk data;
		int menu;
		
		do {
			print_menu();
			System.out.printf("\n메뉴 선택 => ");
			menu = in.nextInt();
			
			if (menu == 5) {
				System.out.printf("\n...프로그램 종료.\n");
				break;
			}
			
			switch (menu) {
			case 1:
				System.out.println();
				data = new Sungjuk();
				System.out.print("번호 입력 => ");
				data.setNum(in.nextInt());
				System.out.print("이름 입력 => ");
				data.setName(in.next());
				System.out.print("점수 입력 => ");
				data.setScore(in.nextInt());
				arr.insertLastNode(data);
				break;
			case 2:
				arr.printList();
				break;
			case 3:
				System.out.println();
				data = new Sungjuk();
				System.out.print("검색할 번호 입력 => ");
				data.setNum(in.nextInt());
				arr.searchNode(data);
				break;
			case 4:
				System.out.println();
				data = new Sungjuk();
				System.out.print("삭제할 번호 입력 => ");
				data.setNum(in.nextInt());
				arr.deleteNode(data);
				break;
			default:
				System.out.printf("\n메뉴를 다시 입력하세요!!!\n");
				break;
			}
		}
		while(true);
		
	}
	
	static void print_menu() {
		System.out.printf("\n*** 메뉴 ***\n");
		System.out.printf("1. 데이터 입력\n");
		System.out.printf("2. 데이터 출력\n");
		System.out.printf("3. 데이터 검색\n");
		System.out.printf("4. 데이터 삭제\n");
		System.out.printf("5. 프로그램 종료\n");
	}

}

class ArrayList {
	static int MAX = 10;
	static int cnt = 0;
	Sungjuk[] arr;
	
	ArrayList() {
		this.arr = new Sungjuk[MAX];
	}
	
	public void insertLastNode(Sungjuk data) {
		if (this.cnt == MAX) {
			System.out.println("\n메모리 풀(full)!!!\n");
			return;
		}
		
		this.arr[this.cnt++] = data;
		System.out.println("\n삽입 성공!!!\n");
		// 구현 cnt -> MAX까지 입력
	}
	
	public void printList() {
		Sungjuk data = null;
		if (this.arr.length == 0) {
			System.out.println("\n출력할 데이터가 없음!!!\n");
			return;
		}
		System.out.println();
		System.out.println("번호	이름	점수");
		System.out.println("===========");
		for (int i=0; i<this.cnt; i++) {
			System.out.printf("%3d	%3s	%4d	\n", this.arr[i].getNum(), this.arr[i].getName(), this.arr[i].getScore());
		}
		// 구현 Sungjuk[] 배열을 출력, 데이터가 없으면 없다고 출력
		
	}
	
	public void searchNode(Sungjuk data) {
		for (int i=0; i<this.cnt; i++) {
			if (data.getNum() == this.arr[i].getNum()) {
				System.out.println();
				System.out.println("번호	이름	점수");
				System.out.println("=====================");
				System.out.printf("%3d	%3s	%4d	\n", this.arr[i].getNum(), this.arr[i].getName(), this.arr[i].getScore());
				return;
			}
		}
		// 구현
		System.out.println("\n검색할 데이터가 없음!!!\n");
	}
	
	public void deleteNode(Sungjuk data) {
		for (int i=0; i<this.cnt; i++) {
			if (data.getNum() == this.arr[i].getNum()) {
				for (int k=i; k<this.cnt-1; k++) {
					this.arr[k] = this.arr[k+1];
				}
				this.cnt--;
				System.out.printf("\n삭제 성공!!!\n");
				return;
			}
		}
		System.out.printf("\n삭제할 데이터가 없음!!!\n");
		// 구현 cnt 값을 1감소.
	}
	
	
}


class Sungjuk {
	private int num;
	private String name;
	private int score;
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
}