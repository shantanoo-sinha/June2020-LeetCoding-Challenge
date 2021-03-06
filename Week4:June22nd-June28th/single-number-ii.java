/*

Reference: https://leetcode.com/problems/single-number-ii/

137. Single Number II

Given a non-empty array of integers, every element appears three times except for one, which appears exactly once. Find that single one.

Note:

Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Example 1:

Input: [2,2,3,2]
Output: 3


Example 2:

Input: [0,1,0,1,0,1,99]
Output: 99

*/
// The idea is to iterate thoughout the array and use bit manipulation.
// While iterating, extract the least significant bit of every number and calculate their sum.
// After every n (length of array) iteration, get mod 3. This will be the bit of the required number.
// Build the required number using this extracted bit.
class Solution {
    public int singleNumber(int[] nums) {
        int num = 0, sum = 0;
        for(int i=0; i<32; i++) {
            for(int j=0; j<nums.length; j++) {
                sum += ((nums[j] >> i) & 1);
            }
            sum %= 3;
            if(sum != 0)
                num |= sum << i;
            sum = 0;
        }
        return num;
    }
}
