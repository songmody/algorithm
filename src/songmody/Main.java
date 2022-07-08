package songmody;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public void firstGreedy(){
        int N = 25;
        int k = 3;
        int cnt = 0;
        int tempN = 0;

        while (N > k) { // 6 / 3 2
            if (N % k != 0) {   //6 % 3 -> 0
                N = N - 1;  //N = 6
                cnt++;
                System.out.println("% N: "+N);
            } else {
                tempN = N / k; //tm = 6/3 -> 2
                cnt++;
                System.out.println("/ N : " + tempN);
                N = tempN; //n = 8
            }
        }
        if(N != 1){
            N = N -1;
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

    public void secGreedy(){
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
        for(int i = 1; i< str.length(); i++){
            int tmp = str.charAt(i) - '0';
            if(tmp <= 1){
                res += tmp;
            }else {
                res *= tmp;
            }
        }
        System.out.println("res : " + res);

    }

    public void thrGreedy(){
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

        for(int i = 0; i<n; i++){
            arr.add(sc.nextInt());
            System.out.println(arr.toString());
        }
        Collections.sort(arr);

        int res = 0;
        int cnt = 0;
        for(int k = 0; k < arr.size(); k++){
            cnt++;
            if(cnt>= arr.get(k)){
                res++;
                cnt = 0;
            }
        }
        System.out.println("cnt : " + cnt);
    }

    public static void main(String[] args) {
        Main main = new Main();
//        main.firstGreedy();
//        main.secGreedy();
        main.thrGreedy();
    }
}
