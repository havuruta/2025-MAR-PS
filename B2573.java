import java.io.BufferedReader;
import java.io.IOException;
import java.nio.Buffer;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class B2573 {
    static int[][] map;
    static int N,M,iceCnt;

    static class Point{
        int x;
        int y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1}; 

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        iceCnt = 0;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] != 0){
                    iceCnt++;
                }
            }
        }

        int year = 0;

        while(true){

            if (iceCnt == 0){
            System.out.println(0);
            break;
            }

            if (!isSingle()){
            System.out.println(year);
            break;
            }

            year++;
            int[][] temp = new int[N][M];
            for (int i = 0; i<N; i++){
                for (int j = 0; j<M; j++){
                    if (map[i][j] > 0){
                        temp[i][j] = map[i][j] - checkWater(i, j);
                        if (temp[i][j] <= 0){
                            temp[i][j] = 0;
                            iceCnt--;
                        }
                    }
                }
            }
            map = temp;
        }
    }

    static int checkWater(int x, int y){
        int cnt = 0;
        for (int i = 0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (isValid(nx, ny) && map[nx][ny] == 0){
                cnt++;
            }
        }
        return cnt;
    }

    static boolean isSingle(){
        Deque<Point> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][M];
        int cnt = 0;

        for (int i = 0; i<N; i++){
            for (int j = 0; j<M; j++){
                if (map[i][j] != 0){
                    q.add(new Point(i, j));
                    visited[i][j] = true;
                    cnt++;
                    break;
                }
            }
            if (!q.isEmpty()){
                break;
            }
        }


        while(!q.isEmpty()){
            Point p = q.poll();
            int x = p.x;
            int y = p.y;
            if (map[x][y] != 0){
                for (int i = 0; i<4; i++){
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    if (isValid(nx, ny) && map[nx][ny] != 0 && !visited[nx][ny]){
                        q.add(new Point(nx, ny));
                        cnt++;
                        visited[nx][ny] = true;
                    }
                }
            }
        }

        return cnt == iceCnt;
    }

    static boolean isValid(int x, int y){
        return x >= 0 && x < N && y >= 0 && y < M;
    }
}
