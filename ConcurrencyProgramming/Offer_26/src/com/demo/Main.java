package com.demo;

public class Main {

	public static class RandomListNode {
	    int label;
	    RandomListNode next = null;
	    RandomListNode random = null;

	    RandomListNode(int label) {
	        this.label = label;
	    }
	}
	
	public static RandomListNode Clone1(RandomListNode pHead)
    {
		//复制链表
		RandomListNode p = pHead;
		while(p != null) {
			RandomListNode node = new RandomListNode(p.label);
			node.next = p.next;
			p.next = node;  //插入新节点
			p = node.next; //指针下移
		}


		//复制随机指针
		RandomListNode q = pHead;
		while(q != null){
			RandomListNode node2 = q.random;
			q=q.next;
			
			if(node2 == null) {
				q.random = null;
			}else {
				q.random = node2.next;
			}
			
			q = q.next;
		}
		
		//拆分
		RandomListNode w = pHead , h = pHead.next;
		RandomListNode x = w,y = h;
		while(true) {
			if(y == null) {
				break;
			}
			x.next = y.next;
			x = x.next;
			if(x == null) {
				break;
			}
			y.next = x.next;
			y = y.next;
		}
		
		
		return h;
    }
	
	public static void main(String[] args) {
		
		RandomListNode d = new RandomListNode(1);
		d.next = new RandomListNode(2);
		d.random = d.next;
		RandomListNode h =Clone1(d);
		System.out.println(h.label);
		System.out.println(h.next.label);
	}	
	
}
