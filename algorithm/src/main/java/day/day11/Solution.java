package day.day11;

import java.util.*;

/**
 * @ClassName Solution
 * @Description DOTO
 * @Author zhulinfeng
 * @Date 2020/4/10 8:19
 * @Version 1.0
 */
public class Solution {

    public boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }
        int temp=x;
        long y=0;
        while(temp!=0){
            y=y*10+temp%10;
            temp=temp/10;
        }
        int a=(int) y;
        if(y==a && y==x){
            return true;
        }
        return false;
    }


    public int maxArea(int[] height) {

        int max=0;
        for(int i=0;i<height.length;i++){
            for( int j=i+1;j<height.length;j++){
                int min=height[i]<height[j]?height[i]:height[j];
                int temp=(j-i)*min;
                if(temp>max){
                    max=temp;
                }

            }
        }
        return max;
    }

    public int maxArea2(int[] height){
        int x=0;
        int y=height.length-1;
        int max=0;
        while(x<y){
            int temp=0;
            if(height[x]<height[y]){
                temp=(y-x)*height[x];
                x++;
            }else{
                temp=(y-x)*height[y];
                y--;
            }
            if(temp>max){
                max=temp;
            }
        }
        return max;
    }


    public String intToRoman(int num) {

        int[] nums={1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] list={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

        StringBuilder buf=new StringBuilder();
        int i=0;
        while(num>0){
            if(num-nums[i]>=0){
                buf.append(list[i]);
                num=num-nums[i];
            }else{
                i++;
            }
        }
        return buf.toString();
    }

    public int romanToInt(String s) {
        int[] nums={900,400,90,40,9,4,1000,500,100,50,10,5,1};
        String[] list={"CM","CD","XC","XL","IX","IV","M","D","C","L","X","V","I"};
        int n=0;
        for(int i=0;i<list.length;i++){
            String temp=s.replace(list[i],"");
            int count=(s.length()-temp.length())/list[i].length();
            n+=count*nums[i];
            s=temp;
        }
        return n;

    }


    /**
     * 14. 最长公共前缀
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0){
            return "";
        }
        String result="";
        for(int i=0;i<strs[0].length();i++){
            String temp=strs[0].substring(0,i+1);
            boolean flag=true;
            for(int j=0;j<strs.length;j++){
                if(strs[j].length()>i){
                    if(!strs[j].substring(0,i+1).equals(temp)){
                        flag=false;
                    }
                }else {
                    flag=false;
                }
            }
            if(flag){
                result=temp;
            }
        }
        return result;

    }


    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list=new ArrayList<>();
        if(nums.length<3){
            return list;
        }
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++){
            if(nums[i]>0){
                break;
            }if(i>0 && nums[i]==nums[i-1]){
                continue;
            }
            int left=i+1;
            int right=nums.length-1;
            while(left<right){
                int temp=nums[i]+nums[left]+nums[right];
                if(temp==0){
                    List<Integer> list1=new ArrayList<>();
                    list1.add(nums[i]);
                    list1.add(nums[left]);
                    list1.add(nums[right]);
                    list.add(list1);
                    left++;
                    while(left<nums.length &&nums[left]==nums[left-1]){
                        left++;
                    }
                    while (right>0 &&nums[right]==nums[right-1]){
                        right--;
                    }

                }else if(temp<0){
                    left++;
                }else {
                    right--;
                }
            }
        }
        return list;
    }


    /**
     * 三数之和
     * @param nums
     * @param target
     * @return
     */
    public int threeSumClosest(int[] nums, int target) {
        int result=0;
        int min=Integer.MAX_VALUE;
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++){

            int left=i+1;
            int right=nums.length-1;
            while(left<right){
                int temp=nums[i]+nums[left]+nums[right];
                if(temp==target){
                    return target;
                }else if(temp<target){
                    int t=target-temp;
                    if(min>t){
                        min=t;
                        result=temp;
                    }
                    left++;
                }else {
                    int t=temp-target;
                    if(min>t){
                        min=t;
                        result=temp;
                    }
                    right--;
                }
            }
        }
        return result;

    }



    public List<String> letterCombinations(String digits) {

        Map<Integer,String[]> map=new HashMap<>();
        map.put(2,new String[]{"a","b","c"});
        map.put(3,new String[]{"d","e","f"});
        map.put(4,new String[]{"g","h","i"});
        map.put(5,new String[]{"j","k","l"});
        map.put(6,new String[]{"m","n","o"});
        map.put(7,new String[]{"p","q","r","s"});
        map.put(8,new String[]{"t","u","v"});
        map.put(9,new String[]{"w","x","y","z"});

        List<String> list= new ArrayList<>();
        String[] arr=digits.split("");
        if(digits.isEmpty()){
            return list;
        }
        find(arr,0,"",list,map);
        return list;

    }
    public void find(String[] arr,int index,String s,List<String> list,Map<Integer,String[]> map){

        if(index==arr.length){
            list.add(s);
            return;
        }
        String[] temp=map.get(Integer.parseInt(arr[index]));
        for(int i=0;i<temp.length;i++){
            find(arr,index+1,s+temp[i],list,map);
        }

    }



    public static void main(String[] args) {
        Solution solution= new Solution();
        String[] str={"a"};
        int[] nums={0,2,1,-3};
        System.out.println(solution.threeSumClosest(nums,1));
    }




}
