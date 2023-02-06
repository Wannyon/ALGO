package ex06_Circular_Linkedlist;

import java.util.Scanner;

public class Circular_Linkedlist {
	static Scanner in = new Scanner(System.in);
	
	public static void main(String args[]){
		LinkedList L = new LinkedList();
		Sungjuk data;
		int menu;
		
		do
		{
			print_menu();
			System.out.printf("\n메뉴 선택 => ");
			menu = in.nextInt();
			if (menu == 5)
			{
				System.out.printf("\n프로그램 종료...\n");
				break;
			}

			switch (menu)
			{
				case 1:
					System.out.println();
					data = new Sungjuk();
					System.out.print("번호 입력 => ");
					data.setBunho(in.nextInt());
					System.out.print("이름 입력 => ");
					data.setIrum(in.next());
					System.out.print("점수 입력 => ");
					data.setJumsu(in.nextInt());
					L.insertLastNode(data);
					break;
				case 2:
					L.printList();
					break;
				case 3:
					System.out.println();
					data = new Sungjuk();
					System.out.print("검색할 번호 입력 => ");
					data.setBunho(in.nextInt());
					L.searchNode(data);
					break;
				case 4:
					System.out.println();
					data = new Sungjuk();
					System.out.print("삭제할 번호 입력 => ");
					data.setBunho(in.nextInt());
					L.deleteNode(data);
					break;
				default:
					System.out.printf("\n메뉴를 다시 입력하세요!!!\n");
					break;
			}

		}while(true);
	}
	
	static void print_menu()
	{
		System.out.printf("\n*** 메뉴 ***\n");
		System.out.printf("1. 데이터 입력\n");
		System.out.printf("2. 데이터 출력\n");
		System.out.printf("3. 데이터 검색\n");
		System.out.printf("4. 데이터 삭제\n");
		System.out.printf("5. 프로그램 종료\n");
	}
}

class LinkedList{
	private ListNode head;
	
	public LinkedList(){
		head = null;
	}
	
	public void insertLastNode(Sungjuk data){
		ListNode newNode = new ListNode(data);
		ListNode pre = null;
		Sungjuk obj = null;
		
		if(head == null){
			this.head = newNode;
			newNode.link = newNode; // 수정
			System.out.println("\n삽입 성공!!!");
			return;
		}
		
		ListNode temp = head;
		do{
			obj = temp.getData();
			if (data.getBunho() == obj.getBunho())
			{
				System.out.printf("\n입력 오류 - 존재하는 번호임!!!\n");
				return;
			}
			pre = temp;
			temp = temp.link;
		}while(temp != head); // 번호 중복 데이터 체크(수정);

		pre.link = newNode;
		newNode.link = head;
		System.out.println("\n삽입 성공!!!");		
	}
	
	public void printList(){
		ListNode temp = this.head;
		
		if(this.head == null)  
		{
			System.out.printf("\n리스트에 데이터가 없음!!!\n");
			return;
		}
		
		System.out.println();
		System.out.println("번호   이름   점수");
		System.out.println("===============");
		do{
			Sungjuk obj = temp.getData();
			obj.printData();
			temp = temp.link;		
		}while(temp != head);  // 수정
		System.out.println("===============");
	}
	
	public void searchNode(Sungjuk data){
		ListNode temp = this.head;
		Sungjuk obj = null;
		
		System.out.println();
		if (head == null)
		{
			System.out.println("리스트에 대이터가 없음!!!");
			return;
		}
		
		do{
			obj = temp.getData();
			if(data.getBunho() == obj.getBunho())  
			{
				System.out.println("번호   이름   점수");
				System.out.println("===============");
				obj.printData();
				return;
			}
			else temp = temp.link;
		}while(temp != head); // 수정
		System.out.println("검색 오류-일치하는 번호가 없음!!!");
	}
	
	public void deleteNode(Sungjuk data){
		ListNode pre, temp;
		Sungjuk obj = null;
		
		if(this.head == null)  
		{
			System.out.printf("\n삭제 오류-리스트에 데이터가 없음!!!\n");
			return;
		}
		
		if(this.head.link == head){ // ***리스트에 노드가 한 개만 있는 경우***(수정)
			temp = this.head;
			obj = temp.getData();
			if (data.getBunho() == obj.getBunho()) // 첫번째 노드의 번호와 일치하는 경우
			{
				System.out.printf("\n삭제 성공!!! \n");
				head = null; // 리스트 시작 포인터를 null로 설정한다.
				return;
			}
			else  // 노드가 하나밖에 없는데 번호가 일치하지 않는 경우
			{
				System.out.printf("\n삭제 오류-일치하는 번호가 없음!!!\n");
			}
		}
		else{  // ***리스트에 노드가 여러 개 있는 경우***
			temp = this.head;
			obj = temp.getData();
			if (data.getBunho() == obj.getBunho()) // 노드가 여러 개일때 첫번째 노드가 삭제할 노드인 경우
			{
				System.out.printf("\n삭제 성공!!!\n");
				while(temp.link != head) // 수정
					temp = temp.link;    // 수정  
				temp.link = head.link;   // 수정
				this.head = this.head.link; // 후속 노드의 주소를 선행노드의 링크에 저장
			}
			else
			{
				pre = head; // 첫번째 노드의 주소 저장
				temp = head.link; // 두번째 노드의 주소 저장
				do{
					obj = temp.getData();
					if (data.getBunho() == obj.getBunho()) 
					{
						System.out.printf("\n삭제 성공!!!\n");
						pre.link = temp.link; // 후속 노드의 주소를 선행노드의 링크에 저장
						return;
					}
					else
					{
						pre = temp;
						temp = temp.link;
					}
				}while(temp != head); // 수정
			}
			System.out.printf("\n삭제 오류-일치하는 번호가 없음!!!\n");
		}
	}
}

class ListNode{
	private Sungjuk data;
	public ListNode link;
	
	public ListNode(){
		this.data = null;
		this.link = null;
	}
	public ListNode(Sungjuk data){
		this.data = data;
		this.link = null;
	}
	
	public Sungjuk getData(){
		return  this.data;
	}
}

class Sungjuk {
	private int bunho;
	private String irum;
	private int jumsu;
	
	public int getBunho() {
		return bunho;
	}
	public void setBunho(int bunho) {
		this.bunho = bunho;
	}
	public String getIrum() {
		return irum;
	}
	public void setIrum(String irum) {
		this.irum = irum;
	}
	public int getJumsu() {
		return jumsu;
	}
	public void setJumsu(int jumsu) {
		this.jumsu = jumsu;
	}
	
	public void printData() {
		System.out.printf("%3d  %3s %4d %n", this.bunho, this.irum, this.jumsu);
	}
}