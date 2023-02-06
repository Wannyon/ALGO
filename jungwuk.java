package master;

import java.util.Scanner;

public class jungwuk {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList arr = new ArrayList();
        Sungjuk data = new Sungjuk();
        int menu;
        do {
            print_menu();
            System.out.print("\n메뉴 선택 => ");
            menu = sc.nextInt();
            if (menu == 1) {
                input(arr, data);
            } else if (menu == 2) {
                arr.printList();
            } else if (menu == 3) {
                search(arr);
            } else if (menu == 4) {
                delete(arr);
            } else if (menu == 5) {
                System.out.println("\n프로그램 종료...");
                break;
            } else {
                System.out.println("\n메뉴를 다시 입력하세요.");
            }
        } while (true);
    }

    /**
     * 해당 위치의 성적을 삭제한다.
     * @param arr 저장된 배열
     */
    private static void delete(ArrayList arr) {
        String index;
        System.out.println();
        System.out.print("삭제할 번호 입력 : ");
        index = sc.next().trim();
        if (errors(isNotDigit(index), "\n잘못된 입력입니다. 입력값 : " + index + "\n메뉴를 다시 선택해주세요.")) {
            return;
        }
        arr.deleteNode(Integer.parseInt(index));
    }

    /**
     * 메뉴를 출력한다.
     */
    private static void print_menu() {
        System.out.println("\n*** 메뉴 ***");
        System.out.println("1. 데이터 입력");
        System.out.println("2. 데이터 출력");
        System.out.println("3. 데이터 검색");
        System.out.println("4. 데이터 삭제");
        System.out.println("5. 프로그램 종료");
    }

    /**
     * 데이터가 중복되지 않으면 "arr"에 저장한다.
     * @param arr 데이터들의 집합
     * @param data 저장할 데이터
     */
    private static void input(ArrayList arr, Sungjuk data) {
        System.out.println();
        data = new Sungjuk();
        String input;

        System.out.print("번호 입력 : ");
        input = sc.next().trim();
        if (errors(isNotDigit(input), "\n잘못된 입력입니다. 입력값 : " + input + "\n메뉴를 다시 선택해주세요.")) {
            return;
        }
        data.setId(Integer.parseInt(input));

        System.out.print("이름 입력 : ");
        data.setName(sc.next());

        System.out.print("점수 입력 : ");
        input = sc.next().trim();
        if (errors(isNotDigit(input), "\n잘못된 입력입니다. 입력값 : " + input + "\n메뉴를 다시 선택해주세요.")) {
            return;
        }
        data.setScore(Integer.parseInt(input));

        arr.insertLastNode(data);
    }

    /**
     * 에러가 존재하면 "true"를 반환하고 에러문을 출력한다.
     * @param error 에러의 유무
     * @param message    출력문
     * @return  에러가 존재하면 true
     */
    private static boolean errors(boolean error, String message) {
        if (error) {
            System.out.println(message);
            return true;
        }
        return false;
    }

    /**
     * 입력된 문자열이 숫자인지 판별
     * @param number 숫자인지 판정할 문자열
     * @return  숫자가 아니면 true
     */
    private static boolean isNotDigit(String number) {
        for (char c : number.toCharArray()) {
            if (!Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }

    /**
     * "Id"를 가지고 해당 데이터의 정보를 출력한다.
     * @param arr   데이터들의 집합
     */
    private static void search(ArrayList arr) {
        Sungjuk data;
        System.out.println();
        data = new Sungjuk();
        System.out.print("검색할 번호 입력 : ");
        data.setId(sc.nextInt());
        arr.searchNode(data);
    }


    static class ArrayList {
        private static final int MAX = 10;
        private final Sungjuk[] arr;
        private int cnt = 0;

        ArrayList() {
            arr = new Sungjuk[MAX];
        }

        public void insertLastNode(Sungjuk data) {
            if (contains(data)) {
                System.out.println("\n중복된 학번입니다. 입력된 학번 : " + data.getId() + "\n메뉴를 다시 선택해 주세요.");
                return;
            }
            this.arr[cnt++] = data;
        }

        public void printList() {
            printTopBar();
            for (int i = 0; i < cnt; i++) {
                printSungjuk(this.arr[i]);
            }
        }

        public void searchNode(Sungjuk data) {
            int index = indexOf(data);
            if (index == -1) {
                System.out.println("\n존재하지 않는 학번입니다. 입력된 학번 : "
                        + data.getId()
                        + "\n메뉴를 다시 선택해주세요.");
                return;
            }
            printTopBar();
            printSungjuk(arr[index]);
        }

        public void deleteNode(int index) {
            if (index == -1) {
                System.out.println("\n존재하지 않는 학번입니다"
                        + "\n메뉴를 다시 선택해주세요.");
                return;
            }
            for (int i = index; i < cnt; i++) {
                this.arr[i] = this.arr[i + 1];   //
            }
            cnt--;
        }

        /**
         * 데이터가 있는지 찾는다.
         * @param data 찾을 데이터
         * @return 데이터가 존재하면 true
         */
        private boolean contains(Sungjuk data) {
            int id = data.getId();
            for (int i = 0; i < cnt; i++) {
                if (this.arr[i].getId() == id) {
                    return true;
                }
            }
            return false;
        }

        /**
         * 해당 데이터의 위치
         * @param data 찾을 데이터
         * @return 해당 데이터의 위치, 해당 데이터가 없으면 -1
         */
        private int indexOf(Sungjuk data) {
            int id = data.getId();
            for (int i = 0; i < cnt; i++) {
                if (this.arr[i].getId() == id) {
                    return i;
                }
            }
            return -1;
        }

        private void printTopBar() {
            System.out.printf("%n%-4s %-5s   %-3s %n", "학번", "이름", "점수");
            System.out.println("=====================");
        }

        private void printSungjuk(Sungjuk data) {
            System.out.printf("%-4s   %-5s  %-3s %n", data.getId(), data.getName(), data.getScore());
        }
    }

    static class Sungjuk {
        private int id;
        private String name;
        private int score;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getScore() {
            return score;
        }

        public void setScore(int score) {
            this.score = score;
        }
    }
}