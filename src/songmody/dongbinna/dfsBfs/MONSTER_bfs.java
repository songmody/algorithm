package songmody.dongbinna.dfsBfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Node {
    private int x;
    private int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }
}
// #. 내일 안보고 다시 해보기!!!! 2022-07-14
public class MONSTER_bfs {
    static int N;
    static int M;
    static int[][] mat;

    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, -1, 1};

    public static int bfs(int x, int y) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x, y));

        while (!q.isEmpty()) {
            Node node = q.poll();
            x = node.getX();
            y = node.getY();

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if(mat[nx][ny] == 0) continue;
                if(mat[nx][ny] == 1){
                    mat[nx][ny] = mat[x][y] +1;
                    q.offer(new Node(nx,ny));
                }

            }
        }
        return mat[N-1][M-1];
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

        System.out.println("을매나 움직였어!!!!--> " + bfs(0, 0));
    }
}
