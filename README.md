# 🧩 Algorithm Study

> 백준(BOJ) & SWEA 알고리즘 문제풀이 저장소

![Java](https://img.shields.io/badge/Java-ED8B00?style=flat-square&logo=openjdk&logoColor=white)
![BOJ](https://img.shields.io/badge/Baekjoon-0055FF?style=flat-square&logo=databricks&logoColor=white)
![SWEA](https://img.shields.io/badge/SWEA-1428A0?style=flat-square&logoColor=white)

---

## 📁 Directory Structure

```
📦 cote
 ┣ 📂 boj
 ┃ ┣ 📂 DFS_BFS
 ┃ ┃ ┣ 📂 _01_BFS
 ┃ ┃ ┗ 📂 백트레킹
 ┃ ┣ 📂 DP
 ┃ ┣ 📂 MST
 ┃ ┣ 📂 다익스트라
 ┃ ┣ 📂 그리디
 ┃ ┣ 📂 누적합
 ┃ ┣ 📂 문자열_정규표현식
 ┃ ┣ 📂 수학
 ┃ ┣ 📂 시뮬
 ┃ ┣ 📂 완전탐색
 ┃ ┣ 📂 위상정렬
 ┃ ┣ 📂 조합
 ┃ ┣ 📂 집합과맵
 ┃ ┣ 📂 큐
 ┃ ┣ 📂 투포인터
 ┃ ┗ 📂 _FAILED
 ┗ 📂 swea
```

---

## 📌 File Naming Convention

```
{난이도}_{문제번호}.java
```

| 접두사 | 의미 |
|--------|------|
| `P` | Platinum |
| `G1` ~ `G5` | Gold |
| `S1` ~ `S5` | Silver |
| `B1` ~ `B5` | Bronze |
| `D5`, `D4`, `D3` | SWEA Difficulty |
| `A_` | SWEA 대회/기타 |
| `_FAIL` | 미해결 문제 |

---

## 📊 Problem List

### 🔵 BOJ (백준)

#### DFS / BFS

| 난이도 | 문제번호 | 풀이 |
|--------|----------|------|
| Gold 3 | [14442 - 벽 부수고 이동하기 2](https://www.acmicpc.net/problem/14442) | [풀이](https://github.com/sienhs/SSAFY_Algorithm/blob/main/Algorithm/src/boj/DFS_BFS/G3_14442.java) |
| Gold 3 | [2206 - 벽 부수고 이동하기](https://www.acmicpc.net/problem/2206) | [풀이](https://github.com/sienhs/SSAFY_Algorithm/blob/main/Algorithm/src/boj/DFS_BFS/G3_2206.java) |
| Gold 3 | [4179 - 불!](https://www.acmicpc.net/problem/4179) | [풀이](https://github.com/sienhs/SSAFY_Algorithm/blob/main/Algorithm/src/boj/DFS_BFS/G3_4179.java) |
| Gold 4 | [14502 - 연구소](https://www.acmicpc.net/problem/14502) | [풀이](https://github.com/sienhs/SSAFY_Algorithm/blob/main/Algorithm/src/boj/DFS_BFS/G4_14502.java) |
| Gold 4 | [16234 - 인구 이동](https://www.acmicpc.net/problem/16234) | [풀이](https://github.com/sienhs/SSAFY_Algorithm/blob/main/Algorithm/src/boj/DFS_BFS/G4_16234.java) |
| Gold 4 | [2665 - 미로만들기](https://www.acmicpc.net/problem/2665) | [풀이](https://github.com/sienhs/SSAFY_Algorithm/blob/main/Algorithm/src/boj/DFS_BFS/_01_BFS/G4_2665.java) |
| Gold 5 | [16928 - 뱀과 사다리 게임](https://www.acmicpc.net/problem/16928) | [풀이](https://github.com/sienhs/SSAFY_Algorithm/blob/main/Algorithm/src/boj/DFS_BFS/G5_16928.java) |
| Gold 5 | [7569 - 토마토](https://www.acmicpc.net/problem/7569) | [풀이](https://github.com/sienhs/SSAFY_Algorithm/blob/main/Algorithm/src/boj/DFS_BFS/G5_7569.java) |
| Gold 5 | [7576 - 토마토](https://www.acmicpc.net/problem/7576) | [풀이](https://github.com/sienhs/SSAFY_Algorithm/blob/main/Algorithm/src/boj/DFS_BFS/G5_7576.java) |
| Silver 1 | [1697 - 숨바꼭질](https://www.acmicpc.net/problem/1697) | [풀이](https://github.com/sienhs/SSAFY_Algorithm/blob/main/Algorithm/src/boj/DFS_BFS/S1_1697.java) |
| Silver 1 | [2178 - 미로 탐색](https://www.acmicpc.net/problem/2178) | [풀이](https://github.com/sienhs/SSAFY_Algorithm/blob/main/Algorithm/src/boj/DFS_BFS/S1_2178.java) |
| Silver 1 | [2667 - 단지번호붙이기](https://www.acmicpc.net/problem/2667) | [풀이](https://github.com/sienhs/SSAFY_Algorithm/blob/main/Algorithm/src/boj/DFS_BFS/S1_2667.java) |
| Silver 3 | [2606 - 바이러스](https://www.acmicpc.net/problem/2606) | [풀이](https://github.com/sienhs/SSAFY_Algorithm/blob/main/Algorithm/src/boj/DFS_BFS/S3_2606.java) |
| Silver 5 | [1260 - DFS와 BFS](https://www.acmicpc.net/problem/1260) | [풀이](https://github.com/sienhs/SSAFY_Algorithm/blob/main/Algorithm/src/boj/DFS_BFS/S5_1260.java) |

#### 01 BFS

| 난이도 | 문제번호 | 풀이 |
|--------|----------|------|
| Gold 4 | [1261 - 알고스팟](https://www.acmicpc.net/problem/1261) | [풀이](https://github.com/sienhs/SSAFY_Algorithm/blob/main/Algorithm/src/boj/DFS_BFS/_01_BFS/G4_1261.java) |
| Gold 4 | [2665 - 미로만들기](https://www.acmicpc.net/problem/2665) | [풀이](https://github.com/sienhs/SSAFY_Algorithm/blob/main/Algorithm/src/boj/DFS_BFS/_01_BFS/G4_2665.java) |

#### 백트래킹

| 난이도 | 문제번호 | 풀이 |
|--------|----------|------|
| Platinum 5 | [1799 - 비숍](https://www.acmicpc.net/problem/1799) | [풀이](https://github.com/sienhs/SSAFY_Algorithm/blob/main/Algorithm/src/boj/DFS_BFS/백트레킹/P5_1799.java) |
| Gold 5 | [15686 - 치킨 배달](https://www.acmicpc.net/problem/15686) | [풀이](https://github.com/sienhs/SSAFY_Algorithm/blob/main/Algorithm/src/boj/DFS_BFS/백트레킹/G5_15686.java) |
| Silver 2 | [10971 - 외판원 순회 2](https://www.acmicpc.net/problem/10971) | [풀이](https://github.com/sienhs/SSAFY_Algorithm/blob/main/Algorithm/src/boj/DFS_BFS/백트레킹/S2_10971.java) |

#### DP

| 난이도 | 문제번호 | 풀이 |
|--------|----------|------|
| Silver 2 | [11060 - 점프 점프](https://www.acmicpc.net/problem/11060) | [풀이](https://github.com/sienhs/SSAFY_Algorithm/blob/main/Algorithm/src/boj/DP/S2_11060.java) |
| Silver 4 | [1463 - 1로 만들기](https://www.acmicpc.net/problem/1463) | [풀이](https://github.com/sienhs/SSAFY_Algorithm/blob/main/Algorithm/src/boj/DP/S4_1463.java) |

#### MST (최소 신장 트리)

| 난이도 | 문제번호 | 풀이 |
|--------|----------|------|
| Gold 4 | [1197 - 최소 스패닝 트리](https://www.acmicpc.net/problem/1197) | [풀이](https://github.com/sienhs/SSAFY_Algorithm/blob/main/Algorithm/src/boj/MST/G4_1197_FAIL.java) |

#### 그리디

| 난이도 | 문제번호 | 풀이 |
|--------|----------|------|
| Gold 5 | [1931 - 회의실 배정](https://www.acmicpc.net/problem/1931) | [풀이](https://github.com/sienhs/SSAFY_Algorithm/blob/main/Algorithm/src/boj/그리디/G5_1931.java) |
| Silver 4 | [2839 - 설탕 배달](https://www.acmicpc.net/problem/2839) | [풀이](https://github.com/sienhs/SSAFY_Algorithm/blob/main/Algorithm/src/boj/그리디/S4_2839.java) |
| Silver 5 | [1343 - 폴리오미노](https://www.acmicpc.net/problem/1343) | [풀이](https://github.com/sienhs/SSAFY_Algorithm/blob/main/Algorithm/src/boj/그리디/S5_1343.java) |

#### 누적합

| 난이도 | 문제번호 | 풀이 |
|--------|----------|------|
| Silver 1 | [11660 - 구간 합 구하기 5](https://www.acmicpc.net/problem/11660) | [풀이](https://github.com/sienhs/SSAFY_Algorithm/blob/main/Algorithm/src/boj/누적합/S1_11660.java) |
| Silver 3 | [11659 - 구간 합 구하기 4](https://www.acmicpc.net/problem/11659) | [풀이](https://github.com/sienhs/SSAFY_Algorithm/blob/main/Algorithm/src/boj/누적합/S3_11659.java) |

#### 시뮬레이션

| 난이도 | 문제번호 | 풀이 |
|--------|----------|------|
| Gold 4 | [3190 - 뱀](https://www.acmicpc.net/problem/3190) | [풀이](https://github.com/sienhs/SSAFY_Algorithm/blob/main/Algorithm/src/boj/시뮬/G4_3190.java) |
| Gold 5 | [14891 - 톱니바퀴](https://www.acmicpc.net/problem/14891) | [풀이](https://github.com/sienhs/SSAFY_Algorithm/blob/main/Algorithm/src/boj/시뮬/G5_14891.java) |

#### 완전탐색

| 난이도 | 문제번호 | 풀이 |
|--------|----------|------|
| Gold 1 | [12100 - 2048(Easy)](https://www.acmicpc.net/problem/12100) | [풀이](https://github.com/sienhs/SSAFY_Algorithm/blob/main/Algorithm/src/boj/완전탐색/G1_12100.java) |
| Gold 4 | [14500 - 테트로미노](https://www.acmicpc.net/problem/14500) | [풀이](https://github.com/sienhs/SSAFY_Algorithm/blob/main/Algorithm/src/boj/완전탐색/G4_14500_OTHER.java) |

#### 위상정렬

| 난이도 | 문제번호 | 풀이 |
|--------|----------|------|
| Gold 2 | [1766 - 문제집](https://www.acmicpc.net/problem/1766) | [풀이](https://github.com/sienhs/SSAFY_Algorithm/blob/main/Algorithm/src/boj/위상정렬/G2_1766.java) |
| Gold 3 | [1005 - ACM Craft](https://www.acmicpc.net/problem/1005) | [풀이](https://github.com/sienhs/SSAFY_Algorithm/blob/main/Algorithm/src/boj/위상정렬/G3_1005.java) |
| Gold 3 | [2252 - 줄 세우기](https://www.acmicpc.net/problem/2252) | [풀이](https://github.com/sienhs/SSAFY_Algorithm/blob/main/Algorithm/src/boj/위상정렬/G3_2252.java) |

#### 조합

| 난이도 | 문제번호 | 풀이 |
|--------|----------|------|
| Gold 3 | [1941 - 소문난 칠공주](https://www.acmicpc.net/problem/1941) | [풀이](https://github.com/sienhs/SSAFY_Algorithm/blob/main/Algorithm/src/boj/조합/G3_1941.java) |

#### 투포인터

| 난이도 | 문제번호 | 풀이 |
|--------|----------|------|
| Gold 5 | [2470 - 두 용액](https://www.acmicpc.net/problem/2470) | [풀이](https://github.com/sienhs/SSAFY_Algorithm/blob/main/Algorithm/src/boj/투포인터/G5_2470.java) |
| Silver 4 | [1940 - 주몽](https://www.acmicpc.net/problem/1940) | [풀이](https://github.com/sienhs/SSAFY_Algorithm/blob/main/Algorithm/src/boj/투포인터/S4_1940.java) |
| Silver 5 | [11728 - 배열 합치기](https://www.acmicpc.net/problem/11728) | [풀이](https://github.com/sienhs/SSAFY_Algorithm/blob/main/Algorithm/src/boj/투포인터/S5_11728.java) |

#### 집합과 맵

| 난이도 | 문제번호 | 풀이 |
|--------|----------|------|
| Silver 4 | [1620 - 나는야 포켓몬 마스터 이다솜](https://www.acmicpc.net/problem/1620) | [풀이](https://github.com/sienhs/SSAFY_Algorithm/blob/main/Algorithm/src/boj/집합과맵/S4_1620.java) |
| Silver 5 | [10815 - 숫자 카드](https://www.acmicpc.net/problem/10815) | [풀이](https://github.com/sienhs/SSAFY_Algorithm/blob/main/Algorithm/src/boj/집합과맵/S5_10815.java) |
| Silver 5 | [11723 - 집합](https://www.acmicpc.net/problem/11723) | [풀이](https://github.com/sienhs/SSAFY_Algorithm/blob/main/Algorithm/src/boj/집합과맵/S5_11723.java) |

#### 다익스트라

| 난이도 | 문제번호 | 풀이 |
|--------|----------|------|
| Gold 3 | [1238 - 파티](https://www.acmicpc.net/problem/1238) | [풀이](https://github.com/sienhs/SSAFY_Algorithm/blob/main/Algorithm/src/boj/다익스트라/G3_1238.java) |
| Gold 3 | [1939 - 중량제한](https://www.acmicpc.net/problem/1939) | [풀이](https://github.com/sienhs/SSAFY_Algorithm/blob/main/Algorithm/src/boj/다익스트라/G3_1939.java) |
| Gold 4 | [1504 - 특정한 최단 경로](https://www.acmicpc.net/problem/1504) | [풀이](https://github.com/sienhs/SSAFY_Algorithm/blob/main/Algorithm/src/boj/다익스트라/G4_1504.java) |
| Gold 4 | [1753 - 최단경로](https://www.acmicpc.net/problem/1753) | [풀이](https://github.com/sienhs/SSAFY_Algorithm/blob/main/Algorithm/src/boj/다익스트라/G4_1753.java) |
| Gold 4 | [22865 - 가장 먼 곳](https://www.acmicpc.net/problem/22865) | [풀이](https://github.com/sienhs/SSAFY_Algorithm/blob/main/Algorithm/src/boj/다익스트라/G4_22865.java) |
| Gold 5 | [1916 - 최소비용 구하기](https://www.acmicpc.net/problem/1916) | [풀이](https://github.com/sienhs/SSAFY_Algorithm/blob/main/Algorithm/src/boj/다익스트라/G5_1916.java) |
| Gold 5 | [5972 - 택배 배송](https://www.acmicpc.net/problem/5972) | [풀이](https://github.com/sienhs/SSAFY_Algorithm/blob/main/Algorithm/src/boj/다익스트라/G5_5972.java) |

#### 기타

| 난이도 | 문제번호 | 풀이 |
|--------|----------|------|
| Gold 5 | [13549 - 숨바꼭질 3](https://www.acmicpc.net/problem/13549) | [풀이](https://github.com/sienhs/SSAFY_Algorithm/blob/main/Algorithm/src/boj/G5_13549.java) |
| Silver 3 | [9996 - 한국이 그리울 땐 서버에 접속하지](https://www.acmicpc.net/problem/9996) | [풀이](https://github.com/sienhs/SSAFY_Algorithm/blob/main/Algorithm/src/boj/문자열_정규표현식/S3_9996.java) |
| Silver 4 | [1158 - 요세푸스 문제](https://www.acmicpc.net/problem/1158) | [풀이](https://github.com/sienhs/SSAFY_Algorithm/blob/main/Algorithm/src/boj/큐/S4_1158.java) |
| Bronze 5 | [27433 - 팩토리얼 2](https://www.acmicpc.net/problem/27433) | [풀이](https://github.com/sienhs/SSAFY_Algorithm/blob/main/Algorithm/src/boj/수학/B5_27433.java) |

---

### 🟠 SWEA

| 난이도 | 문제번호 | 풀이 |
|--------|----------|------|
| D5 | [1247 - 최적 경로](https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV15OZ4qAPICFAYD) | [풀이](https://github.com/sienhs/SSAFY_Algorithm/blob/main/Algorithm/src/swea/D5_1247.java) |
| D5 | [7793 - 불](https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWngfZVa9XwDFAYE) | [풀이](https://github.com/sienhs/SSAFY_Algorithm/blob/main/Algorithm/src/swea/D5_7793.java) |
| D4 | [1226 - 미로1](https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14uWl6AF01BQYz) | [풀이](https://github.com/sienhs/SSAFY_Algorithm/blob/main/Algorithm/src/swea/D4_1226.java) |
| D4 | [1227 - 미로2](https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14uV9aABUBFAYz) | [풀이](https://github.com/sienhs/SSAFY_Algorithm/blob/main/Algorithm/src/swea/D4_1227.java) |
| D4 | [1251 - 하나로](https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV15StKqAQkCFAYD) | [풀이](https://github.com/sienhs/SSAFY_Algorithm/blob/main/Algorithm/src/swea/D4_1251.java) |
| D4 | [1486 - 장훈이의 높은 선반](https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV2b7Yf6ABcBBASw) | [풀이](https://github.com/sienhs/SSAFY_Algorithm/blob/main/Algorithm/src/swea/D4_1486.java) |
| D4 | [1868 - 파핑파핑 지뢰찾기](https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV4_Kq4qzAkDFAUx) | [풀이](https://github.com/sienhs/SSAFY_Algorithm/blob/main/Algorithm/src/swea/D4_1868.java) |
| D3 | [5215 - 햄버거 다이어트](https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWT-lPB6dHUDFAVT) | [풀이](https://github.com/sienhs/SSAFY_Algorithm/blob/main/Algorithm/src/swea/D3_5215.java) |
| D3 | [6808 - 규영이와 인영이의 카드게임](https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWgv9va6HnkDFAW0) | [풀이](https://github.com/sienhs/SSAFY_Algorithm/blob/main/Algorithm/src/swea/D3_6808.java) |
| D3 | [9229 - 한빈이와 Spot Mart](https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AW8Wj7cqbY0DFAXN) | [풀이](https://github.com/sienhs/SSAFY_Algorithm/blob/main/Algorithm/src/swea/D3_9229.java) |
| 기타 | [1767 - 프로세서 연결하기](https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV4suNtaXFEDFAUf) | [풀이](https://github.com/sienhs/SSAFY_Algorithm/blob/main/Algorithm/src/swea/_1767.java) |
| 대회 | [5648 - 원자 소멸 시뮬레이션](https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWXRFInKex8DFAUo) | [풀이](https://github.com/sienhs/SSAFY_Algorithm/blob/main/Algorithm/src/swea/A_5648.java) |
| 기타 | [2115 - 벌꿀채취](https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5V4A46AdIDFAWu) | [풀이](https://github.com/sienhs/SSAFY_Algorithm/blob/main/Algorithm/src/swea/DN_2115_T.java) |
| 기타 | [5656 - 벽돌 깨기](https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWXRQm6qfL0DFAUo) | [풀이](https://github.com/sienhs/SSAFY_Algorithm/blob/main/Algorithm/src/swea/DN_5656.java) |

---

## 📈 Stats

| 플랫폼 | 풀이 수 |
|--------|---------|
| BOJ    | 52문제  |
| SWEA   | 14문제  |
| **합계** | **66문제** |
