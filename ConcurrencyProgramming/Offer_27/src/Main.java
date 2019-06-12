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


    public static TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree == null) return null;
        if(pRootOfTree.left == null && pRootOfTree.right == null) {
        	return pRootOfTree;
        }
        TreeNode left = Convert( pRootOfTree.left);
        TreeNode  p = left;
        while(p != null && p.right != null) {
        	p = p.right;
        } 
    
        if(left != null) {
        	p.right = pRootOfTree;
        	pRootOfTree.left = p;
        }
        TreeNode right = Convert( pRootOfTree.right);
        if(right != null) {
        	pRootOfTree.right = right;
        	right.left = pRootOfTree;
        }
        return left!=null?left:pRootOfTree;
    }
    
    

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode a = new TreeNode(10);
		a.left = new TreeNode(6);
		a.left.left = new TreeNode(4);
		a.left.right = new TreeNode(8);
		a.right = new TreeNode(14);
		a.right.left = new TreeNode(12);
		a.right.right = new TreeNode(16);
		TreeNode b = Convert( a);
		System.out.println(b.val);
		System.out.println(b.right.val);
		
	}

}
