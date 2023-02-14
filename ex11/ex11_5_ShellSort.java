package ex11;

import java.util.Arrays;

class Sort5 {
	public void shellSort(int a[], int size) {
		int i, j, k =1, temp, h = size / 2;

		while (h >= 1) {
			for (i = 0; i < h; i++) {
				temp = a[i];
				for (j = i + h; j < size; j = j + h) {
					if (a[j] < temp) {
						temp = a[j - h];
						a[j - h] = a[j];
						a[j] = temp;
					}
					temp = a[j];
				}

			}
			h /= 2;
			System.out.printf("\n삽입 정렬 %d 단계 : ", k);
			System.out.println(Arrays.toString(a));
			k ++;
		}

//		int i, j, interval, t=0, temp;
//		interval = size/2;
//		while(interval>= 1) {
//			for (i=0; i<interval; i++) {
//				intervalSort(a, i, size-1, interval);
//			}
//			System.out.printf("\n셀정렬 %d 단계 : interval = %d >> ", ++t, interval);
//			System.out.println(Arrays.toString(a));
//			System.out.println();
//			interval /= 2;
//		}
//	}
//	
//	public void intervalSort(int a[], int begin, int end, int interval) {
//		int i, j, temp;
//		for (i=begin+interval; i<=end; i=i+interval) {
//			temp = a[i];
//			for(j=i-interval; j>=begin && temp<a[j]; j-=interval) {
//				a[j+interval] = a[j];
//			}
//			a[j+interval] = temp;
//		}

	}
}

public class ex11_5_ShellSort {
	public static void main(String args[]) {
		int a[] = { 69, 10, 30, 2, 16, 8, 31, 22 };
		int size = a.length;
		Sort5 S = new Sort5();
		System.out.printf("\n정렬할 원소 : ");
		for (int i = 0; i < a.length; i++) {
			System.out.printf("%d ", a[i]);
		}
		System.out.println();
		S.shellSort(a, size);
	}
}
