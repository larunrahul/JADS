package com.learning.ads.misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/3sum/ This is an extension to
 * https://leetcode.com/problems/two-sum/
 * 
 * Given an array nums of n integers, are there elements a, b, c in nums such
 * that a + b + c = 0? Find all unique triplets in the array which gives the sum
 * of zero.
 * 
 * @author Arun Rahul
 * 
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for(int i  = 0 ; i < nums.length - 2; i++) {
            //if same element is already not used to find threeSum
            if(i == 0 || nums[i] != nums[i-1]){
                int f = i + 1, l = nums.length - 1;
                while(f < l){
                    int tsum = nums[f] + nums[l];
                    if(tsum + nums[i] == 0) {
                        result.add(Arrays.asList(nums[i], nums[f], nums[l]));
                        f++;
                        l--;
                        //ignore all elements which are same as nums[f]
                        while(f < nums.length && nums[f] == nums[f - 1]) f++;
                        //ignore all elements which are same as nums[l]
                        while(l >= 0 && nums[l] == nums[l + 1]) l--;
                    }
                    else if(tsum < -nums[i])  f++;
                    else l--;
                }
            }
        }
        return result;
    }
}