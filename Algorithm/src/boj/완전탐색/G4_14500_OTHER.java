package boj.완전탐색;

import java.io.*;
import java.util.*;

public class G4_14500_OTHER {

    static int N, M, answer;
    static int[][] board;

    static int[][] shapes = {
        // O
        {0, 1, 3, 4},
        {1, 2, 4, 5},
        {3, 4, 6, 7},
        {4, 5, 7, 8},

        // T
        {0, 1, 2, 4},
        {3, 4, 5, 7},
        {1, 3, 4, 5},
        {4, 6, 7, 8},
        {0, 3, 4, 6},
        {1, 4, 5, 7},
        {1, 3, 4, 7},
        {2, 4, 5, 8},

        // S, Z
        {1, 2, 3, 4},
        {4, 5, 6, 7},
        {0, 1, 4, 5},
        {3, 4, 7, 8},
        {0, 3, 4, 7},
        {1, 4, 5, 8},
        {1, 3, 4, 6},
        {2, 4, 5, 7},

        // L, J
        {0, 3, 6, 7},
        {1, 4, 7, 8},
        {1, 4, 6, 7},
        {2, 5, 7, 8},
        {0, 1, 3, 6},
        {1, 2, 4, 7},
        {0, 1, 4, 7},
        {1, 2, 5, 8},
        {0, 1, 2, 3},
        {3, 4, 5, 6},
        {0, 1, 2, 5},
        {3, 4, 5, 8},
        {0, 3, 4, 5},
        {3, 6, 7, 8},
        {2, 3, 4, 5},
        {5, 6, 7, 8}
    };

    static void check3x3(int sx, int sy) {
        for (int[] shape : shapes) {
            int sum = 0;

            for (int idx : shape) {
                int dx = idx / 3;
                int dy = idx % 3;
                sum += board[sx + dx][sy + dy];
            }

            answer = Math.max(answer, sum);
        }
    }

    static void checkLine() {
        // 가로 일자
        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= M - 4; j++) {
                int sum = 0;
                for (int k = 0; k < 4; k++) {
                    sum += board[i][j + k];
                }
                answer = Math.max(answer, sum);
            }
        }

        // 세로 일자
        for (int i = 0; i <= N - 4; i++) {
            for (int j = 0; j < M; j++) {
                int sum = 0;
                for (int k = 0; k < 4; k++) {
                    sum += board[i + k][j];
                }
                answer = Math.max(answer, sum);
            }
        }
    }

    static void solution() {
        // 3x3 안에 들어가는 모든 테트로미노 검사
        for (int i = 0; i <= N - 3; i++) {
            for (int j = 0; j <= M - 3; j++) {
                check3x3(i, j);
            }
        }

        // 일자 4칸 테트로미노 따로 처리
        checkLine();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        answer = 0;
        solution();

        System.out.println(answer);
    }
}
