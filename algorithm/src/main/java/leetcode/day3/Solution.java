package leetcode.day3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName Solution
 * @Description DOTO
 * @Author zhulinfeng
 * @Date 2020/4/16 13:14
 * @Version 1.0
 */
public class Solution {


    /**
     * 56. 合并区间
     *
     * 先排序，然后比较
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {
        if(intervals==null||intervals.length==0){
            return intervals;
        }
        List<int[]> list =new ArrayList<>();
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        int start=intervals[0][0];
        int end=intervals[0][1];
        for(int i=0;i<intervals.length;i++){
            if(intervals[i][0]>end){
                list.add(new int[]{start,end});
                start=intervals[i][0];
                end=intervals[i][1];
            }else{
                int max=intervals[i][1]<end?end:intervals[i][1];
                end=max;
            }
        }
        list.add(new int[]{start,end});
        return list.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        Solution solution= new Solution();
        int[][] arr={{1,3},{2,4}};
        System.out.println(solution.merge(arr));
    }
}
