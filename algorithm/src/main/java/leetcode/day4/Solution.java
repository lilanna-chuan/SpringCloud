package leetcode.day4;

/**
 * @ClassName Solution
 * @Description DOTO
 * @Author zhulinfeng
 * @Date 2020/4/17 12:08
 * @Version 1.0
 */
public class Solution {


    /**
     * 55. 跳跃游戏
     *从最后开始往前遍历，判断前一个位置能否到达当前位置，如果可以则替当前位置，如不可以继续找前面的位置。
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        if(nums.length<1){
            return false;
        }else if(nums.length==1){
            return true;
        }
        int n=1;
        for(int i=nums.length-2;i>=0;i--){
            if(nums[i]>=n){
                n=1;
            }else{
                n++;
            }
        }
        if(n>1){
            return false;
        }
        return true;
    }
}
