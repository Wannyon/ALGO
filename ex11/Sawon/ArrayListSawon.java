package ex11.Sawon;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListSawon {
	public static void main(String[] args) {
		ArrayList<Sawon> list = new ArrayList<Sawon>();
		int menu;

		Scanner scan = new Scanner(System.in);

		while (true) {
			printMenu();
			System.out.print("메뉴 선택 => ");
			menu = scan.nextInt();
			System.out.println();

			if (menu == 6) {
				System.out.println("The End...");
				break;
			}

			switch (menu) {
			case 1:
				input_sawon(list);
				break;
			case 2:
				output_sawon(list);
				break;
			case 3:
				search_sawon(list);
				break;
			case 4:
				update_sawon(list);
				break;
			case 5:
				delete_sawon(list);
				break;
			default:

			}
		}
	}

	static void printMenu() {
		System.out.println("*** 사원관리 ***");
		System.out.println("1. 사원정보 입력");
		System.out.println("2. 사원정보 출력");
		System.out.println("3. 사원정보 조회");
		System.out.println("4. 사원정보 수정");
		System.out.println("5. 사원정보 삭제");
		System.out.println("6. 프로그램 종료");
		System.out.println();
	}

	static void input_sawon(ArrayList<Sawon> list) {
		Sawon obj = new Sawon();
		obj.inputData();
		for (Sawon dat : list) {
			if (obj.irum.equals(dat.irum)) {
				System.out.println("\n사원번호 입력 오류(중복)!!\n");
				return;
			}
		}
		list.add(obj);
		System.out.println("\n사원정보 입력 성공!!\n");
	}

	static void output_sawon(ArrayList<Sawon> list) {
		int i, j;
		if (list.size() == 0) {
			System.out.println("출력할 사원정보가 없습니다!!\n");
			return;
		}

		System.out.println("\t      *** 사원정보 ***");
		System.out.println("============================================");
		System.out.println("사원번호       부서명         이름         성별                이메일");
		System.out.println("============================================");
		for (Sawon dat : list) {
			dat.outputData();
		}
		System.out.println("============================================");
		System.out.printf("\t\t 총사원수 : %d\n\n", list.size());

		
		
		for (i = 0; i < list.size()-1; i++) {
			for (j = i + 1; j < list.size(); j++) {
				if (list.get(i).irum.compareTo(list.get(j).irum) > 0) { // 오름차순
					Sawon obj = list.get(i);	// 데이터 교환
					list.set(i, list.get(j));
					list.set(j, obj);
				}
			}
		}
		
		System.out.println("\t      *** 사원정보(이름순) ***");
		System.out.println("============================================");
		System.out.println("사원번호       부서명         이름         성별                이메일");
		System.out.println("============================================");
		for (Sawon dat : list) {
			dat.outputData();
		}
		System.out.println("============================================");
		System.out.printf("\t\t 총사원수 : %d\n\n", list.size());
	}

	static void search_sawon(ArrayList<Sawon> list) {
		Scanner scan = new Scanner(System.in);

		System.out.print("조회할 사원번호 입력 => ");
		String sabun = scan.next();

		for (Sawon dat : list) {
			if (sabun.equals(dat.sabun)) {
				System.out.println("\n사원번호       부서명         이름         성별                이메일");
				System.out.println("============================================");
				dat.outputData();
				System.out.println("============================================\n");
				return;
			}
		}
		System.out.println("\n조회할 사원번호 입력 오류!!\n");
	}

	static void update_sawon(ArrayList<Sawon> list) {
		Scanner scan = new Scanner(System.in);

		System.out.print("수정할 사원번호 입력 => ");
		String sabun = scan.next();

		for (Sawon dat : list) {
			if (sabun.equals(dat.sabun)) {
				System.out.print("부서명 입력 => ");
				dat.deptname = scan.next();
				System.out.print("이름 입력 => ");
				dat.irum = scan.next();
				System.out.print("성별 입력 => ");
				dat.gender = scan.next();
				System.out.print("이메일 입력 => ");
				dat.email = scan.next();
				System.out.println("\n사원정보 수정 성공!!\n");
				return;
			}
		}
		System.out.println("\n수정할 이름 입력 오류!!\n");
	}

	static void delete_sawon(ArrayList<Sawon> list) {
		Scanner scan = new Scanner(System.in);

		System.out.print("삭제할 사원번호 입력 => ");
		String sabun = scan.next();

		for (Sawon dat : list) {
			if (sabun.equals(dat.sabun)) {
				list.remove(dat);
				System.out.println("\n사원정보 삭제 성공!!\n");
				return;
			}
		}
		System.out.println("\n삭제할 사원번호 입력 오류!!\n");
	}
}
