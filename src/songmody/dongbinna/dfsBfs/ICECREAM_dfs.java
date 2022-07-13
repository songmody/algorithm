package songmody.dongbinna.dfsBfs;

import java.util.Scanner;

public class ICECREAM_dfs {
    static int N;
    static int M;
    static int[][] mat;

    // 방문여부를 체크하는 dfs함수
    static boolean dfs(int x, int y) {
        if (x < 0 || x >= N || y < 0 || y >= M){
            return false;
        }
        //위, 아래, 좌, 우를 방문해야함 -> 방문해서 값이 0이면 1로 바꿔주고 방문한 노드의 상, 하, 좌, 우를 또 방문함.. 주변에 0이 없을때까지
        if(mat[x][y] == 0) {
            mat[x][y] = 1;
            dfs(x - 1, y);
            dfs(x + 1, y);
            dfs(x, y - 1);
            dfs(x, y + 1);
            return true;
        }
            return false;
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
        int ice = 0;
        for (int i = 0; i < N; i++) {
            for (int k = 0; k < M; k++) {
                if(dfs(i, k)){
                    ice++;
                };
            }
        }
        System.out.println("ice : " + ice);


        for (int i = 0; i < N; i++) {
            for (int k = 0; k < M; k++) {
                System.out.print(mat[i][k]);
            }
            System.out.println();
        }

    }
}
