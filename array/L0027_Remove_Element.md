# 27. Remove Element

## Problem

Given an integer array nums and an integer val, remove all occurrences of val in nums in-place. The order of the elements may be changed. Then return the number of elements in nums which are not equal to val.

Consider the number of elements in nums which are not equal to val be k, to get accepted, you need to do the following things:

Change the array nums such that the first k elements of nums contain the elements which are not equal to val. The remaining elements of nums are not important as well as the size of nums.
Return k.

Example 1:

Input: nums = [3,2,2,3], val = 3
Output: 2, nums = [2,2,_,_]
Explanation: Your function should return k = 2, with the first two elements of nums being 2.
It does not matter what you leave beyond the returned k (hence they are underscores).
Example 2:

Input: nums = [0,1,2,2,3,0,4,2], val = 2
Output: 5, nums = [0,1,4,0,3,_,_,_]
Explanation: Your function should return k = 5, with the first five elements of nums containing 0, 0, 1, 3, and 4.
Note that the five elements can be returned in any order.
It does not matter what you leave beyond the returned k (hence they are underscores).

## Solution

- Time Complexity: O(N), Space Complexity: O(1)

- Summary

1. Initialization: `slow` pointer to track the index where a non-target value should be written
2. Iteration: `fast` pointer to iterate through the array.
3. Conditional Check:

- If current value of `a[fast]` not equals to `val`, it is copied to the position of `slow`. Increase `slow`.

4. Completion: at the end of the loop, all the `val` are skipped, the array up to `slow` contains only the desired elements.

- Analysis

  1. Why not delete?

  - Array has continuous memory addresses, cannot simply remove
  - Substitute: rewrite the element

  2. How to rewrite in-place?

  - Example: `nums = [0,1,2,2,3,0,4,2], val = 2`
  - When we scan to index 2 and 3, we like to 'delete' values of 2 such that `nums = [0,1,_,_,3,0,4,2]`
  - We could do this by moving the latter elements forward. Therefore we need a pointer `slow` to mark down the position to be filled.
  - Meanwhile, we need another pointer `fast` to scan the array to find the next value that not equals to 2.

  3. What if no such element?

  - Example: `nums = [0,1,3,0,4], val = 2`
  - In this special case, we should leave the elements unchanged.
  - The pointer `slow` always equal to the pointer `fast`.
  - Therefore, we are in fact swapping the element with itself.
