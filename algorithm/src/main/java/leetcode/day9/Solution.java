package leetcode.day9;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName Solution
 * @Description DOTO
 * @Author zhulinfeng
 * @Date 2020/4/22 8:16
 * @Version 1.0
 */
public class Solution {

    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> list= new ArrayList<>();
        if(root==null){
            return list;
        }

        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size=queue.size();
            for(int i=0;i<size;i++){
                TreeNode node=queue.poll();
                if(node.left!=null){
                    queue.offer(node.left);
                }
                if(node.right!=null){
                    queue.offer(node.right);
                }
                if(i==size-1){
                    list.add(node.val);
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        Solution solution=new Solution();
        TreeNode treeNode=new TreeNode(1);
        treeNode.left=new TreeNode(2);
        treeNode.right=new TreeNode(3);
        System.out.println(solution.rightSideView(treeNode));
    }
}
