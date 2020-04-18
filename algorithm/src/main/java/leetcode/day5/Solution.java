package leetcode.day5;

public class Solution {


    /**
     * 11. 盛最多水的容器
     * 双指针算法，但是我创建了两个零时变量，内存空间占的有点多。
     * @param height
     * @return
     */
    public int maxArea(int[] height) {

        int start=0;
        int end=height.length-1;
        int max=0;
        while(start<end){
            int min=height[start]<height[end]?height[start]:height[end];
            int temp=min*(end-start);
            if(temp>max){
                max=temp;
            }
            if(height[start]<height[end]){
                start++;
            }else {
                end--;
            }
        }
        return max;
    }
}
