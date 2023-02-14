package ex11;

import java.util.Arrays;

class Sort6 {
    private int sorted[] = new int[8];

    public void merge(int a[], int begin, int middle, int end) {
        int size = a.length;
        int i, j, k, t;
        i = begin;
        j = middle + 1;
        k = begin;
        while (i <= middle && j <= end) {
            if (a[i] <= a[j])
                sorted[k] = a[i++]; // 왼쪽
            else
                sorted[k] = a[j++]; // 오른쪽
            k++;
        }
        if (i > middle) {    // 왼쪽이 먼저 머지가 끝났을때
            for (t = j; t <= end; t++, k++)
                sorted[k] = a[t];
        } else {            // 오른쪽이 먼저 머지가 끝났을때
            for (t = i; t <= middle; t++, k++)
                sorted[k] = a[t];
        }

        for (t = begin; t <= end; t++) // 단계별 정렬 결과 저장
            a[t] = sorted[t];
        System.out.printf("\n 병합 정렬 >> ");
        for (t = 0; t < size; t++)
            System.out.printf("%3d ", a[t]);
    }

    public void mergeSort(int a[], int begin, int end) {
        int middle;
        if (begin < end) {
            middle = (begin + end) / 2;
            mergeSort(a, begin, middle); // 분할된 영역의 왼쪽
            mergeSort(a, middle + 1, end); // 분할된 영역의 오른쪽
            merge(a, begin, middle, end);
        }
    }
}

public class ex11_6_MergeSort {
	public static void main(String args[]) {
		int a[] = { 69, 10, 30, 2, 16, 8, 31, 22 };
		int size = a.length;
		Sort6 S = new Sort6();
		System.out.printf("\n정렬할 원소 : ");
		for (int i = 0; i < a.length; i++) {
			System.out.printf("%d ", a[i]);
		}
		System.out.println();
		S.mergeSort(a, 0, size - 1);
	}
}
