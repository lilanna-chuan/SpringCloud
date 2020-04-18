package day.day8;


import node.ListNode;

import java.util.List;

/**
 * @ClassName Solution
 * @Description DOTO
 * @Author zhulinfeng
 * @Date 2020/4/7 18:20
 * @Version 1.0
 */
public class Solution {

    public int[] twoSum(int[] nums, int target) {
        int[] arr=new int[2];
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                    arr[0]=i;
                    arr[1]=j;
                    return arr;
                }
            }
        }
        return arr;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(0);
        ListNode cursor = root;
        int tem=0;
        while (l1!=null||l2!=null|| tem!=0){
            int v1=l1!=null?l1.val:0;
            int v2=l2!=null?l2.val:0;
            int temp=v1+v2+tem;
            ListNode node=new ListNode(temp%10);
            cursor.next=node;
            cursor=node;
            if(temp>=10){
                tem=1;
            }else {
                tem=0;
            }
            if(l1!=null){
                l1=l1.next;
            }
            if(l2!=null){
                l2=l2.next;
            }
        }
        return root.next;
    }


    public int lengthOfLongestSubstring(String s) {
        String [] arr=s.split("");
        String max="";
        for(int i=0;i<arr.length;i++){
            String temp=arr[i];
            int j=i+1;
            while(j<arr.length){
                if(temp.contains(arr[j])){
                    if(max.length()<temp.length()){
                        max=temp;
                    }
                    j=arr.length;
                }else {
                    temp+=arr[j];
                    j++;
                }

            }
            if(max.length()<temp.length()){
                max=temp;
            }

        }
        return max.length();
    }

    public static void main(String[] args) {
        String s="abcabcbb";
        Solution solution=new Solution();
        System.out.println(solution.lengthOfLongestSubstring(s));

    }

    public static void main1(String[] args) {
        Solution solution=new Solution();
        ListNode l1=new ListNode(2);
        l1.next=new ListNode(4);
        l1.next.next=new ListNode(3);
        ListNode l2=new ListNode(5);
        l2.next=new ListNode(6);
        l2.next.next=new ListNode(4);

        ListNode node=solution.addTwoNumbers(l1,l2);
        while (node!=null){
            System.out.println(node.val);
            node=node.next;
        }
    }
}
