# 0/1 Knapsack Problem Dynamic Programming

## Example

Total weight: 7 <br>
Items: <br>
|wt|val|
|--|--|
|1 |1 |
|3 |4 |
|4 |5 |
|5 |7 |

Create a DP table, and fill in the form.

1.

| col: knapsack weight / row: items | 0   | 1   | 2   | 3   | 4   | 5   | 6   | 7   |
| --------------------------------- | --- | --- | --- | --- | --- | --- | --- | --- |
| 1 (val: 1)                        | 0   | 1   | 1   | 1   | 1   | 1   | 1   | 1   |
| 3 (val: 4)                        | 0   | 1   | 1   |
| 4 (val: 5)                        |
| 5 (val: 7)                        |

2. if 3(4) is not put in the knapsack, the value is 1; if 3(4) is put in the bag, and the remaining space is 0, therefore, the total value is 4 + 0.

| col: knapsack weight / row: items | 0   | 1   | 2   | 3     | 4   | 5   | 6   | 7   |
| --------------------------------- | --- | --- | --- | ----- | --- | --- | --- | --- |
| 1 (val: 1)                        | 0   | 1   | 1   | 1     | 1   | 1   | 1   | 1   |
| 3 (val: 4)                        | 0   | 1   | 1   | **4** |
| 4 (val: 5)                        |
| 5 (val: 7)                        |

3.

| col: knapsack weight / row: items | 0   | 1   | 2   | 3   | 4     | 5   | 6   | 7   |
| --------------------------------- | --- | --- | --- | --- | ----- | --- | --- | --- |
| 1 (val: 1)                        | 0   | 1   | 1   | 1   | 1     | 1   | 1   | 1   |
| 3 (val: 4)                        | 0   | 1   | 1   | 4   | **5** |
| 4 (val: 5)                        |
| 5 (val: 7)                        |

4.

| col: knapsack weight / row: items | 0   | 1   | 2   | 3   | 4   | 5   | 6   | 7   |
| --------------------------------- | --- | --- | --- | --- | --- | --- | --- | --- |
| 1 (val: 1)                        | 0   | 1   | 1   | 1   | 1   | 1   | 1   | 1   |
| 3 (val: 4)                        | 0   | 1   | 1   | 4   | 5   | 5   |
| 4 (val: 5)                        |
| 5 (val: 7)                        |

5.

| col: knapsack weight / row: items | 0   | 1   | 2   | 3   | 4   | 5   | 6   | 7   |
| --------------------------------- | --- | --- | --- | --- | --- | --- | --- | --- |
| 1 (val: 1)                        | 0   | 1   | 1   | 1   | 1   | 1   | 1   | 1   |
| 3 (val: 4)                        | 0   | 1   | 1   | 4   | 5   | 5   | 5   |
| 4 (val: 5)                        |
| 5 (val: 7)                        |

5.

| col: knapsack weight / row: items | 0   | 1   | 2   | 3   | 4   | 5   | 6   | 7   |
| --------------------------------- | --- | --- | --- | --- | --- | --- | --- | --- |
| 1 (val: 1)                        | 0   | 1   | 1   | 1   | 1   | 1   | 1   | 1   |
| 3 (val: 4)                        | 0   | 1   | 1   | 4   | 5   | 5   | 5   | 5   |
| 4 (val: 5)                        |
| 5 (val: 7)                        |

6. The intermediate process is omitted.

| col: knapsack weight / row: items | 0   | 1   | 2   | 3   | 4   | 5   | 6   | 7   |
| --------------------------------- | --- | --- | --- | --- | --- | --- | --- | --- |
| 1 (val: 1)                        | 0   | 1   | 1   | 1   | 1   | 1   | 1   | 1   |
| 3 (val: 4)                        | 0   | 1   | 1   | 4   | 5   | 5   | 5   | 5   |
| 4 (val: 5)                        | 0   | 1   | 1   | 4   | 5   | 6   | 6   | 9   |
| 5 (val: 7)                        | 0   | 1   | 1   | 4   | 5   | 7   | 8   | 9   |

7. Conclusion: the dynamic programming formula is: <br>
   If the item weight(row) < the bag capacity(col): dp[i][j] = dp[i-1][j];<br>
   If the item weight(row) >= the bag capacity(col): dp[i][j] = max(dp[i-1][j], value[i] + dp[i-1]j - weight[i]]);

## Related Leetcode Problems

- [518. Coin Change 2](https://leetcode.com/problems/coin-change-2/)

  - example:
    - Input: amount = 5, coins = [1, 2, 5]
    - Output: 4
    - Explanation: there are four ways to make up the amount:<br>
      5=5<br>
      5=2+2+1<br>
      5=2+1+1+1<br>
      5=1+1+1+1+1<br>
  - dp table:

    |     | 0   | 1   | 2   | 3   | 4   | 5   |
    | --- | --- | --- | --- | --- | --- | --- |
    | 0   | 0   | 0   | 0   | 0   | 0   | 0   |
    | 1   | 1   | 1   | 1   | 1   | 1   | 1   |
    | 2   | 1   | 1   | 2   | 2   | 3   | 3   |
    | 5   | 1   | 1   | 2   | 2   | 3   | 4   |

    |     | 0   | 1   | 2   | 3   |
    | --- | --- | --- | --- | --- |
    | 0   | 0   | 0   | 0   | 0   |
    | 2   | 1   | 0   | 1   | 0   |
