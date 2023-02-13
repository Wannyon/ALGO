package ex11;

class Sort3 {
	int i = 0;

	public int partition(int a[], int begin, int end) {
		int pivot, temp, L, R, t;

		L = begin;
		R = end;
		pivot = (begin + end) / 2;
		System.out.printf("\n[퀵정렬 %d 단계 : pivot=%d ]\n", ++i, a[pivot]);
		while (L < R) {
			while ((a[L] < a[pivot]) && (L < R))
				L++; // 피봇 기준으로 왼쪽에서 교환할 데이터 찾는 작업(왼쪽->오른쪽)
			while ((a[R] >= a[pivot]) && (L < R))
				R--; // 피봇 기준으로 오른쪽에서 교환할 데이터 찾는 작업(오른쪽->왼쪽)
			if (L < R) { // 피봇 기준으로 교환할 데이터를 찾았을 때
				temp = a[L];
				a[L] = a[R];
				a[R] = temp;
			}
		}
		// 피봇과 L과 R이 만난 위치 교환
		temp = a[pivot];
		a[pivot] = a[R];
		a[R] = temp;

		for (t = 0; t < a.length; t++) // 단계별 수행 결과 출력
			System.out.printf("%3d", a[t]);
		System.out.println();
		return L; // return R;
	}

	public void quickSort(int a[], int begin, int end) {
		if (begin < end) {
			int p;
			p = partition(a, begin, end);
			quickSort(a, begin, p - 1); // 좌측 분할
			quickSort(a, p + 1, end); // 우측 분할
		}
	}
}

public class ex11_3_QuickSort {
	public static void main(String args[]) {
		int a[] = { 69, 10, 30, 2, 16, 8, 31, 22 };
		Sort3 S = new Sort3();
		System.out.printf("\n정렬할 원소 : ");
		for (int i = 0; i < a.length; i++) {
			System.out.printf("%d ", a[i]);
		}
		System.out.println();
		S.quickSort(a, 0, 7);
	}
}
