package songmody.dongbinna.greedy;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.security.NoSuchAlgorithmException;
import java.time.LocalTime;
import java.util.*;

class Greedy {

    public void firstGreedy() {
        int N = 25;
        int k = 3;
        int cnt = 0;
        int tempN = 0;

        while (N > k) { // 6 / 3 2
            if (N % k != 0) {   //6 % 3 -> 0
                N = N - 1;  //N = 6
                cnt++;
                System.out.println("% N: " + N);
            } else {
                tempN = N / k; //tm = 6/3 -> 2
                cnt++;
                System.out.println("/ N : " + tempN);
                N = tempN; //n = 8
            }
        }
        if (N != 1) {
            N = N - 1;
            cnt++;
        }
//        while(N % k != 0){
//            N = N - 1;
//            cnt++;
//            System.out.println("% " + cnt);
//        }
//        tempN = N;
//
//        while(tempN / k != 1){
//            tempN = N / k;
//            cnt++;
//        }
        System.out.println("cnt : " + cnt);
    }

    public void secGreedy() {
        /*
         * wow 1일경우를 생각안했네
         * 대부분의 경우' '+' 보다는 'x'가 값을 더 크게 만듦
         * 더하는 두 수 중 0, 1이 있는 경우는 x보다는 +가 값을 더 크게 만듦
         * 따라서 1이하는 +, 2이상은 x가 가장 효율적임.
         * */
// // my sol1.
//        String S = "567";
//        int sum = 1;
//        for(int i = 0; i<S.length(); i++){
//            int tmp = Integer.parseInt(S.substring(i, i+1));
//            if(tmp == 0){
//                sum = sum + tmp;
//            }else{
//                sum = sum * tmp;
//            }
//        }
//        System.out.println("sum : " + sum);

// //        my sol2.
//        String S = "123";
//        int sum = 0;
//        for(int i = 0; i<S.length(); i++){
//            int tmp = Integer.parseInt(S.substring(i, i+1));
//            if(tmp <= 1){
//                sum = sum + tmp;
//            }else{
//                sum = sum * tmp;
//            }
//        }
//        System.out.println("sum : " + sum);


        // scanner 사용에도 익숙해져야할 필요가 있음.
        // charAt(0)을 사용하여 문자열 -> 하나의 문자뽑아내기
        // str.charAt(0) - '0'; 을 사용하면 뽑아낸 하나의 문자를 숫자로 변경가능
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        long res = str.charAt(0) - '0';
        for (int i = 1; i < str.length(); i++) {
            int tmp = str.charAt(i) - '0';
            if (tmp <= 1) {
                res += tmp;
            } else {
                res *= tmp;
            }
        }
        System.out.println("res : " + res);

    }

    public void thrGreedy() {
        // my sol.
//        // https://limkydev.tistory.com/170 -> 7/10 주말동안 습득해두기.
//        // 조건 1 : 공포도가 x인 모험가는 반드시 x명 이상으로 구성한 그룹참여필수
//        // N명의 모험가일때 최대그룹수는?
//        //
////        Scanner sc = new Scanner(System.in);
//        int N = 5; //sc.nextInt();
////        sc.nextLine();
//        String str = "4 5 2 3 2 2 1 3"; //sc.nextLine();
//        int strSize = str.length();
//        ArrayList<Integer> srtList = new ArrayList<>();
//        String stred = str.replace(" ", "");
//        long arg = stred.charAt(0) - '0';
//        srtList.add((int)arg);
//
//        for(int i =1; i < strSize - 7 ; i++){
//            int args = stred.charAt(i) - '0';
//            srtList.add(args);
//        }
//        Collections.sort(srtList, Collections.reverseOrder());
//        int cnt = 0;
//
//        while(srtList.size() > 0){
//            int grpCnt = srtList.get(0);
//
//            if(grpCnt != 1){
//                for(int j = 0; j<grpCnt; j++){
//                    srtList.remove(0);
//                }
//                cnt++;
//            }else{
//                srtList.remove(0);
//                cnt++;
//            }
//        }
//        System.out.println("cnt : " + cnt);
        /* dongbinna sol
         * 공포도가 큰 사람이 꼭 참여해야한다고 생각해서 위처럼 짰는데
         * 꼭 모든 인원이 나갈필요는 없다고 되어있으니
         * 오름차순으로 정렬을 해야 최대한 많은 그룹생성가능. 멍충멍충.... * */

        // 1. 받은 값 오름차순정렬
        // 2. index마다 공포도에 집착하지말고 인원1명이라고 생각하고 카운트하기
        // 3. cnt가 index.val보다 같거나 크면, 그룹생성
        int n = 0;
        ArrayList<Integer> arr = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
            System.out.println(arr.toString());
        }
        Collections.sort(arr);

        int res = 0;
        int cnt = 0;
        for (int k = 0; k < arr.size(); k++) {
            cnt++;
            if (cnt >= arr.get(k)) {
                res++;
                cnt = 0;
            }
        }
        System.out.println("cnt : " + cnt);
    }

    public void firstImpleGreedy() {
//        Scanner sc = new Scanner(System.in);
//        int N = 5; //sc.nextInt();
//        sc.nextLine();
//        String vector = sc.nextLine();
//        String vectored = "RRRUDD"; // vector.replaceAll(" ", "");
        // 수학의 x축, y축 개념이 아닌 매트릭스상의 튜플, 컬럼의 개념으로 생각하기.
        // dx -> 튜플 즉 세로로 이동, dy -> 컬럼 즉 가로로 이동
        // [동, 북, 서, 남]으로 정의한 방향배열을 선언하지만 index의 순서는 상관없을듯. 상하좌우만 파악하고있으면 ok
        // 동(우(0, 1), 북(상(-1, 0), 서(좌(0, -1), 남(하(1, 0) 정보를 가지고 있는 방향배열선언
//        int[] dx = new int[]{0, -1, 0, 1};
//        int[] dy = new int[]{1, 0, -1, 0};
//        int x = 1;
//        int y = 1;
//        int nx = 0;
//        int ny = 0;
//        for (int i = 0; i < vectored.length(); i++) {
//            char key = vectored.charAt(i);
//            System.out.println("key : " + key);
//            if (key == 'L') {
//                nx = x + dx[2]; //0
//                ny = y + dy[2]; //-1
//            } else if (key == 'R') {
//                nx = x + dx[0]; //0
//                ny = y + dy[0]; //1
//            } else if (key == 'U') {
//                nx = x + dx[1]; //-1
//                ny = y + dy[1]; //0
//            } else {
//                nx = x + dx[3]; //1
//                ny = y + dy[3]; //0
//            }
//            if ((nx < 1 || nx > 5) || (ny < 1 || ny > 5)) {
//                x = x;
//                y = y;
//                System.out.println("if (nx > N)  x : " + x + " y: " + y);
//            } else {
//                x = nx;
//                y = ny;
//                System.out.println("x : " + x + " y: " + y);
//            }
//        }
//        System.out.println("x : " + x + ", y: " + y);
        /*
         * dongbinna sol.
         * um switch문을 할필요가 없이 이중 for문으로 이동str_for1 in 방향벡터_for2를 하면 짧게 끝남..
         * */
//        Scanner sc = new Scanner(System.in);
        int N = 5; //sc.nextInt();
//        sc.nextLine();
//        String vector = sc.nextLine();
        String vectored = "RRRUDD"; // vector.replaceAll(" ", "");
        int[] dx = new int[]{0, -1, 0, 1};
        int[] dy = new int[]{1, 0, -1, 0};
        int x = 1;
        int y = 1;
        int nx = 0;
        int ny = 0;
        char[] vec = new char[]{'R', 'U', 'L', 'D'};

        for (int i = 0; i < vectored.length(); i++) {
            char tmp = vectored.charAt(i);
            for (int k = 0; k < vec.length; k++) {
                if (tmp == vec[k]) {
                    nx = x + dx[k];
                    ny = y + dy[k];
                }
            }
            if ((nx < 1 || nx > 5) || (ny < 1 || ny > 5)) continue; // continue를 잘 활용해보자!
            x = nx;
            y = ny;
        }
        System.out.println("x : " + x + ", y: " + y);
    }

    void secImpleGreedy() {
        // my sol. Date 라이브러리 사용을 고민하고 있었는데 . .
        // dongbinna sol. 단순히 가능한 경우의 수를 모두 검사해보는 완전탐색(Brute Forcing)법을 사용해야하는 문제였따. .
        // 하루는 24 * 60 * 60, 즉 86,400초 이므로 일일히 3을 포함하고 있는 시각인지 판단하게하기.
        // dongbinna에서는
        int N = 5;
        int cnt = 0;
        int mysolcnt = 0;
        for (int h = 0; h <= N; h++) {
            for (int m = 0; m < 60; m++) {
                for (int s = 0; s < 60; s++) {
                    // mySol, int -> string변환이 귀찮긴 하지만 추가 함수생성은 안해두됌.
                    // 근데 좀 구림. 안이쁨..
                    String time = Integer.toString(h) + Integer.toString(m) + Integer.toString(s);
                    if (time.contains("3")) {
                        mysolcnt++;
                    }
                    // dongbinna sol. 3의 존재여부를 int형 자료 그대로 판단하는 함수 생성.
                    // 근데 이게 더 깔끔하긴 하다 . . 쪼개는 연습을 하자!!!
                    if (checkFn(h, m, s)) cnt++;
                }
            }
        }
        // 결과값은 동일함. .
        System.out.println("cnt : " + cnt + "/ mysolcnt : " + mysolcnt);
    }

    boolean checkFn(int h, int m, int s) {
        if (h % 10 == 3 || m / 10 == 3 || m % 10 == 3 || s / 10 == 3 || s % 10 == 3) {
            return true;
        }
        return false;
    }

    void thrImpleGreedy() {
        //my sol.
        int[][] mat = new int[8][8];
        String spot = "c2";
        char[] alpha = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};
        int[] num = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        char alphaX = spot.charAt(0);
        int x = 1;
        int y = spot.charAt(1) - '0';
        int nx = 0;
        int ny = 0;
        for (int i = 0; i < alpha.length; i++) {
            if (alphaX == alpha[i]) {
                x = num[i];
            }
        }
        // 나이트가 움직일 수 있는 경로에 해당하는 방향벡터 선언
        int firstStep = 2;
        int secStep = 1;
        int cnt = 0;
//        // 나는 그냥 (2, 1)이 8번 반복되니깐 절댓값을 잘 이용해볼수 있지 않았을까 싶던것 뿐이고,,
//        // 멍청하면 손발이 고생한다더니만 딱 내 꼴,,!!!
//        System.out.println("x : " + x +" y : "+ y);
//        nx = x + firstStep;
//        ny = y + secStep;
//        System.out.println("nx : " + nx +", ny : " + ny);
//        if (nx >= 1 && nx < 9 && ny >= 1 && ny < 9) cnt++;
//        nx = x + firstStep;
//        ny = y + secStep * -1;
//        System.out.println("nx : " + nx +", ny : " + ny);
//        if (nx >= 1 && nx < 9 && ny >= 1 && ny < 9) cnt++;
//        nx = x + firstStep * -1;
//        ny = y + secStep;
//        System.out.println("nx : " + nx +", ny : " + ny);
//        if (nx >= 1 && nx < 9 && ny >= 1 && ny < 9) cnt++;
//        nx = x + firstStep * -1;
//        ny = y + secStep * -1;
//        System.out.println("nx : " + nx +", ny : " + ny);
//        if (nx >= 1 && nx < 9 && ny >= 1 && ny < 9) cnt++;
//
//        nx = x + secStep;
//        ny = y + firstStep;
//        System.out.println("nx : " + nx +", ny : " + ny);
//        if (nx >= 1 && nx < 9 && ny >= 1 && ny < 9) cnt++;
//        nx = x + secStep;
//        ny = y + firstStep * -1;
//        System.out.println("nx : " + nx +", ny : " + ny);
//        if (nx >= 1 && nx < 9 && ny >= 1 && ny < 9) cnt++;
//        nx = x + secStep * -1;
//        ny = y + firstStep;
//        System.out.println("nx : " + nx +", ny : " + ny);
//        if (nx >= 1 && nx < 9 && ny >= 1 && ny < 9) cnt++;
//        nx = x + secStep * -1;
//        ny = y + firstStep * -1;
//        System.out.println("nx : " + nx +", ny : " + ny);
//        if (nx >= 1 && nx < 9 && ny >= 1 && ny < 9) cnt++;
//        System.out.println("cnt : " + cnt);
        /*
         * dongbinna sol.
         * 나이트 움직일 수 있는 8개의 경로에 대한건 동일.
         * 그 경로를 1차원 배열로 만들어서 주입시켜서 푸는거,, 위에서 했잖아,,,,
         * */
        int col = spot.charAt(0) - 'a' + 1;
        int row = spot.charAt(1) - '0';
        int[] dx = new int[]{1, 1, -1, -1, 2, 2, -2, -2};
        int[] dy = new int[]{2, 2, -1, 1, -2, -2, -1, 1};

        for (int i = 0; i < 8; i++) {
            int dongNx = row + dx[i];
            int dongNy = col + dy[i];
            if (dongNx >= 1 && dongNx <= 8 && dongNy >= 1 && dongNy <= 8) cnt++;
        }
        System.out.println("dongCnt : " + cnt);
    }

    void fourImpleGreedy(){
        /* my sol.
        * 알파벳오름차순 + 숫자총합
        * 알파벳과 숫자를 분리하여 다른 로직을 진행할 수 있는
        * Character.isDigit()이나 다른 클래스의 숙지가 관건!!
        * */
        String S = "K1KA5CB7";
        int res = 0;
        ArrayList<String> sList = new ArrayList<>();

        for(int i = 0; i<S.length(); i++) {
            if (Character.isDigit(S.charAt(i))){
                res += S.charAt(i) - '0';
            }else{
                sList.add(Character.toString(S.charAt(i)));
            }
        }
        Collections.sort(sList);
//        System.out.println(sList.toString());
//        System.out.println(sList.toString() + res);
        String resS = "";
        for(int k = 0; k<sList.size(); k++){
            resS += sList.get(k);
        }
        System.out.println(resS + res);
    }

    public static void main(String[] args) {
        Greedy greedy = new Greedy();
//        greedy.firstGreedy();
//        greedy.secGreedy();
//        greedy.thrGreedy();
//        greedy.firstImpleGreedy();
//        greedy.secImpleGreedy();
//        greedy.thrImpleGreedy();
        greedy.fourImpleGreedy();
    }
}
