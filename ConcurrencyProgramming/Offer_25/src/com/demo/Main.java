package com.demo;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    public TreeNode(int val) {
	        this.val = val;

	    }

	}
	
	public static ArrayList<ArrayList<Integer>> listAll = new ArrayList<>();
    public static ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
       
        if(root == null || target ==0){
            return listAll;
        }
        ArrayList<TreeNode> list = new ArrayList<>();
        dg(root,target,list);
        return listAll;
    }
    
    
    
    public static void dg(TreeNode root,int target,ArrayList<TreeNode> list){
    	if(root == null) {
    		return;
    	}
        list.add(root);
        if(root.left == null && root.right == null){
            int sum=0;
            for(int i=0;i<list.size();i++){
                sum += list.get(i).val;
            }
            System.out.println(sum);
            if(sum == target){
                ArrayList<Integer> list2 = new ArrayList<>();
                for(int i=0;i<list.size();i++){
                    list2.add(list.get(i).val);
                }
                listAll.add(list2);
            }
            
        }
        
        dg(root.left,target,list);
        dg(root.right,target,list);
        list.remove(list.size()-1);
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(5);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(7);
		root.right = new TreeNode(12);
		
		FindPath(root,22);
		for(ArrayList<Integer> list:listAll) {
			for(int i:list) {
				System.out.print(i);
			}
			System.out.println();
		}
	}

}
