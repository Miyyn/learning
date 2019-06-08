package com.demo;

import java.util.HashMap;
import java.util.Map;

public class Main {
	
	public static class TreeNode {
		   int val;
		   TreeNode left;
		   TreeNode right;
		   TreeNode(int x) { val = x; }
	}

	public static TreeNode getOne(int [] pre,int [] in) {
		if(pre == null || in == null || pre.length == 0 || in.length == 0) {
			return null;
		}
		return getTwo(pre,in,0,0,pre.length-1);
	}
	
	static int max = Integer.MIN_VALUE;
	public static TreeNode getTwo(int [] pre,int [] in,int i,int L,int R) {

		if(R < L || L > R || i >= 8 || R >= 8) {
			return null;
		}
		if(i > max) {
			max=i;
		}
		int mid=-1;
		for(int k=L;k<=R;k++) {
			if(pre[i] == in[k]) {
				mid = k;
				break;
			}
		}
		TreeNode node = new TreeNode(pre[i]);
		node.left = getTwo(pre,in, i+1,L,mid-1);
		if(i < max) {
			i=max;
		}
		node.right = getTwo(pre,in, i+1,mid+1,R);
		return node;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1,2,4,7,3,5,6,8};
		int[] b = {4,7,2,1,5,3,8,6};
		
//		TreeNode node = getOne(a,b);
		TreeNode node =getO(a,b);
		System.out.println(node.val);
		System.out.println(node.left.val);
		System.out.println(node.left.left.val);
		System.out.println(node.left.left.right.val);
		System.out.println(node.right.val);
		System.out.println(node.right.left.val);
		System.out.println(node.right.right.val);
		System.out.println(node.right.right.left.val);
		
	}
	
	//------------------------------------------------------
	public static TreeNode getO(int [] pre,int [] in) {
		if(pre == null || in == null || pre.length == 0 || in.length == 0) {
			return null;
		}
		return getT(pre,0,pre.length-1,in,0,in.length-1);
	}
	
	public static TreeNode getT(int[] p,int startpre,int endpre,int[] in,int startIn,int endIn) {
	
		if(startpre > endpre || startIn > endIn) {
			return null;
		}
		TreeNode node = new TreeNode(p[startpre]);
		for(int i=startIn;i<=endIn;i++) {
			if(p[startpre] == in[i]) {
				node.left = getT( p, startpre+1, startpre+i-startIn, in, startIn, i-1);
				node.right = getT( p, startpre+i-startIn+1,endIn , in, i+1, endIn);
			}
		}
		return node;
	}
	
	

}
