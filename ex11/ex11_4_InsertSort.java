package ex11;

class Sort4 {
	public void insertSort(int a[], int size) {
		int i, j, temp, t;

		for (i = 1; i < size; i++) {
			temp = a[i];
			for (j = i; j > 0 && (a[j - 1] > temp); j--) { // 기존 배열의 내용을 계속 탐색중일때
				a[j] = a[j - 1];
			}
			a[j] = temp; // j가 0이거나 a[j-1] <= temp 일때 실행
			System.out.printf("\n삽입 정렬 %d 단계 : ", i);
			for (t = 0; t < size; t++)
				System.out.printf("%3d ", a[t]);
//			System.out.println(Arrays.toString(a));
		}
	}

	public class ex11_4_InsertSort {
		public static void main(String args[]) {
			int a[] = { 69, 10, 30, 2, 16, 8, 31, 22 };
			int size = a.length;
			Sort4 S = new Sort4();
			System.out.printf("\n정렬할 원소 : ");
			for (int i = 0; i < a.length; i++) {
				System.out.printf("%d ", a[i]);
			}
			System.out.println();
			S.insertSort(a, size);
		}
	}
}