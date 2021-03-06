# The Cost of a Tree

一道 Mathworks 的 OA 题，做的时候点到了屏幕外面，直接跳出来了 gg，一千头草泥马奔过，下回做要全屏的 OA，可不敢再连第二屏幕了。难受~<br>
题目描述：
Given an array of integers, construct a tree. Each node tree has either two children or none, in which case it is a leaf node. A leaf node costs 0 to construct. The cost to build a parent node is the product of the maximum leaf values in its lef and right sub-trees. Partition the array to minimize the cost of building the entire tree.<br>
For example, there are n=3 elements in the array: arr=[4, 6, 2]. There are two possible choices to split the array: {4}, {6,2} and {4,6}, {2}. The array elements can not be reordered. Leaves are shown in green, and parent nodes are in blue.<br>

Working through the first choice, the left sub-tree is 4 and the right sub-tree is {6, 2}. The maxima are 4 and 6, so the root node costs 4\*6 = 24 to create. The left node is a leaf so it has a cost of 0. Now create leaves for {6, 2}, with their parent costing 6\*2=12to construct. The entire tree costs 24 + 12 = 36

If the same analysis is performed on the second choice, the root node costs max({4, 6}) * 2 = 12, and the node below that on the left costs 4*6=24. Again, the total cost is 36. If these were different, the minimum would be chosen. The answer is 36.<br>

例子：
9, 7, 8, 1, 3, 2 正确结果是 161<br>

|     | 9   | 7   | 8   | 1   | 3   | 2   |
| --- | --- | --- | --- | --- | --- | --- |
| 9   |
| 7   |
| 8   |
| 1   |
| 3   |
| 2   |

首先单元素数组无法运算，先假设是 0.
| | 9 | 7 | 8 | 1 | 3 | 2 |
| --- | --- | --- | --- | --- | --- | --- |
| 9 | 0 |
| 7 | | 0 |
| 8 | | | 0 |
| 1 | | | | 0 |
| 3 | | | | | 0 |
| 2 | | | | | | 0 |
如果数组是双元素，结果显然结果是两个元素相乘。
| | 9 | 7 | 8 | 1 | 3 | 2 |
| --- | --- | --- | --- | --- | --- | --- |
| 9 | 0 | 63 |
| 7 | | 0 | 56 |
| 8 | | | 0 | 8 |
| 1 | | | | 0 | 3 |
| 3 | | | | | 0 | 6|
| 2 | | | | | | 0 |
接下来是这道 dp 的核心关键，当元素数量大于 2，该怎么办，比如[9, 7, 8], 我们可以选 9,7 为一组，8 单独，[[9, 7], 8];或者 9 单独， 7,8 为一组，[9, [7, 8]]; 而且我们这时还需要记录每个区间的最大值是多少，比如[9, 7]的最大值是 9, 8 的最大值是 8，所以[[9, 7], 8]的 root 节点的值是 9\*8=72；
记录区间最大值的矩阵：
| | 9 | 7 | 8 | 1 | 3 | 2 |
| --- | --- | --- | --- | --- | --- | --- |
| 9 | 9 | 9 | 9 | 9 | 9 |9 |
| 7 | | 7 | 8 | 8 | 8 | 8 |
| 8 | | | 8 | 8 | 8 | 8 |
| 1 | | | | 1 | 3 | 3 |
| 3 | | | | | 3 | 3|
| 2 | | | | | | 2 |
再回到之前的[9, 7, 8], 当分组是[[9, 7], 8]时，[9, 7]结果的最小 cost 是 63， [8]结果的最小 cost 不存在，所以是 0
| | 9 | 7 | 8 | 1 | 3 | 2 |
| --- | --- | --- | --- | --- | --- | --- |
| 9 | 0 | **63** |
| 7 | | 0 | 56 |
| 8 | | | **0** | 8 |
| 1 | | | | 0 | 3 |
| 3 | | | | | 0 | 6|
| 2 | | | | | | 0 |
左子树的最大值取 9， 右子树取 8
| | 9 | 7 | 8 | 1 | 3 | 2 |
| --- | --- | --- | --- | --- | --- | --- |
| 9 | 9 | **9** | 9 | 9 | 9 |9 |
| 7 | | 7 | 8 | 8 | 8 | 8 |
| 8 | | | **8** | 8 | 8 | 8 |
| 1 | | | | 1 | 3 | 3 |
| 3 | | | | | 3 | 3|
| 2 | | | | | | 2 |
所以结果是 63 + 0 + 9*8 = 135；
当分组是[9, [7, 8]]时，[9]结果的是零，[7, 8]结果是 56
| | 9 | 7 | 8 | 1 | 3 | 2 |
| --- | --- | --- | --- | --- | --- | --- |
| 9 | **0** | 63 |
| 7 | | 0 | **56** |
| 8 | | | 0 | 8 |
| 1 | | | | 0 | 3 |
| 3 | | | | | 0 | 6|
| 2 | | | | | | 0 |
对应的左右子树最大值是
| | 9 | 7 | 8 | 1 | 3 | 2 |
| --- | --- | --- | --- | --- | --- | --- |
| 9 | **9** | 9 | 9 | 9 | 9 |9 |
| 7 | | 7 | **8** | 8 | 8 | 8 |
| 8 | | | 8 | 8 | 8 | 8 |
| 1 | | | | 1 | 3 | 3 |
| 3 | | | | | 3 | 3|
| 2 | | | | | | 2 |
结果是 0 + 56 + 9*8 = 128；所以最小是 128

|     | 9   | 7   | 8   | 1   | 3   | 2   |
| --- | --- | --- | --- | --- | --- | --- |
| 9   | 0   | 63  | 128 |
| 7   |     | 0   | 56  |
| 8   |     |     | 0   | 8   |
| 1   |     |     |     | 0   | 3   |
| 3   |     |     |     |     | 0   | 6   |
| 2   |     |     |     |     |     | 0   |

接下来直接表格演示

- [7, 8, 1]

  - [7, [8, 1]]
    | | 9 | 7 | 8 | 1 | 3 | 2 |
    | --- | --- | --- | --- | --- | --- | --- |
    | 9 | 0 | 63 | 128
    | 7 | | **0** | 56 |
    | 8 | | | 0 | **8** |
    | 1 | | | | 0 | 3 |
    | 3 | | | | | 0 | 6|
    | 2 | | | | | | 0 |

    |     | 9   | 7     | 8   | 1     | 3   | 2   |
    | --- | --- | ----- | --- | ----- | --- | --- |
    | 9   | 9   | 9     | 9   | 9     | 9   | 9   |
    | 7   |     | **7** | 8   | 8     | 8   | 8   |
    | 8   |     |       | 8   | **8** | 8   | 8   |
    | 1   |     |       |     | 1     | 3   | 3   |
    | 3   |     |       |     |       | 3   | 3   |
    | 2   |     |       |     |       |     | 2   |

    result: 0 + 8 + 7\*8 = 64

  - [[7, 8], 1]
    | | 9 | 7 | 8 | 1 | 3 | 2 |
    | --- | --- | --- | --- | --- | --- | --- |
    | 9 | 0 | 63 | 128
    | 7 | | 0 | **56** |
    | 8 | | | 0 | 8 |
    | 1 | | | | **0** | 3 |
    | 3 | | | | | 0 | 6|
    | 2 | | | | | | 0 |

    |     | 9   | 7   | 8     | 1     | 3   | 2   |
    | --- | --- | --- | ----- | ----- | --- | --- |
    | 9   | 9   | 9   | 9     | 9     | 9   | 9   |
    | 7   |     | 7   | **8** | 8     | 8   | 8   |
    | 8   |     |     | 8     | 8     | 8   | 8   |
    | 1   |     |     |       | **1** | 3   | 3   |
    | 3   |     |     |       |       | 3   | 3   |
    | 2   |     |     |       |       |     | 2   |

    result: 56 + 0 + 8 = 64

  - result
    | | 9 | 7 | 8 | 1 | 3 | 2 |
    | --- | --- | --- | --- | --- | --- | --- |
    | 9 | 0 | 63 | 128
    | 7 | | 0 | 56 | 64
    | 8 | | | 0 | 8 |
    | 1 | | | | 0 | 3 |
    | 3 | | | | | 0 | 6|
    | 2 | | | | | | 0 |

省略后面的结果， 直接算[9, 7, 8, 1]

- [9, [7, 8, 1]]
  | | 9 | 7 | 8 | 1 | 3 | 2 |
  | --- | --- | --- | --- | --- | --- | --- |
  | 9 | **0** | 63 | 128
  | 7 | | 0 | 56 | **64**
  | 8 | | | 0 | 8 |
  | 1 | | | | 0 | 3 |
  | 3 | | | | | 0 | 6|
  | 2 | | | | | | 0 |

  |     | 9     | 7   | 8   | 1     | 3   | 2   |
  | --- | ----- | --- | --- | ----- | --- | --- |
  | 9   | **9** | 9   | 9   | 9     | 9   | 9   |
  | 7   |       | 7   | 8   | **8** | 8   | 8   |
  | 8   |       |     | 8   | 8     | 8   | 8   |
  | 1   |       |     |     | 1     | 3   | 3   |
  | 3   |       |     |     |       | 3   | 3   |
  | 2   |       |     |     |       |     | 2   |

  result: 0 + 64 + 9\*8 = 136

- [[9, 7], [8, 1]]
  | | 9 | 7 | 8 | 1 | 3 | 2 |
  | --- | --- | --- | --- | --- | --- | --- |
  | 9 | 0 | **63** | 128
  | 7 | | 0 | 56 | 64
  | 8 | | | 0 | **8** |
  | 1 | | | | 0 | 3 |
  | 3 | | | | | 0 | 6|
  | 2 | | | | | | 0 |

  |     | 9   | 7     | 8   | 1     | 3   | 2   |
  | --- | --- | ----- | --- | ----- | --- | --- |
  | 9   | 9   | **9** | 9   | 9     | 9   | 9   |
  | 7   |     | 7     | 8   | 8     | 8   | 8   |
  | 8   |     |       | 8   | **8** | 8   | 8   |
  | 1   |     |       |     | 1     | 3   | 3   |
  | 3   |     |       |     |       | 3   | 3   |
  | 2   |     |       |     |       |     | 2   |

  result: 63 + 8 + 9\*8 = 143

- [[9, 7, 8], [1]]
  | | 9 | 7 | 8 | 1 | 3 | 2 |
  | --- | --- | --- | --- | --- | --- | --- |
  | 9 | 0 | 63 | **128**
  | 7 | | 0 | 56 | 64
  | 8 | | | 0 | 8 |
  | 1 | | | | **0** | 3 |
  | 3 | | | | | 0 | 6|
  | 2 | | | | | | 0 |

  |     | 9   | 7   | 8     | 1     | 3   | 2   |
  | --- | --- | --- | ----- | ----- | --- | --- |
  | 9   | 9   | 9   | **9** | 9     | 9   | 9   |
  | 7   |     | 7   | 8     | 8     | 8   | 8   |
  | 8   |     |     | 8     | 8     | 8   | 8   |
  | 1   |     |     |       | **1** | 3   | 3   |
  | 3   |     |     |       |       | 3   | 3   |
  | 2   |     |     |       |       |     | 2   |

  result: 128 + 0 + 9\*1 = 137

- 最后最小是 136
  | | 9 | 7 | 8 | 1 | 3 | 2 |
  | --- | --- | --- | --- | --- | --- | --- |
  | 9 | 0 | 63 | 128 | 136
  | 7 | | 0 | 56 | 64
  | 8 | | | 0 | 8 |
  | 1 | | | | 0 | 3 |
  | 3 | | | | | 0 | 6|
  | 2 | | | | | | 0 |
