/*

Example 1:

Input: G = 5, P = 3, group = [2,2], profit = [2,3]
Output: 2
Explanation:
To make a profit of at least 3, the gang could either commit crimes 0 and 1, or just crime 1.
In total, there are 2 schemes.
Example 2:

Input: G = 10, P = 5, group = [2,3,5], profit = [6,7,8]
Output: 7
Explanation:
To make a profit of at least 5, the gang could commit any crimes, as long as they commit one.
There are 7 possible schemes: (0), (1), (2), (0,1), (0,2), (1,2), and (0,1,2).

dp[i][j] means i profit and j members,
dp[i+p][j+g] +=


P = 3, G = 5

  G 0 1 2 3 4 5
P
0   1 0 0 0 0 0
1   0 0 0 0 0 0
2   0 0 0 0 0 0
3   0 0 0 X 0 0

after g = 2, p = 2

  G 0 1 2 3 4 5
P
0   1 0 0 0 0 0
1   0 0 0 0 0 0
2   0 0 1 0 0 0
3   0 0 0 0 0 0

after g = 2, p =3

  G 0 1 2 3 4 5
P
0   1 0 0 0 0 0
1   0 0 0 0 0 0
2   0 0 1 0 0 0
3   0 0 1 0 1 0

Sum up the last row, the result is 2

  G 0 1 2 3 4 5 6 7 8 9 10
P
0   1 0 0 0 0 0 0 0 0 0  0
1   0 0 0 0 0 0 0 0 0 0  0
2   0 0 0 0 0 0 0 0 0 0  0
3   0 0 0 0 0 0 0 0 0 0  0
4   0 0 0 0 0 0 0 0 0 0  0
5   0 0 0 0 0 0 0 0 0 0  0

[1] after (g=2, p=6)

  G 0 1 2 3 4 5 6 7 8 9 10
P
0   1 0 0 0 0 0 0 0 0 0  0
1   0 0 0 0 0 0 0 0 0 0  0
2   0 0 0 0 0 0 0 0 0 0  0
3   0 0 0 0 0 0 0 0 0 0  0
4   0 0 0 0 0 0 0 0 0 0  0
5   0 0 1 0 0 0 0 0 0 0  0

[2] after (g=3, p=7)

  G 0 1 2 3 4 5 6 7 8 9 10
P
0   1 0 0 0 0 0 0 0 0 0  0
1   0 0 0 0 0 0 0 0 0 0  0
2   0 0 0 0 0 0 0 0 0 0  0
3   0 0 0 0 0 0 0 0 0 0  0
4   0 0 0 0 0 0 0 0 0 0  0
5   0 0 1 1 0 1 0 0 0 0  0

[3] after (g=5, p=8)

  G 0 1 2 3 4 5 6 7 8 9 10
P
0   1 0 0 0 0 0 0 0 0 0  0
1   0 0 0 0 0 0 0 0 0 0  0
2   0 0 0 0 0 0 0 0 0 0  0
3   0 0 0 0 0 0 0 0 0 0  0
4   0 0 0 0 0 0 0 0 0 0  0
5   0 0 1 1 0 2 0 1 1 1  0


Sum up the last row, the result is 7

*/
