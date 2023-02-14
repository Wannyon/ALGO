/* 자동으로 로또 번호 6개를 생성하여 출력하는 알고리즘을 구현하시오.
 * <처리조건>
 * 1. 로또 번호는 Random 클래스를 사용하며 1부터 45까지 생성한다.
 * 2. 로또 번호 출력시 오름차순으로 출력하며 정렬은 선택정렬을 사용한다.
 * 3. 로또 번호는 중복을 허용하지 않는다.
 * 
 * <알고리즘>
 * 1. 로또 번호를 저장할 배열을 선언
 * 2. 1~45까지의 난수를 6개 발생시켜 값을 저장
 * 3. 이러한 형태의 배열 값을 총 30개 저장 (6 * 30 총 180개 숫자)
 * 4. 하나의 회차(1회전 -> 값 6개) 진행 후 해당 값 출력
 * 5. 출력 전에 저장된 값을 순서대로 정렬
 * 6. 인접된 값이 서로 같으면 해당 로또 값은 폐기
 * 7. 이런 식으로 총 30회까지 진행
 * 8. 중복되지 않은 값이 총 5개까지 출력되면 프로그램 종료.
 */

package Lotto;

import java.io.IOException;
import java.util.Arrays;

public class Lotto {
	public static void main(String[] args) throws IOException {

		System.out.println("＊로또번호 랜덤 생성＊");
		int round = 0;
		int lotto_num[] = new int[6];

		String result = "";

		for (int i = 1; i <= 30; i++) {

			result = "";
			result += round + 1 + "회 : [ ";

			// 6개의 랜덤번호를 생성 저장
			for (int j = 0; j <= 5; j++) {
				int temp = (int) (Math.random() * 44 + 1);
				lotto_num[j] = temp;
			}

			// 저장된 숫자 정렬
			Arrays.sort(lotto_num);

			// 중복된 값 체크
			boolean duple = false;
			for (int k = 0; k < lotto_num.length; k++) {

				if (k == lotto_num.length - 1) { // 6번째 숫자일 경우
					result += lotto_num[k] + " ]";

				} else if (lotto_num[k] != lotto_num[k + 1]) { // list 내 인접한 숫자가 중복되지 않을 경우
					result += lotto_num[k] + ", \t";

				} else { // 중복된 숫자가 있을 경우 flag 체크
					duple = true;
				}
			}

			if (round == 5)
				break; // 로또번호는 5번만 출력

			if (duple == false) { // 중복된 숫자가 없으면 로또번호 출력
				round++;
				System.out.println(result);
			}
		}
	}
}
