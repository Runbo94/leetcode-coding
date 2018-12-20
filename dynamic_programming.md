# Dynamic Programming

In a simple language, DP is to use more space to make your algorithm more efficiency. In other words, if there are many repetition in the algorithm, we can store the intermediate results in order to use it afterward.<br>
简而言之，以空间换取时间。

## Characteristics of DP Problem

1. Try to find the minimal or maximal solution of the problem;
2. Try to find the number of the available solutions of the problem;
3. Try to judge whether the solution is workable.

## Typical DP Problem

[_this part is referenced from the Hongkai's Blog_](http://kaicoding.blogspot.com/2016/07/dynamic-programming-summary-leetcode.html)

Please **code first**. And I will summarize these latter.

### Find the solution with optimal value

#### Index-based bottom-up method

- array
  - [53. maximum subarray](https://leetcode.com/problems/maximum-subarray/)
  - [152. Maximum Product Subarray](https://leetcode.com/problems/maximum-product-subarray/)
  - [32. Longest Valid Parentheses](https://leetcode.com/problems/longest-valid-parentheses/)
  - [300. Longest Increasing Subsequence](https://leetcode.com/problems/longest-increasing-subsequence/)
  - [368. Largest Divisible Subset](https://leetcode.com/problems/largest-divisible-subset/)
  - [139. Word Break](https://leetcode.com/problems/word-break/)
- matrix
  - [120. Triangle](https://leetcode.com/problems/triangle/)
  - [64. Minimum Path Sum](https://leetcode.com/problems/minimum-path-sum/)
  - [221. Maximal Square](https://leetcode.com/problems/maximal-square/)
  - [174. Dungeon Game](https://leetcode.com/problems/dungeon-game/)
  - [354. Russian Doll Envelopes](https://leetcode.com/problems/russian-doll-envelopes/)
  - [363. Max Sum of Rectangle No Larger Than K](https://leetcode.com/problems/max-sum-of-rectangle-no-larger-than-k/)
  - [32. Longest Valid Parentheses](https://leetcode.com/problems/longest-valid-parentheses/)

#### Index-based bottom-up method, with multiple states

These problems have extra constraints.<br>
