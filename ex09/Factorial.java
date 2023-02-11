/* 
[문제 1] 임의의 수(양의 정수)를 입력 받은 수에 대한 팩토리얼을 구하시오.
(단, 반복문 사용)
*/

package ex09;

import java.util.Scanner;

public class Factorial {
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
	/*
		int fac, result = 1;
		
		System.out.print("숫자 입력 => ");
		fac = scan.nextInt();
		
		for (int i=1; i<=fac; i++) {
			result *= i;
		}
		System.out.printf("%d ", result);
	 */
		
		int n, result;
		System.out.printf("정수를 입력하세요 => ");
		n = scan.nextInt();
		result = fact(n);
		System.out.printf("\n\n%d의 factorial 값은 %d입니다.\n ", n, result);
	}
	
	static int fact (int n) {
		int value;
		if (n<=1) {
			System.out.printf("\n fact(1) 함수 호출.");
			System.out.printf("\n fact(1)값 1 반환.");
			return 1;
		}
		else {
			System.out.printf("\n fact(%d) 함수 호출.", n);
			value = (n * fact(n-1));
			System.out.printf("\nfact(%d)값 %d 반환.", n, value);
			return value;
		}
	}

}
