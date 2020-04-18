package day.day12;

import node.ListNode;

import java.rmi.activation.ActivationDesc;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName Solution
 * @Description DOTO
 * @Author zhulinfeng
 * @Date 2020/4/13 9:15
 * @Version 1.0
 */
public class Solution {


    /**
     * 四数之和
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> lists=new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length-3;i++){
            if(i>0 &&nums[i]==nums[i-1]){
                continue;
            }
            for(int j=i+1;j<nums.length-2;j++){
                int left=j+1;
                int right=nums.length-1;
                if(j>i+1 && nums[j]==nums[j-1]){
                    continue;
                }
                while(left<right){
                    int temp=nums[i]+nums[left]+nums[right]+nums[j];
                    if(temp==target){
                        List<Integer> list1=new ArrayList<>();
                        list1.add(nums[i]);
                        list1.add(nums[left]);
                        list1.add(nums[right]);
                        list1.add(nums[j]);
                        lists.add(list1);
                        left++;
                        while(left<nums.length &&nums[left]==nums[left-1]){
                            left++;
                        }
                        while (right>0 &&nums[right]==nums[right-1]){
                            right--;
                        }

                    }else if(temp<target){
                        left++;
                    }else {
                        right--;
                    }
                }
            }
        }
        return lists;
    }


    /**
     * 删除链表的倒数第n 个节点
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode node=new ListNode(0);
        node.next=head;
        int length=0;
        ListNode first=head;
        while(first!=null){
            length++;
            first=first.next;
        }
        first=node;
        for(int i=0;i<length-n;i++){
            first=first.next;
        }
        first.next=first.next.next;
        return node.next;
    }
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode node=new ListNode(0);
        node.next=head;
        ListNode first=node;
        ListNode second=node;
        for(int i=0;i<=n;i++){
            first=first.next;
        }
        while(first!=null){
            first=first.next;
            second=second.next;
        }
        second.next=second.next.next;
        return node.next;
    }


    /**
     * 有效的括号
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        if(s==null ||s.isEmpty()){
            return true;
        }
        Stack<String> stack=new Stack<>();
        String[] arr=s.split("");
        for(int i=0;i<arr.length;i++){
            if(arr[i].equals("[") || arr[i].equals("(")|| arr[i].equals("{")){
                stack.push(arr[i]);
            }else if(!stack.isEmpty() && ((arr[i].equals(")") && stack.peek().equals("(")) ||(arr[i].equals("]") && stack.peek().equals("[")) || (arr[i].equals("}") && stack.peek().equals("{")))){
               stack.pop();
            }else {
                return  false;
            }
        }
        if(stack.isEmpty()){
            return true;
        }
        return false;
    }

    /**
     * 挂号生成
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        List<String> list=new ArrayList<>();
        if(n<=0){
            return list;
        }
        help(1,n,"(",list);
        return list;
    }
    public void help(int index,int n,String str,List<String> list){
        if(index==n*2){
            if(isValid(str)){
                list.add(str);
            }
        }else {
            help(index+1,n,str+"(",list);
            help(index+1,n,str+")",list);
        }
    }


    /**
     * 合并两个有序的链表
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode root=new ListNode(0);
        ListNode node=root;
        while(l1!=null||l2!=null){
            if(l1==null){
                node.next=l2;
                break;
            }else if(l2==null){
                node.next=l1;
                break;
            }else if(l1.val<l2.val){
                node.next=l1;
                l1=l1.next;
            }else {
                node.next=l2;
                l2=l2.next;
            }
            node=node.next;
        }
        return root.next;

    }


    /**
     * 两两交换链表中的节点
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        ListNode root=new ListNode(0);
        root.next=head;
        ListNode preNode=root;
        while(head!=null && head.next!=null){
            ListNode firstNode=head;
            ListNode secondNode=head.next;

            preNode.next=secondNode;
            firstNode.next=secondNode.next;
            secondNode.next=firstNode;

            preNode=firstNode;
            head=firstNode.next;

        }
        return root.next;
    }





    public static void main(String[] args) {
        Solution solution= new Solution();
        //int[] nums={0,0,0,0};
        //System.out.println(solution.fourSum(nums,0));
        //System.out.println(solution.isValid("}}"));
        /*ListNode l1=new ListNode(1);
        l1.next=new ListNode(2);
        l1.next.next=new ListNode(4);
        ListNode l2=new ListNode(1);
        l2.next=new ListNode(3);
        l2.next.next=new ListNode(4);
        System.out.println(solution.mergeTwoLists(l1,l2));*/

        //System.out.println(solution.generateParenthesis(3));

        ListNode node=new ListNode(1);
        node.next=new ListNode(2);
        node.next.next=new ListNode(3);
        node.next.next.next=new ListNode(4);
        System.out.println(solution.swapPairs(node));

    }
}
