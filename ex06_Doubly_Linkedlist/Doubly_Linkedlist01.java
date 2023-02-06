package ex06_Doubly_Linkedlist;

import java.util.Scanner;

public class Doubly_Linkedlist01 {
	static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		LinkedList L = new LinkedList();
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
				L.insertNode(data);
				break;
			case 2:
				L.printList();
				break;
			case 3:
				System.out.println();
				data = new Sungjuk();
				System.out.print("검색할 번호 입력 => ");
				data.setNum(in.nextInt());
				L.searchNode(data);
				break;
			case 4:
				System.out.println();
				data = new Sungjuk();
				System.out.print("삭제할 번호 입력 => ");
				data.setNum(in.nextInt());
				L.deleteLastNode(data);
				break;
			default:
				System.out.printf("\n메뉴를 다시 입력하세요!!!\n");
				break;
			}
		} 
		while (true);

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

class LinkedList {
	private ListNode head;

	public LinkedList() { // 생성자
		head = null;
	}

	public void insertNode(Sungjuk data) {
		ListNode newNode = new ListNode(data);
		Sungjuk obj = null;

		if (head == null) { // 빈 리스트
			this.head = newNode;
			System.out.println("\n삽입 성공!!!");
			return;
		}

		ListNode temp = head;	// 후행노드
		ListNode pre = null;	// 선행노드
		
		while (temp != null) { // 마지막 노드 찾는 과정.
			obj = temp.getData();
			
			if (data.getNum() == obj.getNum()) {	// 번호 중복 데이터 체크
				System.out.printf("\n입력 오류 - 존재하는 번호입니다!!!\n");
				return;
			}
			pre = temp;
			temp = temp.rlink;
		}
		
		pre.rlink = newNode;
		newNode.llink = pre;
		
		System.out.println("\n삽입 성공!!!");
	}

	public void deleteLastNode(Sungjuk data) {
		ListNode pre, temp;
		Sungjuk obj = null;
		
		if(this.head == null) {	// 빈 리스트 검사
			System.out.printf("\n삭제 오류...리스트에 데이터가 없습니다.\n");
			return;
		}
		
		if(this.head.rlink == null) {	//리스트에 노드가 한 개만 있는 경우
			temp = this.head;
			obj = temp.getData();
			if(data.getNum() == obj.getNum()) {	// 첫번째 노드의 번호와 일치하는 경우
				System.out.printf("\n삭제 성공!!!\n");
				head = null;	// 리스트 시작 포인터를 null로 설정한다.
				return;
			}
			else {	// 노드가 하나밖에 일치하지 않는 경우
				System.out.printf("\n삭제 오류...일치하는 번호가 없습니다.\n");
				return;
			}
		}
				
		else {	// 리스트에 노드가 여러 개 있는 경우.
			temp = this.head;
			obj = temp.getData();
			if (data.getNum() == obj.getNum()) {	// 노드가 여러 개일때 첫번째 노드가 삭제할 노드인 경우
				System.out.printf("\n삭제 성공!!!\n");
				this.head = this.head.rlink;	// 후속노드의 주소를 선행노드의 링크에 저장
				head.llink = null;
				return;
			}
			else {	// 삭제할 노드가 두번째 노드 이후에 존재하는 경우
				temp = head.rlink;	// 두번째 노드의 주소 저장
				while(temp != null) {
					obj = temp.getData();
					if (data.getNum() == obj.getNum()) {
						System.out.print("\n삭제 성공!!!\n");
						if (temp.rlink == null) {
							temp.llink.rlink = temp.rlink;	// 선행 노드가 마지막 노드이므로 링크에 null 저장.
							return;
						}
						else {
							temp.llink.rlink = temp.rlink;	// 후속 노드의 주소를 선행노드의 링크에 저장
							temp.rlink.llink = temp.llink;	// 선행 노드의 주소를 후속노드의 링크에 저장
							return;
						}
					}
					else {
						temp = temp.rlink;
					}
				}
			}
			if (temp == null)
				System.out.printf("\n삭제 오류...일치하는 번호가 없습니다.\n");
		}
	}
//
	public void searchNode(Sungjuk data) {
		ListNode temp = this.head;
		Sungjuk obj = null;

		if (this.head == null) {
			System.out.printf("\n리스트에 데이터가 없습니다!!!\n");
			return;
		}
		
		System.out.println();
		while (temp != null) {
			obj = temp.getData();
			if (data.getNum() == obj.getNum()) {
				System.out.println("번호	이름	점수");
				System.out.println("=====================");
				obj.printData();
				return;
			} 
			else
				temp = temp.rlink;
		}

	}
//
	public void printList() {
		ListNode temp = this.head;

		if (this.head == null) {
			System.out.printf("\n리스트에 데이터가 없습니다!!!\n");
			return;
		}

		System.out.println();
		System.out.println("번호	이름	점수");
		System.out.println("=====================");

		while (temp != null) {
			Sungjuk data = temp.getData();
			System.out.printf("%3d	%3s	%4d	\n", data.getNum(), data.getName(), data.getScore());
			temp = temp.rlink;
		}
		System.out.println("=====================");
	}
}

class ListNode {
	private Sungjuk data; // 직접 저장을 못하게 private를 써서 생성자를 통해서 값을 저장.
	public ListNode llink; // 객체 주소 저장
	public ListNode rlink;

	public ListNode() { // 디폴트 생성자 초기화
		this.data = null;
		this.llink = null;
		this.rlink = null;
	}

	public ListNode(Sungjuk data) {
		this.data = data;
		this.llink = null;
		this.rlink = null;
	}

	public ListNode(Sungjuk data, ListNode llink, ListNode rlink) {
		this.data = data;
		this.llink = llink;
		this.rlink = rlink;
	}

	public Sungjuk getData() {
		return this.data;
	}
}

class Sungjuk {
	private int num;
	private String name;
	private int score;

	public int getNum() {
		return this.num;
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

	public void printData() {
		System.out.printf("%3d %3s %4d", this.num, this.name, this.score);
	}

}