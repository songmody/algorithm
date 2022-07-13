package songmody.dongbinna.dfsBfs;

import java.util.Scanner;


// #. 내일은 이거 안보고 혼자 꼭 해보기!!! 2번째 문제까지도!!!
public class DfsBfs {

    private static int N;
    private static int M;
    private static int[][] mat;

    public void firstDfsBfs() {
//        Scanner sc = new Scanner(System.in);
//        N = sc.nextInt();
//        M = sc.nextInt();
//        sc.nextLine();
////
//
//        mat = new int[N][M];
//        for (int i = 0; i < N; i++) {
//            String tmpLine = sc.nextLine();
//            for (int k = 0; k < M; k++) {
//                mat[i][k] = tmpLine.charAt(k) - '0';
//            }
//        }
//
//        int result = 0;
//        for (int i = 0; i < N; i++) {
//            for (int k = 0; k < M; k++) {
//                if (dfs(i, k)) {
//                    result += 1;
//                }
//            }
//        }
//        System.out.println(result + "*<---------***********");
//
//        boolean flag[][] = new boolean[N][M];
//
//
//
//
//        for(int i = 0; i< mat.length; i++){
//            int[] tmp = mat[i];
//            for(int k =0; k<tmp.length; k++){
//                if(tmp[k] == 0){
//
//                }
//
//                System.out.print(tmp[k]);
//            }
//            System.out.println();
//        }
//        System.out.println(mat.toString());


    }

    boolean dfss(int x, int y) {

//        if (x <= -1 || x >= N || y <= -1 || y >= M) {
//            return false;
//        }
//        if (mat[x][y] == 0) {
//            mat[x][y] = 1;
//
//            dfs(x - 1, y);
//            dfs(x, y - 1);
//            dfs(x + 1, y);
//            dfs(x, y + 1);
//            return true;
//        }

        return false;
    }


    static boolean dfs(int x, int y) {
        if (x < 0 || x >= N || y < 0 || y >= M) {
            return false;
        } else {
            if (mat[x][y] == 0) {
                // 놓친 부분 1. mat[x][y]값이 0일때 방문한 곳이므로 1로 변환!!
                mat[x][y] = 1;
                dfs(x + 1, y);
                dfs(x, y + 1);
                dfs(x - 1, y);
                dfs(x, y - 1);
                // 놓친 부분 2. true를 리턴해주는 것 실제값 0/1과 헷갈림.
                return true;
            }
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        sc.nextLine();
        mat = new int[N][M];

        for (int i = 0; i < N; i++) {
            String tmpLine = sc.nextLine();
            for (int k = 0; k < M; k++) {
                mat[i][k] = tmpLine.charAt(k) - '0';
            }
        }

        // #. main안에서 mat[][]각 원소들이 T/F인지 판단해야함.

        int icecream = 0;

        for (int i = 0; i < N; i++) {
            for (int k = 0; k < M; k++) {
                // 놓친 부분 3. true면 아이스크림이 하나 더 생기는 부분....
                // 방문처리가 된부분이면,,,, 아이스크림을 하나더 만듦.

                // 한번의 수행으로 모든 노드를 방문함.
                if (dfs(i, k)) {
                    icecream++;
                }
            }
        }
        System.out.println("icecream: " + icecream);
    }
}


