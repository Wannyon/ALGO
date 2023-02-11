package ex09;

import java.util.Scanner;

public class Fibonacci {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
	/*
		int fibo, i=0;
		int num1=0, num2= 1, sum=1;
		
		System.out.print("숫자 입력 => ");
		fibo = scan.nextInt();
		
		System.out.println();
		for(i=0; i<fibo; i++) {
			System.out.printf("%d ", sum);
			sum = num1 + num2;
			num1 = num2;
			num2 = sum;
		}
	*/
		
		//쓰레기 코드
//		int n, fibo;
//	
//		System.out.print("숫자 입력 => ");
//		n = scan.nextInt();
//		fibo = fibonacci(n);
//		System.out.printf("\n\n%d개의 factorial 값은 %d입니다.\n ", n, fibo);
//	}
//	
//	static int fibonacci(int n) {
//		int result;
//		int n1, n2, sum;
//		
//		if (n <= 1) {
//			n1 = 1;
//			result = n1;
//			return result;
//		}
//		
//		if (n == 2) {
//			n2 = 1;
//			result = n2;
//			return result;
//		}
		
		int n, i = 0;
		System.out.print("숫자 입력 => ");
		n = scan.nextInt();
		
		System.out.println();
		for (i=0; i<n; i++) {
			System.out.printf("%d ", fibonacci(i));
		}
	}
	
	static int fibonacci(int n) {
		if(n<=1) {
			return 1;
		}
		return fibonacci(n-1) + fibonacci(n-2);
	}

}
