# 1. Two Sum

## Problem

Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target. You may assume that each input would have exactly one solution, and you may not use the same element twice. You can return the answer in any order.

Example 1:
Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

Example 2:
Input: nums = [3,2,4], target = 6
Output: [1,2]

Example 3:
Input: nums = [3,3], target = 6
Output: [0,1]

Follow up: Can you come up with an algorithm that is less than O(n^2) time complexity?

## Solution

1. Brute force Approach

- Time complexity: O(n^2)
- Look up every pair of numbers in the array to see whether they add up to the target.

2. HashMap for Faster Lookup

- Time complexity: `O(N)`, Space complexity: `O(N)`

- Summary:

  1. Initialization: create a hash map
  2. Iteration: iterate through each number in the array (only once)
  3. Complement check: for each, compute the complement
  4. Hashmap lookup: check if the complement exists in the map.

  - If found, a pair exists, return their indices.
  - If not found, put the current number and index to the hashmap.

  5. Completion: loop continues until all element are processed.

- Analysis:
  1. Why hashing?
  - To find a pair of numbers equals to target, it is equal to find the complement of a number (target - current).
  - Hashing provides us a way to search efficiently.
  - Benefits: `O(1)` time complexity for insertions, deletions, and search operations.
  2. What is key and value in this Map?
  - We try to find the key (complement) and return the complement (index of that number).
  - HashMap entry: `<value, array index>`
  3. Why only one pass?
  - Assume there is such pair of array `(A, B)` in the array
  - When we scan to element `A`, our map has entries of elements before `A`.
  - When we scan to element `B`, our map has entries of `A`, a pair found.
  - Therefore, we ensure that when we scan any element, if it has a paired number, then this number should be on the map.
