package ex11;

import java.util.Arrays;

class Sort {
	public void selectionSort(int a[]) {
		int i, j;
		for (i = 0; i < a.length - 1; i++) {	//선택 정렬의 실제 비교 횟수: n-1번
			for (j = i + 1; j < a.length; j++) {	//// 기준이 되는 수 제외 숫자를 비교하여 최소숫자를 찾음
				if (a[i] > a[j]) { // 오름차순
					int temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
			System.out.printf("\n선택 정렬 %d 단계 ", i + 1);
//			for (j = 0; j < a.length; j++)
//				System.out.printf("%3d", a[j]);
			System.out.println("정렬된 원소 : " + Arrays.toString(a));
		}
	}
}

public class ex11_1_SelectionSort {
	public static void main(String args[]) {
		int a[] = { 69, 10, 30, 2, 16, 8, 31, 22 };
		Sort S = new Sort();
		System.out.printf("\n정렬할 원소 : ");
		for (int i = 0; i < a.length; i++) {
			System.out.printf("%d ", a[i]);
		}
		System.out.println();
		S.selectionSort(a);
	}
}
