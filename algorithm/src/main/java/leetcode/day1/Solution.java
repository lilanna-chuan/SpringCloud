package leetcode.day1;

import node.ListNode;

import java.util.Stack;

/**
 * @ClassName Solution
 * @Description DOTO
 * @Author zhulinfeng
 * @Date 2020/4/14 11:18
 * @Version 1.0
 */
public class Solution {


    /**
     * 445. 两数相加 II
     * 用栈来处理
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        Stack<Integer> stack1=new Stack<>();
        Stack<Integer> stack2=new Stack<>();
        while (l1!=null){
            stack1.push(l1.val);
            l1=l1.next;
        }
        while (l2!=null){
            stack2.push(l2.val);
            l2=l2.next;
        }
        ListNode node=null;
        int a=0;
        while(!stack1.isEmpty()||!stack2.isEmpty() || a!=0){
            int val=0;
            if(stack1.isEmpty() && stack2.isEmpty()){
                val=a;
            }else if(stack1.isEmpty()){
                val=stack2.pop()+a;
            }else if(stack2.isEmpty()){
                val=stack1.pop()+a;
            }else {
                val=stack1.pop()+stack2.pop()+a;
            }
            int b=val%10;
            ListNode temp=new ListNode(b);
            a=val/10;
            temp.next=node;
            node=temp;
        }
        return node;
    }


    /**
     * 26. 删除排序数组中的重复项
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        if(nums.length<1){
            return 0;
        }else if(nums.length==1){
            return 1;
        }
        int i=1;
        int count=nums.length;
        while(i<nums.length && count>0){
            if(nums[i]==nums[i-1]){
                for(int j=i;j<nums.length-1;j++){
                    nums[j]=nums[j+1];
                }
            }else{
                i++;
            }
            count--;
        }
        for(int k=1;k<nums.length;k++){
            if(nums[k]==nums[k-1]){
                return k;
            }
        }
        return 0;

    }

    /**
     * 26. 删除排序数组中的重复项
     * 双指针
     * @param nums
     * @return
     */
    public int removeDuplicates1(int[] nums) {
        if(nums.length<=1){
            return nums.length;
        }
        int i=0;
        for(int j=1;j<nums.length;j++){
            if(nums[i]!=nums[j]){
                nums[i+1]=nums[j];
                i++;
            }
        }
        return i+1;
    }

    /**
     * 27. 移除元素
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        if(nums.length<1){
            return nums.length;
        }
        int i=0;
        for(int j=0;j<nums.length;j++){
            if(nums[j]!=val){
                nums[i]=nums[j];
                i++;
            }
        }
        return i;
    }


    /**
     * 28. 实现 strStr()
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }


    public static void main(String[] args) {
        Solution solution= new Solution();
        /*ListNode l1=new ListNode(9);
        l1.next=new ListNode(9);
        l1.next.next=new ListNode(9);
        l1.next.next.next=new ListNode(9);
        ListNode l2=new ListNode(1);
        System.out.println(solution.addTwoNumbers(l1,l2));*/

        int [] arr={1,2,3,3,4,4,3};
        System.out.println(solution.removeElement(arr,3));
    }

}
