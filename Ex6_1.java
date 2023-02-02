package ex06;

public class Ex6_1 {
	public static void main(String args[]) {
		LinkedList L = new LinkedList();
		
		System.out.println("(1) 공백 리스트에 노드 3개 삽입하기");
		L.insertLastNode("월");
		L.insertLastNode("수");
		L.insertLastNode("일");
		L.printList();

		System.out.println("(2) 수 노드 뒤에 금 노드 삽입하기");
		ListNode pre = L.searchNode("수");
		if (pre == null)
			System.out.println("검색실패>> 찾는 데이터가 없습니다.");
		else {
			L.insertMiddleNode(pre, "금");
			L.printList();
		}

		System.out.println("(3) 리스트의 노드를 역순으로 바꾸기");
		L.reverseList();
		L.printList();

		System.out.println("(4) 리스트의 마지막 노드 삭제하기");
		L.deleteLastNode();
		L.printList();
		
		System.out.println("(5) 리스트의 중간 노드 금 삭제하기");
		L.deleteMiddleNode("금");
		L.printList();

		
	}
}

class LinkedList {
	private ListNode head;

	public LinkedList() {	// 생성자
		head = null;
	}

	public void insertMiddleNode(ListNode pre, String data) {
		ListNode newNode = new ListNode(data);
		newNode.link = pre.link;
		pre.link = newNode;
	}

	public void insertLastNode(String data) {
		ListNode newNode = new ListNode(data);
		if (head == null) {
			this.head = newNode;
		} else {
			ListNode temp = head;
			while (temp.link != null)
				temp = temp.link;
			temp.link = newNode;
		}
	}

	public void deleteLastNode() {
		ListNode pre, temp;
		if (head == null)
			return;
		if (head.link == null) {
			head = null;
		} else {
			pre = head;
			temp = head.link;
			while (temp.link != null) {
				pre = temp;
				temp = temp.link;
			}
			pre.link = null;
		}
	}
	
	public void deleteMiddleNode(String data) {
		ListNode pre, temp;		// pre : 선행노드, temp : 삭제할 노드
		if (head == null) {
			return;
		}
		if (head.link == null) {
			if (head.getData() != data) {
				return;
			}
			else
				head = null;
		}
		else {
			temp = head;
			if (temp.getData() != data) {
				do {
					pre = temp;
					temp = temp.link;
					if (temp == null)
						break;
				}
				while (temp.getData() != data);
				
				if (temp != null) {
					pre.link = temp.link;
				}
				else {
					head = temp.link;
				}
				
				
				
			}
			//pre.link = temp.link;	//null 값이 들어가서 참조 불가능.
		}
		
	}

	public ListNode searchNode(String data) {
		ListNode temp = this.head;
		while (temp != null) {
			if (data == temp.getData())
				return temp;
			else
				temp = temp.link;

		}
		return temp;

	}

	public void reverseList() {
		ListNode next = head;
		ListNode current = null;
		ListNode pre = null;
		while (next != null) {
			pre = current;
			current = next;
			next = next.link;
			current.link = pre;

		}
		head = current;

	}

	public void printList() {
		ListNode temp = this.head;
		System.out.printf("L = (");
		while (temp != null) {
			System.out.printf(temp.getData());
			temp = temp.link;
			if (temp != null) {
				System.out.printf(", ");
			}
		}
		System.out.println(")");
	}
}

class ListNode {
	private String data;	// 직접 저장을 못하게 private를 써서 생성자를 통해서 값을 저장.
	public ListNode link;	// 객체 주소 저장

	public ListNode() {		// 디폴트 생성자 초기화
		this.data = null;
		this.link = null;
	}

	public ListNode(String data) {
		this.data = data;
		this.link = null;
	}

	public ListNode(String data, ListNode link) {
		this.data = data;
		this.link = link;
	}

	public String getData() {
		return this.data;
	}
}
