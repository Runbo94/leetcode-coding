# 双指针

[原文链接](https://www.baeldung.com/java-two-pointer-technique)

## 概述

在这篇文章中，我们将要讨论用双指针方法去解决关于数组等线性数据结构得问题。**这种方法能简单有效地优化算法**。

## 方法描述

在许多关于数组等线性结构的问题中，我们必须比较数组中每个元素和其他元素。
为了解决这个问题，我们通常会从第一个元素开始，在数组中循环多次。有时，我们甚至会根据问题的需要构造一个新的数组。
上述方法有可能给我们正确的结果。但不一定是最具有空间和时间效率的结果。
所以，在考虑问题时要考虑是否可以用双指针法来进行优化。
**在双指针方法中，指针指的是数组的下标。通过双指针，我们可以在每个循环中处理两个元素而不是单个元素。**
双指针方法的共同之处包括：

- 两个指针分别从首尾开始直至它们相遇
- 一个慢指针，一个快指针
  上面两个模式有助于减少时间和空间复杂度。
  现在我们举一些例子来帮助我们更好地理解双指针方法。

## Sum Exists in an Array

Problem: Given a sorted array of integers, we need to see if there are two numbers in it such that their sum is equal to a specific value.
For example, if our input array is [1, 1, 2, 3, 4, 6, 8, 9] and the target value is 11, then our method should return _true_. However, if the target value is 20, it should return _false_. Let's first see a naive solution:

```java
public boolean twoSumSlow(int[] input, int targetValue) {
    for (int i = 0; i < input.length; i++) {
        for (int j = i + 1; j < input.length; j++) {
            if (input[i] + input[j] = targetValue) return true;
        }
    }
    return false;
}
```

In the above solution, we looped over the input array twice to get all possible combinations. We checked the combination sum against the target value and returned _true_ if it matches. **The time complexity of this solution is O(n^2)**
