package leetcode.day8;

/**
 * @ClassName Solution
 * @Description DOTO
 * @Author zhulinfeng
 * @Date 2020/4/21 8:34
 * @Version 1.0
 */
public class Solution {


    /**
     * 1248. 统计「优美子数组」
     * 暴力求解，超时
     * @param nums
     * @param k
     * @return
     */
    public int numberOfSubarrays(int[] nums, int k) {

        if(nums.length<1 || k<1 || nums.length < k){
            return 0;
        }
        int count=0;
        for(int i=0;i<=nums.length-k;i++){
            int temp=0;
            for(int j=i;j<nums.length;j++){
                if(temp>k){
                    break;
                }
                if(nums[j]%2!=0){
                    temp++;
                }
                if(temp==k){
                    count++;
                }
            }
        }
        return count;
    }


    /**
     * 双指针，先找出为奇数的下标。然后求和
     * @param nums
     * @param k
     * @return
     */
    public int numberOfSubarrays2(int[] nums, int k) {
        if(nums.length<1 || k<1 || nums.length < k){
            return 0;
        }

        int len=nums.length;
        int res=0;
        int feed=0;
        int[] arr=new int[len+2];
        for(int i=0;i<nums.length;i++){
            if((nums[i] & 1)==1){
                feed++;
                arr[feed]=i;
            }
        }
        arr[0]=-1;
        arr[feed+1]=len;
        for(int i=1;i+k<feed+2;i++){
            res+=(arr[i]-arr[i-1])*(arr[i+k]-arr[i+k-1]);
        }
        return res;

    }

    public static void main(String[] args) {
        Solution solution= new Solution();
        int [] nums={1,1};
        System.out.println(solution.numberOfSubarrays2(nums,1));
    }
}
