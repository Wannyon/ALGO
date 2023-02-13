package ex11;

class Sort2 {
	public void bubbleSort(int a[]) {
		int i, j, temp, size, flag;
		size = a.length;
		for (i = 0; i < size - 1; i++) {
			System.out.printf("\n선택 정렬 %d 단계 ", i + 1);
			flag = 0;
			for (j = 0; j < size - 1 - i; j++) {
				if (a[j] > a[j + 1]) { // 오름차순
					temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
					flag = 1;
				}
			}

			if (flag == 0)
				break;
			for (int k = 0; k < size; k++)
				System.out.printf("%3d", a[k]);
		}
	}
}

public class ex11_2_BubbleSort {
	public static void main(String args[]) {
		int a[] = { 69, 10, 30, 2, 16, 8, 31, 22 };
		Sort2 S = new Sort2();
		System.out.printf("\n정렬할 원소 : ");
		for (int i = 0; i < a.length; i++) {
			System.out.printf("%d ", a[i]);
		}
		System.out.println();
		S.bubbleSort(a);
	}
}
